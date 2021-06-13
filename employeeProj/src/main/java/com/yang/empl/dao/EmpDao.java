package com.yang.empl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.EmpListVo;
import com.yang.empl.vo.ImageVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Repository
public class EmpDao {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.empl.mapper.EmpMapper";

	public int getIdSequence() {
		return sqlSession.selectOne(NAMESPACE+".getIdSequence");
	}
	public int userInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".userInsert",map);
	}
	public int empInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".empInsert", map);
	}
	public List<EmpListVo> getEmployee(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".getEmployee",map);
	}
	public int countEmp(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".countEmp",map);
	}
	//직원 삭제
	public int deleteEmp(String userid) {
		return sqlSession.delete(NAMESPACE+".deleteEmp",userid);
	}
	public int deleteAuth(String userid) {
		return sqlSession.delete(NAMESPACE+".deleteAuth",userid);
	}
	public int deleteUser(String userid) {
		return sqlSession.delete(NAMESPACE+".deleteUser",userid);
	}
	public int deletePhoto(int empNum) {
		return sqlSession.delete(NAMESPACE+".deletePhoto", empNum);
	}
	//이미지 추가,조회
	public int insertPhoto(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".insertPhoto", map);
	}
	public ImageVo getPhoto(int empnum) {
		return sqlSession.selectOne(NAMESPACE+".getPhoto", empnum);
	}
}
