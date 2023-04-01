package com.had.selfhelp.service;

import java.util.List;

import com.had.selfhelp.entity.Patient;
import com.had.selfhelp.entity.Questionnaire;
import com.had.selfhelp.entity.Questionnaire_response;

public interface PatientService {

	public void save(Patient thePatient);
	
	public void saveResponses(List<Questionnaire_response> patientResponse, int patient_id);
	
	public List<Questionnaire> getQuestions();
	
	public List<Questionnaire_response> getResponses(int patientId);
	
	public Patient login(Patient P);
}
