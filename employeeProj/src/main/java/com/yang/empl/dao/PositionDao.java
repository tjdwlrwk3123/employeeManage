package com.yang.empl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.PositionVo;

@Repository
public class PositionDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";
	
	public PositionVo getPositionOne(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".getPositionOne",map);
	}
	public List<PositionVo> getPosition(){
		return sqlSession.selectList(NAMESPACE+".getPosition");
	}
	public int ppInsert(String ppname) {
		return sqlSession.insert(NAMESPACE+".ppInsert", ppname);
	}
	public int ppDelete(int ppNum) {
		return sqlSession.delete(NAMESPACE+".ppDelete", ppNum);
	}
	public int updatePosition(HashMap<String, Object> map) {
		return sqlSession.update(NAMESPACE+".updatePosition", map);
	}
}
