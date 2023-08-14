package com.example.questionnaire.service.ifs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.questionnaire.vo.request.QuestionnaireRequest;
import com.example.questionnaire.vo.response.QuestionnaireResponse;

public interface QuestionnaireService {
	
    public QuestionnaireResponse deleteQuestionnaire(Integer questionnaireId);

    public QuestionnaireResponse saveQuestionnaire(QuestionnaireRequest questionnaireRequest);

	public List<Map<String, Object>> getQuestionnaire(int page, int limit, String title, LocalDateTime date, LocalDateTime endDate);


	
}
