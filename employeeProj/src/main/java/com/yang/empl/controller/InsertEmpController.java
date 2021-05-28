package com.yang.empl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yang.empl.service.EmpService;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Controller
public class InsertEmpController {
	
	@Autowired
	private EmpService eService;
	
	@RequestMapping(method = RequestMethod.GET, value="insertForm")
	public String goInsertForm(Model model) {
		
		List<DepartmentVo> deptList=eService.getDepartment();
		List<RegionVo> regList=eService.getRegion();
		List<PositionVo> posiList=eService.getPosition();
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("posiList", posiList);
		model.addAttribute("regList", regList);
		
		return "/user/empInsert";
	}
}
