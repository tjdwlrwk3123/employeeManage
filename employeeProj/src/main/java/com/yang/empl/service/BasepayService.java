package com.yang.empl.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.empl.dao.BasepayDao;
import com.yang.empl.vo.PayDeptPositionJoinVo;
import com.yang.empl.vo.PayforVo;

@Service
public class BasepayService {
	@Autowired
	private BasepayDao bdao;
	
	public List<PayDeptPositionJoinVo> getAllBasepay(){
		return bdao.getAllBasepay();
	}
	public PayforVo getBasepay(HashMap<String, Object> map) {
		return bdao.getBasepay(map);
	}
	public int mergeBasepay(HashMap<String, Object> map) {
		return bdao.mergeBasepay(map);
	}
}
