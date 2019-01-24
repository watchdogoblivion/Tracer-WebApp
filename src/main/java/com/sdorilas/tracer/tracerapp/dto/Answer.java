package com.sdorilas.tracer.tracerapp.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String answer;
	private LocalDateTime dateTime; 
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
    private Question question;
	
	@ManyToOne
    @JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
    private User user;
	
	public Answer() {
	}
	public Answer(String answer) {
		this.answer = answer;
	}
	public Answer(User user, Question question, String answer) {
		this.user = user;
		this.question = question;
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [answer=" + answer + "]";
	}
	public String toString2() {
		return "Answer [answer=" + answer + ", question=" + question + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
