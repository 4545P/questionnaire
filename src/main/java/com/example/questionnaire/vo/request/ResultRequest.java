package com.example.questionnaire.vo.request;

public class ResultRequest {

	private Integer id;

	private Integer questionnaireId;

	private Integer questionId;

	private Integer optionId;

	public ResultRequest() {

	}

	public ResultRequest(Integer id, Integer questionnaireId, Integer questionId, Integer optionId) {
		super();
		this.id = id;
		this.questionnaireId = questionnaireId;
		this.questionId = questionId;
		this.optionId = optionId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

}
