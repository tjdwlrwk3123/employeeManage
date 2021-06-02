package com.yang.empl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.RegionVo;

@Repository
public class RegionDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";
	
	public RegionVo getRegionOne(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".getRegionOne",map);
	}
	public List<RegionVo> getRegion(){
		return sqlSession.selectList(NAMESPACE+".getRegion");
	}
	public int insertRegion(String reginame) {
		return sqlSession.insert(NAMESPACE+".regionInsert",reginame);
	}
	
}
