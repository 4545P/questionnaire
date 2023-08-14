package com.example.questionnaire.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Option;

@Repository
public interface OptionDao extends JpaRepository<Option, String>{
		  
	@Transactional
	public void deleteByQuestionnaireId(Integer questionnaireId);	

	
}
