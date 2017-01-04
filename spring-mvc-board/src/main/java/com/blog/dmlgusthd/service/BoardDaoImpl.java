package com.blog.dmlgusthd.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //태생적으로 DAO에 많이 쓰임, 저장소의 기능을 가짐
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertBoard(Board board) {
		return sqlSession.insert("com.blog.dmlgusthd.BoardMapper.boardAdd",board);
	}

}
