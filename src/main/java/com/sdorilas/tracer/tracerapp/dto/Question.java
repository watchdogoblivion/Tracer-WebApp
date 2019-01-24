package com.sdorilas.tracer.tracerapp.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String question;
	private LocalDateTime dateTime; 
	
	@OneToMany(mappedBy="question")
    private List<Reply> replies = new ArrayList<>();
	
	@OneToMany(mappedBy="question")
    private List<Answer> answers = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name="username", nullable=false)
    private User user;

	public Question() {
	}

	public Question(String question) {
		this.question = question;
	}

	public Question(User user, String question, List<Reply> replies, List<Answer> answers) {
		this.user = user;
		this.question = question;
		this.replies = replies;
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [question=" + question + "]";
	}
	
	public String toString2() {
		return "Question [question=" + question + ", replies=" + replies + ", answers=" + answers + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
