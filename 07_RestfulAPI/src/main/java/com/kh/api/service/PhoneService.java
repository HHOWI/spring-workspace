package com.kh.api.service;

import java.util.List;

import com.kh.api.model.vo.Phone;
import com.kh.api.model.vo.UserInfo;

public interface PhoneService { // impl -> PhoneServiceImpl
	
	int insert(Phone phone);
	int update(Phone phone);
	int delete(String num);
	Phone select(String num);
	List<Phone> select();
	UserInfo select(UserInfo user);
}
