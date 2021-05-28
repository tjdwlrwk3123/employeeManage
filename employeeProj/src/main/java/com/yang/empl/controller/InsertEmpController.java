package com.yang.empl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yang.empl.service.EmpService;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.PayforVo;
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
	
	@RequestMapping(value="getBasepay",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public PayforVo getBasepay(@RequestParam(defaultValue = "1")int dept,
			@RequestParam(defaultValue = "1")int posi) {
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("dept", dept);
		map.put("posi", posi);
		
		PayforVo basepay=eService.getBasepay(map);
		
		return basepay;
	}
}
