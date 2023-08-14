package com.example.questionnaire.vo.request;

import java.time.LocalDateTime;

public class PageRequest {

	private int page;

	private int limit;

	private String title;

	private LocalDateTime date;

	private LocalDateTime endDate;

	public PageRequest() {

	}

	public PageRequest(int page, int limit, String title, LocalDateTime date, LocalDateTime endDate) {
		super();
		this.page = page;
		this.limit = limit;
		this.title = title;
		this.date = date;
		this.endDate = endDate;
	}

	public PageRequest(int page, int limit, String title) {
		super();
		this.page = page;
		this.limit = limit;
		this.title = title;
	}

	public PageRequest(int page, int limit) {
		super();
		this.page = page;
		this.limit = limit;
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

}
