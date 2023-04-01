package com.had.selfhelp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.entity.Questionnaire_response;

public interface Questionnaire_Response_Repo extends JpaRepository<Questionnaire_response, Integer> {

	List<Questionnaire_response> findByPatient(Patient P);
	
}
