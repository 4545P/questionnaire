package com.example.questionnaire.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@Entity
@Table(name = "Questionnaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Questionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "date")
	private LocalDateTime date;

	@Column(name = "enddate")
	private LocalDateTime endDate;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
    private List<Question> question;
	
	public Questionnaire() {
		super();
	}

	public Questionnaire(Integer id, String title, LocalDateTime date, LocalDateTime endDate) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	
	
}
