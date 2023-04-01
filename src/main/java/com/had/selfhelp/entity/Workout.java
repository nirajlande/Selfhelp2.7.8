package com.had.selfhelp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "workout")
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int workout_id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workout")
	private List<Workout_question> questions;
	
	public Workout() {
		
	}

	public Workout(int workout_id, String title, String description, List<Workout_question> questions) {
		this.workout_id = workout_id;
		this.title = title;
		this.description = description;
		this.questions = questions;
	}

	public List<Workout_question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Workout_question> questions) {
		this.questions = questions;
	}

	public int getWorkout_id() {
		return workout_id;
	}

	public void setWorkout_id(int workout_id) {
		this.workout_id = workout_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Workout [workout_id=" + workout_id + ", title=" + title + ", description=" + description
				+ ", questions=" + questions + "]";
	}
	
}
