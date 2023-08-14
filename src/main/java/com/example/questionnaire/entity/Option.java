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
@Table(name = "Options")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Option {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;

	
    
	public Option() {
		super();
	}
	
	public Option(Integer id, String content, Question question) {
		super();
		this.id = id;
		this.content = content;
		this.question = question;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	
}