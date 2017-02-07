package com.blog.dmlgusthd.web;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dmlgusthd.service.BManagement;
import com.blog.dmlgusthd.service.BRent;
import com.blog.dmlgusthd.service.LibraryService;
import com.blog.dmlgusthd.service.Manager;
import com.blog.dmlgusthd.service.Member;


@Controller
public class LibraryController {
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	@Autowired
	private LibraryService libraryService;
	/* 멤버 리스트 가져오는 메소드 */
	@RequestMapping(value="MemberList")
	public String memberList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = 
				libraryService.selectMember(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "MemberList";
	}
	
	/* 회원 한명의 정보 가져오는 메소드 */
	@RequestMapping(value="UpdateMember", method=RequestMethod.GET)
	public String updateMember(Model model,int mNo){
		model.addAttribute("member",libraryService.selectOneMember(mNo));
		return "UpdateMember";
	}
	
	
	/* 회원정보 수정하는 메소드 */
	@RequestMapping(value="UpdateMember", method=RequestMethod.POST)
	public String updateMember(Member member){
		libraryService.updateMember(member);
		return "redirect:MemberList";
	}

	@RequestMapping(value="BookInfo")
	public String bookInfo(Model model, String bmName){
		model.addAttribute("book",libraryService.selectOneBook(bmName));
		model.addAttribute("info",libraryService.selectBookInfo(bmName));
		return "BookInfo";
	}
	
	/* 대여등록 리스트 가져오는 메소드 */
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
	/* 대여등록된 도서의 정보 가져오는 메소드 */
	@RequestMapping(value="RentInfo", method=RequestMethod.GET)
	public String rentInfo(Model model,String bmName,String mName) throws ParseException{
		// 도서대여 하루당 300원으로 임의정함
		// 현재날짜에서 빌려간날짜와의 일수 차이를 구한다
		int day = libraryService.day(bmName);
		// 대여할때 선입금 했던 금액을 가져온다
		int pay = libraryService.pay(bmName);
		int i = mName.indexOf("/");
		String mPhone = mName.substring(i+1);
		Member mSpecial = libraryService.selectSpecail(mPhone);
		char sp = mSpecial.getmSpecial();
		logger.debug("값{}",mSpecial);
		// 최종 결제금을 구한다
		if(sp == 'O'){
			System.out.println("if문 실행");
			int payment = (day*200)-pay;
			model.addAttribute("payment",payment);
			model.addAttribute("library",libraryService.selectRentInfo(bmName));
			
			return "RentInfo";
		} else {
			System.out.println("else문 실행");
			int payment = (day*300)-pay;
			model.addAttribute("payment",payment);
			model.addAttribute("library",libraryService.selectRentInfo(bmName));
			
			return "RentInfo";
		}
	}
	/* 반납 메소드 */
	@RequestMapping(value="RentInfo", method=RequestMethod.POST)
	public String rentInfo(String bmName, Integer day){
		// 반납하는 도서의 대여일수를 구함
		day = libraryService.day(bmName);
		// 반납하는 도서를 DB에서 삭제
		libraryService.deleteRent(bmName);
		// 반납된 도서의 도서대여상태를 '가능'으로 바꿔줌
		libraryService.updateManagement(bmName);
		// 반납된 도서의 대여횟수와 대여일을 추가해줌
		libraryService.updateInfo(bmName, day);
		return "redirect:RentList";
	}
	

	@RequestMapping(value="InsertRental", method=RequestMethod.GET)
	public String insertRental(Model model){
		model.addAttribute("name",libraryService.selectName());
		return "InsertRental";
	}
	
	/* 대여 등록하는 메소드 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@RequestMapping(value="InsertRental", method=RequestMethod.POST)
	public String insertRental(BRent br){
		logger.info("대여등록 입력값:{}",br);
		// 대여등록 DB에 정보를 입력
		libraryService.insertRent(br);
		// 해당도서의 최초대여일을 입력
		libraryService.insertInfo(br);
		// 해당도서의 도서대여상태를 '불가능'으로 바꿔줌
		libraryService.bookCheck();
		return "InsertRental";
	}
	
	@RequestMapping(value="InsertBook", method=RequestMethod.GET)
	public String insertBook(){
		return "InsertBook";
	}
	
	/* 도서 등록하는 메소드 */
	@RequestMapping(value="InsertBook", method=RequestMethod.POST)
	public String insertBook(BManagement bm){
		logger.info("도서정보 입력값{}",bm);
		libraryService.insertBook(bm);
		return "InsertBook";
	}
	
	/* 등록된 도서 리스트 가져오는 메소드 */
	@RequestMapping(value="BookList")
	public String bookList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = 
				libraryService.selectBook(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "BookList";
	}
	
	@RequestMapping(value="BookDisuse", method=RequestMethod.POST)
	public String insertBookDisuse(Integer bmSn){
		libraryService.InsertBookDisuse(bmSn);
		return "redirect:BookList";
	}
	
	@RequestMapping(value="InsertMember", method=RequestMethod.GET)
	public String insertMember(){
		return "InsertMember";
	}
	
	/* 회원 등록하는 메소드 */
	@RequestMapping(value="InsertMember", method=RequestMethod.POST)
	public String insertMember(HttpServletRequest request, Member member){
		// 전화번호를 000-0000-0000형식으로 등록하기 위해 request사용
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String mPhone = phone1+"-"+phone2+"-"+phone3;
		member.setmPhone(mPhone);
		logger.info("회원정보 입력값: {}",member);
		libraryService.insertMember(member);
		return "InsertMember";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login() {
		return "Index";
	}
	
	/* 로그아웃 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
	    session.setAttribute("manager", null);
	    return "redirect:/";
	}
	/* 로그인 */
	@RequestMapping(value="loginProcess", method = RequestMethod.POST)
		public ModelAndView loginProcess(Manager manager, HttpSession session, String id, String pw) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("pw", pw);
			Manager loginmanager = libraryService.selectIdPw(map);
			 
			if (loginmanager != null) {
			session.setAttribute("manager", loginmanager);
		}
		return mav;
	}

}
