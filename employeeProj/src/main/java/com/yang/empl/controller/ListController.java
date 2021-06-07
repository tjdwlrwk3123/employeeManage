package com.yang.empl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.empl.service.DepartmentService;
import com.yang.empl.service.EmpService;
import com.yang.empl.service.PositionService;
import com.yang.empl.service.RegionService;
import com.yang.empl.util.PageUtil;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.EmpListVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Controller
public class ListController {
	
	@Autowired
	private EmpService eService;
	@Autowired
	private RegionService rService;
	@Autowired
	private DepartmentService dService;
	@Autowired
	private PositionService pService;
	
	@RequestMapping(value="/list")
	public String join(Model model,
			@RequestParam(required = false,value = "search") String search,
			@RequestParam(required = false,value = "keyword") String keyword,
			@RequestParam(defaultValue = "1")int pageNum) {
		
		HashMap<String, Object> searchMap=new HashMap<String, Object>();
		
		
		if(keyword!=null && !keyword.equals("")) {
			System.out.println(search);
			System.out.println(keyword);
			searchMap.put("search", search);
			searchMap.put("keyword", keyword);
			model.addAttribute("search", search);
			model.addAttribute("keyword", keyword);
		}
		
		int totalRowCount=eService.countEmp();
		PageUtil pu=new PageUtil(pageNum, 10, 10, totalRowCount);
		int startRow=pu.getStartRow();
		int endRow=pu.getEndRow();
		
		searchMap.put("startRow", startRow);
		searchMap.put("endRow", endRow);
		
		
		List<EmpListVo> emplist=eService.getEmployee(searchMap);
		
		
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
			
			deptNameList.add(dService.getDepartmentOne(map).getDeptName());
			ppNameList.add(pService.getPositionOne(map).getPpName());
			regiNameList.add(rService.getRegionOne(map).getRegionName());
		}
		
		model.addAttribute("emplist", emplist);
		model.addAttribute("deptName", deptNameList);
		model.addAttribute("ppName", ppNameList);
		model.addAttribute("regiName", regiNameList);
		model.addAttribute("pu", pu);
		
		
		return "/user/main";
	}
	
	@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},value="getSelectRegion")
	@ResponseBody
	public List<RegionVo> getSelectRegion(String keyword){
		return rService.getRegion();
	}
	@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},value="getSelectDept")
	@ResponseBody
	public List<DepartmentVo> getSelectDept(String keyword){
		return dService.getDepartment();
	}
	@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},value="getSelectPosi")
	@ResponseBody
	public List<PositionVo> getSelectPosi(String keyword){
		return pService.getPosition();
	}
}
