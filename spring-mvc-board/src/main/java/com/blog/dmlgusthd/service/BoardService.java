package com.blog.dmlgusthd.service;

import java.util.Map;

public interface BoardService {
	public int addBoard(Board board);
	Map<String, Object> getBoardListPerCurrentPage(int currentPage);
	public int deleteBoard(Board board);
	Board getBoardByKey(int boardNo);
	public int updateBoard(Board board);
}
