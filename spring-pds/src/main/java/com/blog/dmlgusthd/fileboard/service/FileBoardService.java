package com.blog.dmlgusthd.fileboard.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileBoardService{
	private static final Logger logger = LoggerFactory.getLogger(FileBoardService.class);
	@Autowired
	private FileBoardDao fileBoardDao;
	
	public int deleteFileBoard(String fileName){
		return fileBoardDao.deleteFileBoard(fileName);
	}
	
	public FileBoard getFileBoard(String title){
		return fileBoardDao.selectFileBoard(title);
	}
	
	public int updateFileBoard(FileBoard fileBoard){
		return fileBoardDao.updateFileBoard(fileBoard);
	}
	
	public Map<String,Object> FileBoardList(int currentPage){
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		//totalCount 구하고 
		int totalRowCount = fileBoardDao.FileBoardListCount();
		//lastCount 구한다
		int lastPage = totalRowCount/pagePerRow;
        if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<FileBoard> list = fileBoardDao.FileBoardList(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		
		return returnMap;
	}
	
	public int addFileBoard(FileBoardCommand fileBoardCommand){
		File destFile = null;
		String path = "";
		String extention = "";
		int result = 0;
		
		try {
			// 1. 디렉토리 저장
			path = "D:\\sts\\spring-pds\\src\\main\\resources\\upload\\";
			MultipartFile multipartFile = fileBoardCommand.getMultipartFile();
			UUID uuid = UUID.randomUUID();
			String fileName=uuid.toString().replace("-", "");
			int index = multipartFile.getOriginalFilename().lastIndexOf(".");
			extention = multipartFile.getOriginalFilename().substring(index+1);
			fileName = fileName+"."+extention;
			destFile = new File(path+fileName);
			multipartFile.transferTo(destFile);
			
			// 2. FileBoardCommand -> FileBoard로 바꿔서 -> DAO로 넘김
			FileBoard fileBoard = new FileBoard();
			fileBoard.setTitle(fileBoardCommand.getTitle());
			fileBoard.setAuth(fileBoardCommand.getAuth());
			fileBoard.setFileName(fileName);
			fileBoard.setFilePath(path);
			fileBoard.setExtention(extention);
			logger.info("{}"+fileBoard.toString());
			
			result = fileBoardDao.addFileBoard(fileBoard);
			
		} catch (IllegalStateException e) {
			destFile.delete();
			e.printStackTrace();
		} catch (IOException e) {
			destFile.delete();
			e.printStackTrace();
		}
		return result;
	}
}
