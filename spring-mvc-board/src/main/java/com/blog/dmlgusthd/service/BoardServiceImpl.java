package com.blog.dmlgusthd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;

	@Override
	public int addBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(board);
	}
	
	@Override
	public Map<String, Object> getBoardListPerCurrentPage(int currentPage){
		//pagePerRow, beginRow 구하고
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		//totalCount 구하고 
		int totalRowCount = boardDao.selectTotalBoardCount();
		//lastCount 구한다
		int lastPage = totalRowCount/pagePerRow;
        if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Board> list = boardDao.selectBoardListPerPage(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		
		return returnMap;
	}
}
