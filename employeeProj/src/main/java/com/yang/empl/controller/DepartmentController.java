package com.yang.empl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.DepartmentService;
import com.yang.empl.vo.DepartmentVo;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService dService;
	
	@RequestMapping("/department")
	public String deptList(Model model) {
		List<DepartmentVo> list=dService.getDepartment();
		model.addAttribute("deptList", list);
		
		return "/user/department";
	}
	
	@RequestMapping("/deptInsert")
	public String insertDept(String deptname,RedirectAttributes ra) {
		try {
			int deptInsert=dService.deptInsert(deptname);
			ra.addFlashAttribute("result", "success");
			return "redirect:department";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("result", "failed");
			return "redirect:department";
		}
	}
}
