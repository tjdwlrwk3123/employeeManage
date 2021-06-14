package com.yang.empl.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.DepartmentService;
import com.yang.empl.service.EmpService;
import com.yang.empl.service.PositionService;
import com.yang.empl.service.RegionService;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.EmpListVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Controller
public class UpdateEmpController {
	
	@Autowired
	private EmpService eService;
	@Autowired
	private RegionService rService;
	@Autowired
	private DepartmentService dService;
	@Autowired
	private PositionService pService;
	
	@RequestMapping("updateForm")
	public String getEmpOne(@RequestParam(value="empNum") int empnum,Model model) {
		
		List<DepartmentVo> deptList=dService.getDepartment();
		List<RegionVo> regList=rService.getRegion();
		List<PositionVo> posiList=pService.getPosition();
		EmpListVo empList=eService.getEmpOne(empnum);
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("posiList", posiList);
		model.addAttribute("regList", regList);
		model.addAttribute("emp", empList);
		
		return "/admin/empUpdate";
	}
	
	@RequestMapping("updateEmp")
	public String updateEmp(int empNum,String name, Date birth, 
			@RequestParam(defaultValue = "1") int sollun, String phone,
			String region, String department, String position, int basepay, 
			@RequestParam(defaultValue = "0") int bonus, Date joining,
			HttpServletRequest req, RedirectAttributes ra) {
		
		HashMap<String, Object> empMap=new HashMap<String, Object>();
		
		empMap.put("empnum", empNum);
		empMap.put("empname", name);
		empMap.put("ppnum", position);
		empMap.put("deptnum",department);
		empMap.put("empbirth", birth);
		empMap.put("sollun", sollun);
		empMap.put("regionnum", region);
		empMap.put("phonenum", phone);
		empMap.put("basepay", basepay);
		empMap.put("bonus", bonus);
		empMap.put("joinday", joining);
		
		try {
			eService.updateEmp(empMap);
			return "redirect:/list";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("failed", "failed");
			//이전페이지로 가기
			String referer=req.getHeader("Referer");
			return "redirect:"+referer;
		}
	}
}
