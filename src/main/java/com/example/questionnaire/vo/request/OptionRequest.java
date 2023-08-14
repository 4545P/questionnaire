package com.example.questionnaire.vo.request;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;

public class OptionRequest {

	public Integer id;

	public Question question;

	public String content;
	
	public Questionnaire questionnaire;

	public OptionRequest() {
		super();
	}

	public OptionRequest(Integer id, Question question, String content, Questionnaire questionnaire) {
		super();
		this.id = id;
		this.question = question;
		this.content = content;
		this.questionnaire = questionnaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	

}