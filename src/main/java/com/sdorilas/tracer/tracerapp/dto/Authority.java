package com.sdorilas.tracer.tracerapp.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String authority;
    
    @ManyToOne
    @JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
    private User user;

	public Authority() {
		super();
	}
	
	public Authority(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public Authority(Long id, String authority, User user) {
		super();
		this.id = id;
		this.authority = authority;
		this.setUser(user);
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", authority=" + authority + ", users=" + getUser() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}