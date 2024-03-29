package com.example.questionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.questionnaire"})
public class QuestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireApplication.class, args);
	}
		
}
