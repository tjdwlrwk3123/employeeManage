package com.yang.empl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
