package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insert(Board vo) {
		return sqlSession.insert("board.insert", vo);
	}
	
	public List<Board> selectAll() {
		return sqlSession.selectList("board.selectAll");
	}
	
	public List<Board> select(String keyword) {
		return sqlSession.selectList("board.select", keyword);
	}
	
	public int update(Board vo) {
		return sqlSession.update("board.update", vo);
	}
	
	public int delete(Board vo) {
		return sqlSession.delete("board.delete", vo);
	}
}
