package com.yang.empl.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.empl.dao.DepartmentDao;
import com.yang.empl.vo.DepartmentVo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao ddao;
	
	public List<DepartmentVo> getDepartment(){
		return ddao.getDepartment();
	}
	public DepartmentVo getDepartmentOne(HashMap<String, Object> map){
		return ddao.getDepartmentOne(map);
	}
	public int deptInsert(String deptname) {
		return ddao.deptInsert(deptname);
	}
	public int deptDelete(int deptNum) {
		return ddao.deptDelete(deptNum);
	}
	public int updateDept(HashMap<String, Object> map) {
		return ddao.updateDept(map);
	}
}
