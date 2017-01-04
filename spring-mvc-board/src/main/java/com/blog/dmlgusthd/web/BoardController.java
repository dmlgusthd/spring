package com.blog.dmlgusthd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.dmlgusthd.service.Board;
import com.blog.dmlgusthd.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(){
		return "/board/boardAdd"; //forward
	}
	
	//오버로딩
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board){//커맨드 객체
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/board/boardList")
	public String boardList(){
		return "/board/boardList";
	}
}