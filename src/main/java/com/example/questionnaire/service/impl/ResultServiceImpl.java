package com.example.questionnaire.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionnaire.entity.Result;
import com.example.questionnaire.repository.ResultDao;
import com.example.questionnaire.service.ifs.ResultService;

@Service
public class ResultServiceImpl implements ResultService {
	
	 @Autowired
	    private ResultDao resultDao;

	 public List<Map<String, Object>> resultQuestionnaire(Integer resultId) {
		 
		 List<Map<String, Object>> statistics = new ArrayList<>();

	        // 从数据库中获取特定问卷的所有问卷结果数据
	        List<Result> results = resultDao.findByQuestionnaireId(resultId);

	        // 使用Map统计每个选项的选择次数，使用选项的ID作为Map的键
	        Map<Integer, Integer> optionCountMap = new HashMap<>();
	        for (Result result : results) {
	            Integer optionId = result.getOption().getId(); // 获取选项的ID
	            optionCountMap.put(optionId, optionCountMap.getOrDefault(optionId, 0) + 1);
	        }

	        // 将统计结果转换成前端需要的格式
	        for (Map.Entry<Integer, Integer> entry : optionCountMap.entrySet()) {
	            Map<String, Object> statistic = new HashMap<>();
	            statistic.put("value", entry.getValue());
	            statistic.put("name", "Option " + entry.getKey());
	            statistics.add(statistic);
	        }

	        return statistics;
	    }		
	 
	// 記錄數據
//	@Override
//	public QuestionnaireResponse resultQuestionnaire(Integer questionnaireId, Integer questionId, Integer optionId) {
//		
//		return new QuestionnaireResponse(RtnCode.SUCCESSFUL.getCode() + " " + RtnCode.SUCCESSFUL.getMessage());
//	}
	
	

}
