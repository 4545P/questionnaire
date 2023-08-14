package com.example.questionnaire.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "Question")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "questionnaire_id")
	private Questionnaire questionnaire;

	@Column(name = "type")
	private String type;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private List<Option> option;

	public Question() {
		super();
	}

	public Question(Integer id, Questionnaire questionnaire, String type) {
		super();
		this.id = id;
		this.questionnaire = questionnaire;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}
	
}
