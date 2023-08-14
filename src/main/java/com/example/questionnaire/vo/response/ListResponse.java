package com.example.questionnaire.vo.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponse {

	public String title;

	private LocalDateTime date;

	private LocalDateTime endDate;
	
	private List<ListResponse> data;
	
	private Integer currentPage;
	
	private Integer pageSize;
	
	private Integer total;
	
	public ListResponse() {
		super();
	}

	public ListResponse(String title, LocalDateTime date, LocalDateTime endDate, List<ListResponse> data,
			Integer currentPage, Integer pageSize, Integer total) {
		super();
		this.title = title;
		this.date = date;
		this.endDate = endDate;
		this.data = data;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
	}




	public ListResponse(String title, LocalDateTime date, LocalDateTime endDate) {
		super();
		this.title = title;
		this.date = date;
		this.endDate = endDate;
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



	public List<ListResponse> getData() {
		return data;
	}



	public void setData(List<ListResponse> data) {
		this.data = data;
	}



	public Integer getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public Integer getTotal() {
		return total;
	}



	public void setTotal(Integer total) {
		this.total = total;
	}

	
}
