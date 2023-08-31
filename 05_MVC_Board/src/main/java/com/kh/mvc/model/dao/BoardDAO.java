package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insert(Board vo) {
		return sqlSession.insert("board.insert", vo);
	}
	
	public List<Board> selectAll(Criteria cri) {
		return sqlSession.selectList("board.selectAll", cri);
	}
	
	public int update(Board vo) {
		return sqlSession.update("board.update", vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("board.delete", no);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("board.getTotal");
	}
	
	public Board selectBoard(int no) {
		return sqlSession.selectOne("board.select", no);
	}
	
}
