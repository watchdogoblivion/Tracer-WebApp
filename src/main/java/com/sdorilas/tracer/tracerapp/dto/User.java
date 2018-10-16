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
    private String password;
    private boolean enabled = true;;
 
    @OneToMany(mappedBy="user")
    private List<Authority> authorities = new ArrayList<>();
    
    public User(String username, String lastName, String email, String password, List<Authority> authorities) {
		super();
		this.setUsername(username);
		this.password = password;
		this.setAuthorities(authorities);
	}
    
    public User() {
	}
    
    @Override
	public String toString() {
		return "User [username=" + username
				+ ", password=" + password + ", enabled=" + enabled + "]";
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

	public boolean match(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
