package com.sdorilas.tracer.tracerapp.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
  
	@Id
    private String username;
	private String first_name;
	private String last_name;
	private String email;
    private String password;
    private boolean enabled = true;;
 
    @OneToMany(mappedBy="user")
    private List<Authority> authorities = new ArrayList<>();
    
    public User(String username, String first_name, String last_name, String email, String password, List<Authority> authorities) {
		super();
		this.setUsername(username);
		this.setPassword(password);
		this.setAuthorities(authorities);
	}
    
    public User(String username, String first_name, String last_name, String email, String password) {
		super();
		this.setUsername(username);
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setEmail(email);
		this.setPassword(password);
	}

	public User() {
	}
    
    @Override
	public String toString() {
		return "User [firstname=" + first_name + ", last_name=" + last_name + 
				", username=" + username + ", password=" + password + ", email=" 
				+ email + ", enabled=" + enabled + "]";
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
