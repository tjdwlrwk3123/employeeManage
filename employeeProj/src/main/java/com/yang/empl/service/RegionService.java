package com.yang.empl.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.empl.dao.RegionDao;
import com.yang.empl.vo.RegionVo;

@Service
public class RegionService {
	
	@Autowired
	private RegionDao rdao;
	
	public List<RegionVo> getRegion(){
		return rdao.getRegion();
	}
	public RegionVo getRegionOne(HashMap<String, Object> map){
		return rdao.getRegionOne(map);
	}
	public int insertRegion(String reginame) {
		return rdao.insertRegion(reginame);
	}
}
