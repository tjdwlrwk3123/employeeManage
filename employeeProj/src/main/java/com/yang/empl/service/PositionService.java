package com.yang.empl.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.empl.dao.PositionDao;
import com.yang.empl.vo.PositionVo;

@Service
public class PositionService {
	@Autowired
	private PositionDao pdao;
	
	public PositionVo getPositionOne(HashMap<String, Object> map){
		return pdao.getPositionOne(map);
	}
	public List<PositionVo> getPosition(){
		return pdao.getPosition();
	}
	public int ppInsert(String ppname) {
		return pdao.ppInsert(ppname);
	}
	public int ppDelete(int ppNum) {
		return pdao.ppDelete(ppNum);
	}
	public int updatePosition(HashMap<String, Object> map) {
		return pdao.updatePosition(map);
	}
}
