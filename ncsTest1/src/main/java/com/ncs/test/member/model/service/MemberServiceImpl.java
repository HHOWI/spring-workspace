package com.ncs.test.member.model.service;

import org.springframework.stereotype.Service;

import com.ncs.test.member.model.vo.Member;

public interface MemberServiceImpl {
	
	public Member login(Member vo);
	
}
