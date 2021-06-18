package com.yang.empl.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.UserInfoVo;

@Repository
public class LoginDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";
	
	public UserInfoVo getUserinfo(String userid) {
		return sqlSession.selectOne(NAMESPACE+".getUserinfo", userid);
	}
	public int changeActive(String userid) {
		return sqlSession.update(NAMESPACE+".changeActive", userid);
	}
}
