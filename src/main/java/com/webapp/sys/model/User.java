package com.webapp.sys.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private Boolean enabled;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
	  name = "user_role", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	private List<Role> roles = new ArrayList<>();

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	//	사용자 정보를 가져올때 boards 정보 까지 같이 가져온다.
	//	EAGER
	//	- OneToOne
	//	- ManyToOne
	//	사용자 정보를 가져올때 boards 정보를 가져오지 않다가 boards를 사용할 때 가져온다? 기본값은 LAZY
	//	LAZY
	//	- OneToMany
	//	- ManyToMany
	
	//@OneToMany(mappedBy ="user", cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(mappedBy ="user", fetch = FetchType.LAZY)
	//@JsonIgnore
	private List<Board> boards = new ArrayList<>();

	public List<Board> getBoards() {
		return boards;
	}
	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}
}