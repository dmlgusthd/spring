package com.blog.dmlgusthd.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="com.blog.dmlgusthd.service.Mapper.";
	
	public int insertMember(Member member){
		return sqlSession.insert(NS+"InsertMember",member);
	}
	
}
