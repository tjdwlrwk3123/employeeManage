package com.yang.empl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.PositionService;
import com.yang.empl.vo.PositionVo;

@Controller
public class PositionController {
	@Autowired
	private PositionService pService;
	
	@RequestMapping("/position")
	public String ppList(Model model){
		List<PositionVo> list=pService.getPosition();
		model.addAttribute("ppList", list);
		
		return "/user/position";
	}
	
	@RequestMapping("/ppInsert")
	public String ppInsert(String ppname,RedirectAttributes ra) {
		try {
			int ppInsert=pService.ppInsert(ppname);
			ra.addFlashAttribute("result", "success");
			return "redirect:position";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("result", "failed");
			return "redirect:position";
		}
	}
	
	@RequestMapping("/ppDelete")
	public String ppDelete(int ppNum,RedirectAttributes ra) {
		try {
			pService.ppDelete(ppNum);
			ra.addFlashAttribute("delete", "success");
			return "redirect:position";
		}catch(DataIntegrityViolationException de) {
			System.out.println("제약조건 오류발생");
			ra.addFlashAttribute("delete", "failed");
			return "redirect:position";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("delete", "idk");
			return "redirect:position";
		}
	}
	
	@RequestMapping("/updatePosition")
	public String updatePosition(int ppNum,String ppName,RedirectAttributes ra) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("ppNum", ppNum);
		map.put("ppName", ppName);
		
		try {
			pService.updatePosition(map);
			ra.addFlashAttribute("update", "success");
			return "redirect:position";
		}catch(Exception e) {
			System.out.println("에러발생");
			ra.addFlashAttribute("update", "failed");
			return "redirect:position";
		}
	}
}
