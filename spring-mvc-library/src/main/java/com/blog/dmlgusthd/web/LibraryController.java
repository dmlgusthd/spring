package com.blog.dmlgusthd.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.dmlgusthd.service.LibraryService;
import com.blog.dmlgusthd.service.Member;


@Controller
public class LibraryController {
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(value="MemberList")
	public String MemberList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = 
				libraryService.selectMember(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "MemberList";
	}
	
	@RequestMapping(value="InsertRental", method=RequestMethod.GET)
	public String InsertRental(){
		return "InsertRental";
	}
	
	@RequestMapping(value="BookList")
	public String BookList(){
		return "BookList";
	}
	
	@RequestMapping(value="InsertMember", method=RequestMethod.GET)
	public String InsertMember(){
		return "InsertMember";
	}
	
	@RequestMapping(value="InsertMember", method=RequestMethod.POST)
	public String InsertMember(Member member){
		logger.info("회원정보 입력값: {}",member);
		libraryService.insertMember(member);
		return "redirect:MemberList";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home() {
		return "Index";
	}
	
}
