package com.had.selfhelp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workout_question_response")
public class Workout_question_response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int workout_question_response_id;
	
	@ManyToOne
	@JoinColumn(name = "workout_question_id")
	private Workout_question workout_question;
	
	@Column(name = "response")
	private String response;
	
	@ManyToOne
	@JoinColumn(name = "workout_instance_id")
	private Workout_instance workout_instance;
	
	public Workout_question_response() {

	}

	public Workout_question_response(int workout_question_response_id, Workout_question workout_question,
			String response, Workout_instance workout_instance) {
		this.workout_question_response_id = workout_question_response_id;
		this.workout_question = workout_question;
		this.response = response;
		this.workout_instance = workout_instance;
	}

	public int getWorkout_question_response_id() {
		return workout_question_response_id;
	}

	public void setWorkout_question_response_id(int workout_question_response_id) {
		this.workout_question_response_id = workout_question_response_id;
	}

	public Workout_question getWorkout_question() {
		return workout_question;
	}

	public void setWorkout_question(Workout_question workout_question) {
		this.workout_question = workout_question;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Workout_instance getWorkout_instance() {
		return workout_instance;
	}

	public void setWorkout_instance(Workout_instance workout_instance) {
		this.workout_instance = workout_instance;
	}

	@Override
	public String toString() {
		return "Workout_question_response [workout_question_response_id=" + workout_question_response_id
				+ ", workout_question=" + workout_question + ", response=" + response + ", workout_instance="
				+ workout_instance + "]";
	}
	
}
