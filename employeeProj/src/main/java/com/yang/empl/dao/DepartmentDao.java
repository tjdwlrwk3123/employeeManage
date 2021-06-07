package com.yang.empl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.DepartmentVo;

@Repository
public class DepartmentDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";
	
	public List<DepartmentVo> getDepartment(){
		return sqlSession.selectList(NAMESPACE+".getDepartment");
	}
	public DepartmentVo getDepartmentOne(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".getDepartmentOne",map);
	}
	public int deptInsert(String deptname) {
		return sqlSession.insert(NAMESPACE+".deptInsert", deptname);
	}
	public int deptDelete(int deptNum) {
		return sqlSession.delete(NAMESPACE+".deptDelete", deptNum);
	}
}
