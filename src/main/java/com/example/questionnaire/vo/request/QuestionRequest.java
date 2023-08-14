package com.example.questionnaire.vo.request;

import java.util.List;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;

public class QuestionRequest {

	public List<Question> itemList;

	public List<String> textList;

	public Integer id;

	public Questionnaire questionnaire;

	public String type;

	
	public QuestionRequest() {
		super();
	}

	public QuestionRequest(List<Question> itemList, List<String> textList, Integer id, Questionnaire questionnaire,
			String type) {
		super();
		this.itemList = itemList;
		this.textList = textList;
		this.id = id;
		this.questionnaire = questionnaire;
		this.type = type;
		}

	public QuestionRequest(List<Question> itemList, String type) {
		super();
		this.itemList = itemList;
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

	
	public List<Question> getItemList() {
		return itemList;
	}

	public void setItemList(List<Question> itemList) {
		this.itemList = itemList;
	}

	public List<String> getTextList() {
		return textList;
	}

	public void setTextList(List<String> textList) {
		this.textList = textList;
	}

}
