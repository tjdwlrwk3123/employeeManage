package com.yang.empl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.empl.service.EmpService;
import com.yang.empl.service.RegionService;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.EmpListVo;

@Controller
public class ListController {
	
	@Autowired
	private EmpService eService;
	@Autowired
	private RegionService rService;
	
	@RequestMapping(value="/list")
	public String join(Model model) {
		
		List<EmpListVo> emplist=eService.getEmployee();
		
		ArrayList<String> deptNameList=new ArrayList<String>();
		ArrayList<String> ppNameList=new ArrayList<String>();
		ArrayList<String> regiNameList=new ArrayList<String>();
		
		for(EmpListVo vo:emplist) {
			int deptnum=vo.getDeptNum();
			int ppnum=vo.getPpNum();
			int reginum=vo.getRegionNum();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("deptnum", deptnum);
			map.put("ppnum", ppnum);
			map.put("reginum", reginum);
			
			deptNameList.add(eService.getDepartmentOne(map).getDeptName());
			ppNameList.add(eService.getPositionOne(map).getPpName());
			regiNameList.add(rService.getRegionOne(map).getRegionName());
		}
		
		model.addAttribute("emplist", emplist);
		model.addAttribute("deptName", deptNameList);
		model.addAttribute("ppName", ppNameList);
		model.addAttribute("regiName", regiNameList);
		
		return "/user/main";
	}
}
