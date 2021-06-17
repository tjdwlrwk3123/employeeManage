package com.yang.empl.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.DepartmentService;
import com.yang.empl.service.EmpService;
import com.yang.empl.service.PositionService;
import com.yang.empl.service.RegionService;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Controller
public class InsertEmpController {
	
	@Autowired
	private EmpService eService;
	@Autowired
	private RegionService rService;
	@Autowired
	private DepartmentService dService;
	@Autowired
	private PositionService pService;
	
	@RequestMapping(method = RequestMethod.GET, value="admin/insertForm")
	public String goInsertForm(Model model) {
		//빈 해시맵 생성
		
		List<DepartmentVo> deptList=dService.getDepartment();
		List<RegionVo> regList=rService.getRegion();
		List<PositionVo> posiList=pService.getPosition();
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("posiList", posiList);
		model.addAttribute("regList", regList);
		
		return "/admin/empInsert";
	}
	
	@RequestMapping(value="admin/empInsert")
	public String empInsert(String name, Date birth, 
			@RequestParam(defaultValue = "1") int sollun, String phone,
			String region, String department, String position, int basepay, 
			@RequestParam(defaultValue = "0") int bonus, Date joining,
			HttpServletRequest req, RedirectAttributes ra) {
		
		HashMap<String, Object> empMap=new HashMap<String, Object>();
		
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
			eService.insertTransaction(empMap,department,position);
			return "redirect:/list";
		}catch(Exception e) {
			ra.addFlashAttribute("failed", "failed");
			//이전페이지로 가기
			String referer=req.getHeader("Referer");
			return "redirect:"+referer;
		}
	}
}
