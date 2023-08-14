package com.example.questionnaire.vo.request;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionnaireRequest {
	
	public List<QuestionRequest> itemList;
	
	public Integer id;

	public String title;

	public LocalDateTime date;

	public LocalDateTime endDate;

	public QuestionnaireRequest() {
		super();
	}

	public QuestionnaireRequest(Integer id, String title, LocalDateTime date, LocalDateTime endDate) {
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

	public List<QuestionRequest> getItemList() {
		return itemList;
	}

	public void setItemList(List<QuestionRequest> itemList) {
		this.itemList = itemList;
	}

}
