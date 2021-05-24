package com.webapp.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.sys.model.Board;
import com.webapp.sys.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {


	@Autowired
	private BoardRepository boardRepository;
	@RequestMapping("/list")
	public String list(Model model) {

		List<Board> boards = boardRepository.findAll();

		model.addAttribute("boards", boards);

		return "board/list";
	}
}