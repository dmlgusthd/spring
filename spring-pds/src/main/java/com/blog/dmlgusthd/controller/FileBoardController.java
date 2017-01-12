package com.blog.dmlgusthd.controller;

import java.util.Map;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.dmlgusthd.fileboard.service.FileBoard;
import com.blog.dmlgusthd.fileboard.service.FileBoardCommand;
import com.blog.dmlgusthd.fileboard.service.FileBoardService;

@Controller
public class FileBoardController {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardController.class);
	
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value="/remove")
	public String deleteFileBoard(String fileName){
		String msg = JOptionPane.showInputDialog(null,"삭제하시려면 YES를 입력해주세요.");
		if(msg == null) {
			JOptionPane.showMessageDialog(null, "입력값이 없습니다.");
		}if(msg.equals("YES")){
			JOptionPane.showMessageDialog(null, "삭제합니다");
			fileBoardService.deleteFileBoard(fileName);
			return "redirect:/list";
		}else{ 
			JOptionPane.showMessageDialog(null, "입력값이 잘못 되었습니다.");
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String updateFileBoard(Model model,
			@RequestParam(value="fileName")String fileName){
		model.addAttribute("fileboard", fileBoardService.getFileBoard(fileName));
		return "/modify";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String updateFileBoard(FileBoard fileBoard){
		fileBoardService.updateFileBoard(fileBoard);
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/view")
	public String fileBoardView(Model model,
			@RequestParam(value="fileName")String fileName){
		model.addAttribute("fileboard", fileBoardService.getFileBoard(fileName));
		return "view";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(){
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(FileBoardCommand fileBoardCommand){
		logger.debug(fileBoardCommand.toString());
		fileBoardService.addFileBoard(fileBoardCommand);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/list")
	public String fileList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = 
				fileBoardService.FileBoardList(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "list";
	}
}
