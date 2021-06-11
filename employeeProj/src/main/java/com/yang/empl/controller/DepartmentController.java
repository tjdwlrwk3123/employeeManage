package com.yang.empl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	@RequestMapping("/deptDelete")
	public String deptDelete(int deptNum,RedirectAttributes ra) {
		try {
			dService.deptDelete(deptNum);
			ra.addFlashAttribute("delete", "success");
			return "redirect:department";
		}catch(DataIntegrityViolationException de) {
			System.out.println("제약조건 오류발생");
			ra.addFlashAttribute("delete", "failed");
			return "redirect:department";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("delete", "idk");
			return "redirect:department";
		}
	}
	
	@RequestMapping("/updateDept")
	public String updateDept(int deptNum,String deptName,RedirectAttributes ra) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("deptNum", deptNum);
		map.put("deptName", deptName);
		try {
			dService.updateDept(map);
			ra.addFlashAttribute("update", "success");
			return "redirect:department";
		}catch(Exception e) {
			System.out.println("에러발생");
			ra.addFlashAttribute("update", "failed");
			return "redirect:department";
		}
	}
}
