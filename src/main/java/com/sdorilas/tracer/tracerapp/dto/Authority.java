package com.sdorilas.tracer.tracerapp.dto;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @ManyToMany(mappedBy = "authorities", fetch=FetchType.EAGER)
    private Collection<User> users;

	public Authority() {
		super();
	}
	
	public Authority(String name) {
		super();
		this.name = name;
	}

	public Authority(String name, Collection<User> users) {
		super();
		this.name = name;
		this.setUsers(users);
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name + ", users=" + getUsers() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}