package com.yang.empl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.empl.dao.LoginDao;
import com.yang.empl.vo.UserInfoVo;

@Service
public class LoginService {
	@Autowired
	private LoginDao ldao;
	
	public UserInfoVo getUserinfo(String userid) {
		return ldao.getUserinfo(userid);
	}
}
