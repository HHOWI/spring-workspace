package com.ncs.test.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@RestController
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("login")
	public String memberLogin(Member vo, HttpSession session) {
		Member member = service.login(vo);
		if(member!=null) {
		return "";
		}
		session.setAttribute("msg", "로그인 실패");
		return "views/errorPage.jsp";
	}

}
