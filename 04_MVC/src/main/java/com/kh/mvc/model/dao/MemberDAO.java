package com.kh.mvc.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository
public class MemberDAO {

	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	public int registerMember(Member vo) {
		return sqlSession.insert("memberMapper.register", vo);
	}
	
	/*
	 * showAllMember 
	 * findMember -> 파라미터 : String keyword, return : List<Member>
	 * login -> 파라미터 : Member vo
	 * updateMember -> 파라미터 : Member vo
	 */
	
}
