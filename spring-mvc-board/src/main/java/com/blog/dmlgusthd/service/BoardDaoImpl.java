package com.blog.dmlgusthd.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //태생적으로 DAO에 많이 쓰임, 저장소의 기능을 가짐
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String BOARD_NS="com.blog.dmlgusthd.BoardMapper.";
	@Override
	public int insertBoard(Board board) {
		return sqlSession.insert(BOARD_NS+"boardAdd",board);
	}
	
	@Override
	public int selectTotalBoardCount(){
		return sqlSession.selectOne(BOARD_NS+"selectTotalBoardCount");
	}
	
	public List<Board> selectBoardListPerPage(Map<String, Integer>map){
		return sqlSession.selectList(BOARD_NS+"selectBoardListPerPage",map);
	}

}
