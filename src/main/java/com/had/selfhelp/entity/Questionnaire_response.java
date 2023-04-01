package com.had.selfhelp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questionnnaire_response")
public class Questionnaire_response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int questionnnaire_response_id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Questionnaire question;
	
	@Column(name = "answer")
	private int answer;
	
	public Questionnaire_response() {
		
	}

	public Questionnaire_response(Patient patient, Questionnaire question, int answer) {
		this.patient = patient;
		this.question = question;
		this.answer = answer;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Questionnaire getQuestion() {
		return question;
	}

	public void setQuestion(Questionnaire question) {
		this.question = question;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Questionnaire_response [patient=" + patient + ", question=" + question + ", answer=" + answer + "]";
	}
	
}
