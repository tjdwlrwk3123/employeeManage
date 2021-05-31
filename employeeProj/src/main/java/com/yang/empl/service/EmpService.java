package com.yang.empl.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yang.empl.dao.EmpDao;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Service
public class EmpService {
	
	@Autowired
	private EmpDao edao;
	
	public List<DepartmentVo> getDepartment(){
		return edao.getDepartment();
	}
	public List<PositionVo> getPosition(){
		return edao.getPosition();
	}
	public List<RegionVo> getRegion(){
		return edao.getRegion();
	}
	public PayforVo getBasepay(HashMap<String, Object> map) {
		return edao.getBasepay(map);
	}
	public int getIdSequence() {
		return edao.getIdSequence();
	}
	@Transactional(rollbackFor = {Exception.class})
	public int insertTransaction(HashMap<String, Object> userMap,HashMap<String, Object> empMap) {
		edao.userInsert(userMap);
		edao.empInsert(empMap);
		return 1;
	}
}
