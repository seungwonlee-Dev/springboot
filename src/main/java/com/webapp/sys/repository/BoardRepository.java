package com.webapp.sys.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.webapp.sys.model.Board;

public interface BoardRepository extends JpaRepository<Board,Long>{

}