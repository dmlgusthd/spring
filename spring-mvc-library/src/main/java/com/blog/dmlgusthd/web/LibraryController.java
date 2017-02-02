package com.blog.dmlgusthd.web;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.dmlgusthd.service.BManagement;
import com.blog.dmlgusthd.service.BRent;
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
	
	@RequestMapping(value="RentInfo", method=RequestMethod.GET)
	public String rentInfo(Model model,String bmName) throws ParseException{
		// 현재날짜에서 빌려간날짜와의 일수 차이를 구한다
		int day = libraryService.day(bmName);
		// 대여할때 선입금 했던 금액을 가져온다
		int pay = libraryService.pay(bmName);
		// 최종 결제금을 구한다
		int payment = (day*300)-pay;
		model.addAttribute("payment",payment);
		model.addAttribute("library",libraryService.selectRentInfo(bmName));
		return "RentInfo";
	}
	
	@RequestMapping(value="RentInfo", method=RequestMethod.POST)
	public String retnInfo(String bmName, Integer day){
		day = libraryService.day(bmName);
		libraryService.deleteRent(bmName);
		libraryService.updateManagement(bmName);
		libraryService.updateInfo(bmName, day);
		return "redirect:RentList";
	}
	

	@RequestMapping(value="InsertRental", method=RequestMethod.GET)
	public String insertRental(){
		return "InsertRental";
	}
	
	
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
