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
	
	public Map<String,Object> selectMember(int currentPage){
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		//totalCount 구하고 
		int totalRowCount = dao.selectTotalMemberCount();
		//lastCount 구한다
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
