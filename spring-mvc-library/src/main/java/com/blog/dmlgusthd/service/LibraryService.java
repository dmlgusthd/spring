package com.blog.dmlgusthd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LibraryService {
	@Autowired
	private LibraryDao dao;
	private static final Logger logger = LoggerFactory.getLogger(LibraryService.class);
	
	public int insertMember(Member member){
		logger.info("입력값 : {}",member);
		return dao.insertMember(member);
	}
	
	public int deleteRent(String bmName){
		return dao.deleteRent(bmName);
	}
	
	public int updateManagement(String bmName){
		return dao.updateManagement(bmName);
	}
	
	public Map<String,Object> updateInfo(String bmName, Integer day){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("bmName", bmName);
		map.put("day", day);
		dao.updateInfo(map);
		return map;
	}
	
	public int pay(String bmName){
		return dao.pay(bmName);
	}
	
	public int day(String bmName){
		return dao.day(bmName);
	}
	
	public int insertBook(BManagement bm){
		return dao.insertBook(bm);
	}
	
	public int insertInfo(BRent br){
		return dao.insertInfo(br);
	}
	
	public int insertRent(BRent br){
		return dao.insertRent(br);
	}
	
	public BRent selectRentInfo(String bmName){
		return dao.selectRentInfo(bmName);
	}
	
	public int bookCheck(){
		return dao.bookCheck();
	}
	
	public Map<String,Object> selectRent(int currentPage){
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		int totalRowCount = dao.selectTotalRentCount();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0) {
		    lastPage++;
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<BRent> list = dao.selectRent(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		
		return returnMap;
	}
	
	public Map<String,Object> selectBook(int currentPage){
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		int totalRowCount = dao.selectTotalBookCount();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0) {
		    lastPage++;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<BManagement> list = dao.selectBook(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		
		return returnMap;
	}
	
	public Map<String,Object> selectMember(int currentPage){
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		int totalRowCount = dao.selectTotalMemberCount();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0) {
		    lastPage++;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Member> list = dao.selectMember(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		
		return returnMap;
	}
}
