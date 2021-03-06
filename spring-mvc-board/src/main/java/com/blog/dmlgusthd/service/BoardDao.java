package com.blog.dmlgusthd.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	int insertBoard(Board board);
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String,Integer> map);
	int deleteBoard(Board board);
	Board selectBoardByKey(int boardNo);
	int updateBoard(Board board);
	
}
