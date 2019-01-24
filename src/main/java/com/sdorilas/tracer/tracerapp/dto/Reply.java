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
@Table(name="replies")
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String reply;
	private LocalDateTime dateTime; 
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
    private Question question;
	
	@ManyToOne
    @JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
    private User user;
	
	public Reply() {
	}
	public Reply(String reply) {
		this.reply = reply;
	}
	
	public Reply(User user, Question question, String reply) {
		this.user = user;
		this.question = question;
		this.reply = reply;
	}
	
	@Override
	public String toString() {
		return "Reply [reply=" + reply + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
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
