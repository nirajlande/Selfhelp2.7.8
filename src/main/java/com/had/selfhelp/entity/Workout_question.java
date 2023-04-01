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
@Table(name = "workout_question")
public class Workout_question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int workout_question_id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "workout_id")
	private Workout workout;
	
	@Column(name = "question")
	private String question;
	
	public Workout_question() {

	}
	
	public Workout_question(int workout_question_id, Workout workout, String question) {
		this.workout_question_id = workout_question_id;
		this.workout = workout;
		this.question = question;
	}

	public int getWorkout_question_id() {
		return workout_question_id;
	}

	public void setWorkout_question_id(int workout_question_id) {
		this.workout_question_id = workout_question_id;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Workout_question [workout_question_id=" + workout_question_id + ", workout=" + workout + ", question="
				+ question + "]";
	}
	
	
}
