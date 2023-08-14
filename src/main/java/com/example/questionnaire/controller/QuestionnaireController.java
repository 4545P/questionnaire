package com.example.questionnaire.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.service.ifs.QuestionnaireService;
import com.example.questionnaire.vo.request.PageRequest;
import com.example.questionnaire.vo.request.QuestionnaireRequest;
import com.example.questionnaire.vo.response.QuestionnaireResponse;

@RestController
public class QuestionnaireController {

	@Autowired
	private QuestionnaireService questionnaireService;

	// 連接資料庫
	@PostMapping("/api/getQuestionnaire")
	public List<Map<String, Object>> getQuestionnaire(@RequestBody PageRequest pageRequest) {
		return questionnaireService.getQuestionnaire(pageRequest.getPage(), pageRequest.getLimit(),
				pageRequest.getTitle(), pageRequest.getDate(), pageRequest.getEndDate());
	}

	// 建立問卷
	@PostMapping("/api/saveQuestionnaire")
	public void saveQuestionnaire(@RequestBody QuestionnaireRequest questionnaireRequest) {
		questionnaireService.saveQuestionnaire(questionnaireRequest);
	}

	// 刪除問卷
	@PostMapping("/api/deleteQuestionnaire")
	public QuestionnaireResponse deleteQuestionnaire(@RequestBody QuestionnaireRequest questionnaireRequest) {
		return questionnaireService.deleteQuestionnaire(questionnaireRequest.getId());
	}

}
