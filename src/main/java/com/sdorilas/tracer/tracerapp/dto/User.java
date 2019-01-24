package com.sdorilas.tracer.tracerapp.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="users")
public class User {
  
	@Id
    private String username;
	private String firstName;
	private String lastName;
	private String email;
    private String password;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
 
    @OneToMany(mappedBy="user")
    private List<Authority> authorities = new ArrayList<>();
    
    @OneToMany(mappedBy="user")
    private List<Question> questions = new ArrayList<>();
    
    @OneToMany(mappedBy="user")
    private List<Answer> answers = new ArrayList<>();
    
    @OneToMany(mappedBy="user")
    private List<Reply> replies = new ArrayList<>();
    
    public User(String username, String password, List<Authority> authorities) {
		super();
		this.setUsername(username);
		this.setPassword(password);
		this.setAuthorities(authorities);
	}
    
    public User(String username, String firstName, String lastName, String email, String password) {
		super();
		this.setUsername(username);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
	}

	public User() {
	}
    
	@Override
	public String toString() {
		return "User [username=" + username + ", first name=" + firstName + ", last name=" + lastName + ", email="
				+ email + ", password=" + password + ", enabled=" + enabled + ", accountNonExpired=" + accountNonExpired
				+ ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired + "]";
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public String[] getRoles(List<Authority> authorities) {
		String[] roles_String= {};
		for(int i = 0; i < authorities.size(); i++) {
			roles_String[i] = authorities.get(i).getAuthority();
		}
		return roles_String;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder(12).encode(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	
}
