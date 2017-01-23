package com.blog.dmlgusthd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LibraryService {
	@Autowired
	private LibraryDao dao;
	
	public int insertMember(Member member){
		return dao.insertMember(member);
	}
}
