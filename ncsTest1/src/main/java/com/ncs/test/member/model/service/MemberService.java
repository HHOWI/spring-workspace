package com.ncs.test.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDAO;
import com.ncs.test.member.model.vo.Member;

@Service
public class MemberService implements MemberServiceImpl {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public Member login(Member vo) {
		return dao.login(vo);
	}

}
