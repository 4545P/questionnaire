package com.example.questionnaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire.entity.Result;

public interface ResultDao extends JpaRepository<Result, String>{

	public List<Result> findByQuestionnaireId(Integer questionnaireId);

//	public List<Result> findAllByQuestionnaireId(Integer resultId);

}
