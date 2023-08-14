package com.example.questionnaire.vo.response;

import java.time.LocalDateTime;
import java.util.List;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;

public class QuestionnaireResponse {

	private Questionnaire questionnaire;

	private Integer id;

	private String title;

	private LocalDateTime date;

	private LocalDateTime endDate;

	private List<Question> question;

	private String message;

	private int page;

	private int limit;

	public QuestionnaireResponse() {
		super();
	}

	public QuestionnaireResponse(Questionnaire questionnaire, Integer id, String title, LocalDateTime date,
			LocalDateTime endDate, List<Question> question, String message) {
		super();
		this.questionnaire = questionnaire;
		this.id = id;
		this.title = title;
		this.date = date;
		this.endDate = endDate;
		this.question = question;
		this.message = message;
	}

	public QuestionnaireResponse(String message) {
		super();
		this.message = message;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer integer) {
		this.id = integer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> list) {
		this.question = list;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
