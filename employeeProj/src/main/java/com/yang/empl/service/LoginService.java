package com.yang.empl.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public int changeActiveLogin(String userid) {
		return ldao.changeActiveLogin(userid);
	}
	public int changeActiveLogout(String userid) {
		return ldao.changeActiveLogout(userid);
	}
	public int changePassword(String userid,String password) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String newP=encoder.encode(password);
		map.put("userid", userid);
		map.put("password", newP);
		return ldao.changePassword(map);
	}
}
