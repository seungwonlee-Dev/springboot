package com.webapp.sys.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private Boolean enabled;
	

	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
	  name = "user_role", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	private List<Role> roles = new ArrayList<>();

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
	@JsonIgnore
	private List<Board> boards = new ArrayList<>();

}