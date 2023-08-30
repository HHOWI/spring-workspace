package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public List<Board> selectAll() {
		return dao.selectAll();
	}
	
	public int insert(Board vo) {
		return dao.insert(vo);
	}
	
	public List<Board> select(String keyword) {
		return dao.select(keyword);
	}
	
	public int update(Board vo) {
		return dao.update(vo);
	}
	
	public int delete(Board vo) {
		return dao.delete(vo);
	}
}
