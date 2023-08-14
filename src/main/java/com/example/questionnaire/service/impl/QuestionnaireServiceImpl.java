package com.example.questionnaire.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.Option;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.OptionDao;
import com.example.questionnaire.repository.QuestionDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuestionnaireService;
import com.example.questionnaire.vo.request.QuestionRequest;
import com.example.questionnaire.vo.request.QuestionnaireRequest;
import com.example.questionnaire.vo.response.QuestionnaireResponse;

@SpringBootApplication
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireDao questionnaireDao;

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private OptionDao optionDao;
	
	// 建立问卷
	@Override
	public QuestionnaireResponse saveQuestionnaire(QuestionnaireRequest questionnaireRequest) {

		// 提取问卷数据
		String title = questionnaireRequest.getTitle();
		LocalDateTime date = questionnaireRequest.getDate();
		LocalDateTime endDate = questionnaireRequest.getEndDate();
		List<QuestionRequest> itemList = questionnaireRequest.getItemList();

		// 建立问卷对象
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setTitle(title);
		questionnaire.setDate(date);
		questionnaire.setEndDate(endDate);

		// 建立问卷对象并保存到数据库
		Questionnaire savedQuestionnaire = questionnaireDao.save(questionnaire);

		// 建立问题列表
		List<Question> savedQuestions = new ArrayList<>();
		for (QuestionRequest questionRequest : itemList) {
			String type = questionRequest.getType();
			List<String> textList = questionRequest.getTextList();

			// 建立问题对象
			Question question = new Question();
			question.setType(type);
			question.setQuestionnaire(savedQuestionnaire); // 设置问题关联的问卷对象

			// 先保存问题到数据库，获取持久化后的对象
			Question savedQuestion = questionDao.save(question);

			// 建立选项列表
			List<Option> savedOptions = new ArrayList<>();
			if (textList == null || textList.isEmpty()) {
				textList = Collections.singletonList("填空"); // 将列表设置为包含一个默认选项内容的单元素列表
			}

			for (String optionContent : textList) {
				// 建立选项对象
				Option option = new Option();
				option.setContent(optionContent);
				option.setQuestion(savedQuestion); // 设置选项关联的问题对象
				option.setQuestionnaire(savedQuestionnaire);

				// 保存选项到数据库
				Option savedOption = optionDao.save(option);

				// 将选项添加到选项列表中
				savedOptions.add(savedOption);
			}

			// 将选项列表设置到问题对象
			savedQuestion.setOption(savedOptions);

			// 保存问题到数据库
			savedQuestions.add(savedQuestion);
		}

		// 将问题列表设置到问卷对象
		savedQuestionnaire.setQuestion(savedQuestions);

		// 更新问卷对象到数据库
		Questionnaire updatedQuestionnaire = questionnaireDao.save(savedQuestionnaire);

		// 建立回应对象
		QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();
		questionnaireResponse.setId(updatedQuestionnaire.getId());
		questionnaireResponse.setTitle(updatedQuestionnaire.getTitle());
		questionnaireResponse.setDate(updatedQuestionnaire.getDate());
		questionnaireResponse.setEndDate(updatedQuestionnaire.getEndDate());
		questionnaireResponse.setQuestion(updatedQuestionnaire.getQuestion());

		return questionnaireResponse;
	}
	
	
	// 刪除問卷
//	@Transactional
	@Override
	public QuestionnaireResponse deleteQuestionnaire(Integer questionnaireId) {
	    
		// 删除与问卷关联的问题
		optionDao.deleteByQuestionnaireId(questionnaireId);
		
		questionDao.deleteByQuestionnaireId(questionnaireId);

		// 删除问卷
		questionnaireDao.deleteById(questionnaireId);
	    
		return new QuestionnaireResponse(RtnCode.SUCCESSFUL.getCode() + " " + RtnCode.SUCCESSFUL.getMessage());
	}

	// get問卷
	@Override
	public List<Map<String, Object>> getQuestionnaire(int page, int limit, 
			@RequestParam(required = false) String title,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime date,
		    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime endDate) {
		
		  // 从数据库获取问卷数据（根据分页参数和可选的 title 进行查询）
	    PageRequest pageRequest = PageRequest.of(page - 1, limit); // 转换为从1开始的页码

	    Page<Questionnaire> questionnairePage;
	    long totalElements;
		
	    Optional<String> optionalTitle = Optional.ofNullable(title);
        Optional<LocalDateTime> optionalDate = Optional.ofNullable(date);
        Optional<LocalDateTime> optionalEndDate = Optional.ofNullable(endDate);


        if (optionalTitle.isPresent() && optionalDate.isPresent() && optionalEndDate.isPresent()) {
            // 如果传入了 title 和日期参数，则进行模糊搜尋和日期範圍搜尋
            questionnairePage = questionnaireDao.findByTitleContainingIgnoreCaseAndDateBetween(title, date, endDate, pageRequest);
            totalElements = questionnaireDao.countByTitleContainingIgnoreCaseAndDateBetween(title, date, endDate);
        } else if (optionalTitle.isPresent()) {
            // 如果只传入了 title 参数，则进行模糊搜尋
            questionnairePage = questionnaireDao.findByTitleContainingIgnoreCase(title, pageRequest);
            totalElements = questionnaireDao.countByTitleContainingIgnoreCase(title);
        } else if (optionalDate.isPresent() && optionalEndDate.isPresent()) {
            // 如果只传入了日期参数，则进行日期範圍搜尋
            questionnairePage = questionnaireDao.findByDateBetween(date, endDate, pageRequest);
            totalElements = questionnaireDao.countByDateBetween(date, endDate);
        } else if (optionalEndDate.isPresent()) {
            // 如果只传入了結束時間而沒有開始時間，將開始時間設定為無限小（或者設定為一個合理的過去日期）
            LocalDateTime infiniteStartDate = LocalDateTime.of(1970, 1, 1, 0, 0, 0); // 1970年1月1日0:00:00
            questionnairePage = questionnaireDao.findByDateBetween(infiniteStartDate, endDate, pageRequest);
            totalElements = questionnaireDao.countByDateBetween(infiniteStartDate, endDate);
        } else if (date != null) {
            // 如果只传入了起始時間而沒有結束時間，將結束時間設定為無限大（或者設定為一個合理的未來日期）
            LocalDateTime infiniteEndDate = LocalDateTime.of(9999, 12, 31, 23, 59, 59); // 9999年12月31日23:59:59
            questionnairePage = questionnaireDao.findByDateBetween(date, infiniteEndDate, pageRequest);
            totalElements = questionnaireDao.countByDateBetween(date, infiniteEndDate);
        } else {
            // 如果没有传入任何参数，则查询所有问卷
            questionnairePage = questionnaireDao.findAll(pageRequest);
            totalElements = questionnairePage.getTotalElements();
        }
        
	    List<Questionnaire> questionnaires = questionnairePage.getContent(); // 获取当前页的问卷数据

	    List<Map<String, Object>> responses = new ArrayList<>();

	    for (Questionnaire questionnaire : questionnaires) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("id", questionnaire.getId());
	        response.put("title", questionnaire.getTitle());
	        response.put("date", questionnaire.getDate());
	        response.put("endDate", questionnaire.getEndDate());

	        responses.add(response);
	    }

	    Map<String, Object> result = new HashMap<>();
	    result.put("list", responses);
	    result.put("total", totalElements);

	    List<Map<String, Object>> resultList = new ArrayList<>();
	    resultList.add(result);

	    return resultList;
	}


//	@Override
//	public List<Question> getQuestionsByQuestionnaireId(Integer questionnaireId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
