package com.blog.dmlgusthd.web;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.dmlgusthd.service.BManagement;
import com.blog.dmlgusthd.service.BRent;
import com.blog.dmlgusthd.service.LibraryService;
import com.blog.dmlgusthd.service.Member;
import com.mysql.jdbc.PreparedStatement;


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
	public String insertRental(){
		return "InsertRental";
	}
	
	@RequestMapping(value="RentList")
	public String rentList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = 
				libraryService.selectRent(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "RentList";
	}
	
	@RequestMapping(value="RentInfo")
	public String rentInfo(Model model,String bmName){
		model.addAttribute("library",libraryService.selectRentInfo(bmName));
		int day = libraryService.day();
		model.addAttribute("day",day);
		return "RentInfo";
	}
	
	@Transactional
	@RequestMapping(value="InsertRental", method=RequestMethod.POST)
	public String insertRental(BRent br){
		logger.info("대여등록 입력값:{}",br);
		libraryService.insertRent(br);
		libraryService.insertInfo(br);
		libraryService.bookCheck();
		return "InsertRental";
	}
	
	@RequestMapping(value="InsertBook", method=RequestMethod.GET)
	public String InsertBook(){
		return "InsertBook";
	}
	
	@RequestMapping(value="InsertBook", method=RequestMethod.POST)
	public String InsertBook(BManagement bm){
		logger.info("도서정보 입력값{}",bm);
		libraryService.insertBook(bm);
		return "InsertBook";
	}
	
	@RequestMapping(value="BookList")
	public String BookList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = 
				libraryService.selectBook(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "BookList";
	}
	
	@RequestMapping(value="InsertMember", method=RequestMethod.GET)
	public String InsertMember(){
		return "InsertMember";
	}
	
	@RequestMapping(value="InsertMember", method=RequestMethod.POST)
	public String InsertMember(HttpServletRequest request, Member member){
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String mPhone = phone1+"-"+phone2+"-"+phone3;
		member.setmPhone(mPhone);
		logger.info("회원정보 입력값: {}",member);
		libraryService.insertMember(member);
		return "InsertMember";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String home() {
		return "Index";
	}
	
}
