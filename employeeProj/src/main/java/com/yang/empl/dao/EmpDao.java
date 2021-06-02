package com.yang.empl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.EmpListVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Repository
public class EmpDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";
	
	public DepartmentVo getDepartmentOne(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".getDepartmentOne",map);
	}
	public PositionVo getPositionOne(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".getPositionOne",map);
	}
	
	
	public List<DepartmentVo> getDepartment(){
		return sqlSession.selectList(NAMESPACE+".getDepartment");
	}
	public List<PositionVo> getPosition(){
		return sqlSession.selectList(NAMESPACE+".getPosition");
	}
	
	
	public PayforVo getBasepay(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getBasepay", map);
	}
	public int getIdSequence() {
		return sqlSession.selectOne(NAMESPACE+".getIdSequence");
	}
	public int userInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".userInsert",map);
	}
	public int empInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".empInsert", map);
	}
	public List<EmpListVo> getEmployee(){
		return sqlSession.selectList(NAMESPACE+".getEmployee");
	}
}
