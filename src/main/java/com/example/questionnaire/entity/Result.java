package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "Result")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "questionnaire_id")
	private Questionnaire questionnaire;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@ManyToOne
	@JoinColumn(name = "option_id")
	private Option option;

	public Result() {
		
	}

	public Result(Integer id, Questionnaire questionnaire, Question question, Option option) {
		super();
		this.id = id;
		this.questionnaire = questionnaire;
		this.question = question;
		this.option = option;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

}
