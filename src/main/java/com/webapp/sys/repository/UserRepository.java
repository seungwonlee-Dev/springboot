package com.webapp.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.sys.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
