package com.kh.mvc.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// 게터 세터
@NoArgsConstructor	// 기본 생성자
@AllArgsConstructor  // 생성자
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String addr;
	
}
