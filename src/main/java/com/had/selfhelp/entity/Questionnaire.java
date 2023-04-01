package com.had.selfhelp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int qid;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "weightage")
	private int weightage;

	public Questionnaire() {
		
	}
	
	public Questionnaire(int qid, String description, int weightage) {
		this.qid = qid;
		this.description = description;
		this.weightage = weightage;
	}

	public int getQid() {
		return qid;
	}

	public String getDescription() {
		return description;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeightage() {
		return weightage;
	}

	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}

	@Override
	public String toString() {
		return "Questionnaire [qid=" + qid + ", description=" + description + ", weightage=" + weightage + "]";
	}
	
}
