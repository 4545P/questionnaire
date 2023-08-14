package com.example.questionnaire.repository;


import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire.entity.Questionnaire;

public interface QuestionnaireDao extends JpaRepository<Questionnaire, String> {

	@Transactional
	public void deleteById(Integer questionnaireId);

	public Questionnaire findById(Integer integer);

	public Questionnaire findQuestionnaireById(Integer questionnaireId);
	
	public Page<Questionnaire> findAll(Pageable pageable);

	public Page<Questionnaire> findByTitleContainingIgnoreCase(String title, PageRequest pageRequest);

	public long countByTitleContainingIgnoreCase(String title);

	public Page<Questionnaire> findByDateBetween(LocalDateTime date, LocalDateTime endDate, PageRequest pageRequest);

	public long countByDateBetween(LocalDateTime date, LocalDateTime endDate);

	public Page<Questionnaire> findByTitleContainingIgnoreCaseAndDateBetween(String title, LocalDateTime date,
			LocalDateTime endDate, PageRequest pageRequest);

	public long countByTitleContainingIgnoreCaseAndDateBetween(String title, LocalDateTime date, LocalDateTime endDate);

}
