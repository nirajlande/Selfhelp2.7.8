package com.had.selfhelp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.had.selfhelp.entity.Questionnaire;

public interface QuestionnaireRepo extends JpaRepository<Questionnaire, Integer> {

}
