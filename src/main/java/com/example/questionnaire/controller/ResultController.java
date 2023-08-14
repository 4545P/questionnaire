package com.example.questionnaire.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.service.ifs.ResultService;
import com.example.questionnaire.vo.request.QuestionnaireRequest;
import com.example.questionnaire.vo.request.ResultRequest;


@CrossOrigin
@RestController
public class ResultController {
	
	@Autowired
	private ResultService resultService;

	 @PostMapping("/api/resultQuestionnaire")
	    public List<Map<String, Object>> resultQuestionnaire(@RequestBody QuestionnaireRequest questionnaireRequest) {
	        return resultService.resultQuestionnaire(questionnaireRequest.getId());
	    }
	 
	@PostMapping("/api/recordOptionSelection")
	public ResponseEntity<String> recordOptionSelection(@RequestBody ResultRequest resultRequest) {
		// 在这里处理接收到的JSON数据，将问卷ID、问题ID和选项ID等信息插入到数据库表中
		// 请根据具体的需求和数据库配置来实现这部分逻辑
		return ResponseEntity.ok("Option selection recorded successfully.");
	}
	
//	 @GetMapping("/api/statistics")
//	    public ResponseEntity<List<ResultRequest>> getOptionStatistics() {
//	        // 向StatisticsService请求统计数据
//	        List<ResultRequest> statistics = ResultService.calculateOptionStatistics();
//	        return ResponseEntity.ok(statistics);
//	    }
	
//	@GetMapping("/api/questionnaire/{questionnaireId}/questions")
//    public ResponseEntity<List<Question>> getQuestionsForQuestionnaire(@PathVariable Integer questionnaireId) {
//        // 根据问卷ID从数据库获取问题数据，并返回给前端
//        List<Question> questions = questionnaireService.getQuestionsByQuestionnaireId(questionnaireId);
//        return ResponseEntity.ok(questions);
//    }
}
