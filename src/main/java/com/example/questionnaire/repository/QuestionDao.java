package com.example.questionnaire.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;

public interface QuestionDao extends JpaRepository<Question, String> {

	public Questionnaire findById(Integer questionnaireId);
	
	public Object findQuestionIdsByQuestionnaireId(Integer questionnaireId);

	@Transactional
	public void deleteByQuestionnaireId(Integer questionnaireId);	

}
