package com.blog.dmlgusthd.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDao {
	private final String NS="com.blog.dmlgusthd.Mapper.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertMember(Member member){
		return sqlSession.insert(NS+"insertMember",member);
	}
	
	public List<Member> selectMember(Map<String, Integer>map){
		return sqlSession.selectList(NS+"selectMember",map);
	}
	
	public int selectTotalMemberCount(){
		return sqlSession.selectOne(NS+"selectTotalMemberCount");
	}
}
