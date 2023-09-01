package com.kh.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	String path = "D:\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";
	
	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		List<Board> list = service.selectAll(cri);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@PostMapping("/insert")
	public String insert(Board board) throws IllegalStateException, IOException {
		
		this.fileUpload(board);
		
		service.insert(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/view")
	public void view(int no, Model model) {
		model.addAttribute("vo",service.select(no));
	}
	
	@PostMapping("/update")
	public String update(Board vo) throws IllegalStateException, IOException {
		
		fileUpload(vo);
		
		service.update(vo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/update")
	public void update(int no, Model model) {
		model.addAttribute("vo", service.select(no));
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		Board board = service.select(no);
		System.out.println(board);
		if(board.getUrl()!=null) {
			File delFile = new File(path + board.getUrl().replace("/upload/", ""));
			delFile.delete();
		}
		
		service.delete(no);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/download")
	public ModelAndView downloadFile(String filename) {
		HashMap map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView", map);
	}
	
	public void fileUpload(Board board) throws IllegalStateException, IOException {
		MultipartFile file = board.getUploadFile();
		System.out.println("file : " + file);
		
		if(!file.isEmpty()) {	// 업로드한 파일이 있는 경우!
			
			// 기존에 파일이 있는 경우 삭제!
			if(board.getUrl()!=null) {
				File delFile = new File(path + board.getUrl().replace("/upload/", ""));
				delFile.delete();
			}
			
			System.out.println("파일의 사이즈 : " + file.getSize());
			System.out.println("업로드된 파일 명 : " + file.getOriginalFilename());
			System.out.println("파일의 파라미터 명 : " + file.getName());
			
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString() + "_" + file.getOriginalFilename();
			
			File copyFile = new File(path + filename);
			file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
			
			// 데이터베이스에 경로 저장
			board.setUrl("/upload/" + filename);
		}
		
	}
}
