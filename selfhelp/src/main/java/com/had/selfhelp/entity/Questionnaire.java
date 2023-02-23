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

	public Questionnaire() {
		
	}
	
	public Questionnaire(int qid, String description) {
		this.qid = qid;
		this.description = description;
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

	@Override
	public String toString() {
		return "Questionnaire [qid=" + qid + ", description=" + description + "]";
	}
	
	
}
