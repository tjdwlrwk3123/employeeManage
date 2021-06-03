package com.yang.empl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.PayDeptPositionJoinVo;
import com.yang.empl.vo.PayforVo;

@Repository
public class BasepayDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";
	
	public List<PayDeptPositionJoinVo> getAllBasepay(){
		return sqlSession.selectList(NAMESPACE+".getAllBasepay");
	}
	public PayforVo getBasepay(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getBasepay", map);
	}
	public int mergeBasepay(HashMap<String, Object> map) {
		return sqlSession.update(NAMESPACE+".mergeBasepay", map);
	}
}
