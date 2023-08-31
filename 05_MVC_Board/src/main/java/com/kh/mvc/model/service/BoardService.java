package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public List<Board> selectAll(Criteria cri) {
		return dao.selectAll(cri);
	}
	
	public int insert(Board vo) {
		return dao.insert(vo);
	}
	
	public Board select(int no) {
		return dao.selectBoard(no);
	}
	
	public int update(Board vo) {
		return dao.update(vo);
	}
	
	public int delete(int no) {
		return dao.delete(no);
	}
	
	public int getTotal() {
		return dao.getTotal();
	}
}
