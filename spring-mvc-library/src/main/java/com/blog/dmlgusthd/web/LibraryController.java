package com.blog.dmlgusthd.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.dmlgusthd.service.LibraryService;
import com.blog.dmlgusthd.service.Member;


@Controller
public class LibraryController {
	
	private LibraryService libraryService;
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	@RequestMapping(value="InsertMember", method=RequestMethod.GET)
	public String InsertMember(){
		return "InsertMember";
	}
	
	@RequestMapping(value="InsertMember", method=RequestMethod.POST)
	public String InsertMember(Member member){
		libraryService.insertMember(member);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "Index";
	}
	
}
