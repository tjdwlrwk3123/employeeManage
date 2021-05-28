package com.yang.empl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Repository
public class EmpDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";
	
	public List<DepartmentVo> getDepartment(){
		return sqlSession.selectList(NAMESPACE+".getDepartment");
	}
	public List<PositionVo> getPosition(){
		return sqlSession.selectList(NAMESPACE+".getPosition");
	}
	public List<RegionVo> getRegion(){
		return sqlSession.selectList(NAMESPACE+".getRegion");
	}
	public PayforVo getBasepay(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getBasepay", map);
	}
}
