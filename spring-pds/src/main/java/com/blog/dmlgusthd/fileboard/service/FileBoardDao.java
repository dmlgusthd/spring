package com.blog.dmlgusthd.fileboard.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileBoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String BOARD_NS="com.blog.dmlgusthd.FileBoardMapper.";
	
	public int deleteFileBoard(String fileName){
		return sqlSession.delete((BOARD_NS)+"deleteFileBoard",fileName);
	}
	
	public int updateFileBoard(FileBoard fileBoard){
		return sqlSession.update(BOARD_NS+"updateFileBoard",fileBoard);
	}
	
	public int addFileBoard(FileBoard fileBoard){
		return sqlSession.insert(BOARD_NS+"addFileBoard",fileBoard);
	}
	
	public List<FileBoard> FileBoardList(Map<String,Integer>map){
		return sqlSession.selectList(BOARD_NS+"FileBoardList",map);
	}
	
	public int FileBoardListCount(){
		return sqlSession.selectOne(BOARD_NS+"FileBoardListCount");
	}
	
	public FileBoard selectFileBoard(String fileName){
		return sqlSession.selectOne(BOARD_NS+"selectFileBoard",fileName);
	}
}
