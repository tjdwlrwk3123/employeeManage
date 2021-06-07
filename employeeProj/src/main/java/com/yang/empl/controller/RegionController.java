package com.yang.empl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.RegionService;
import com.yang.empl.vo.RegionVo;

@Controller
public class RegionController {
	
	@Autowired
	private RegionService rService;
	
	@RequestMapping("/insertRegion")
	public String insertRegion(String reginame,RedirectAttributes ra) {
		try {
			rService.insertRegion(reginame);
			ra.addFlashAttribute("result", "success");
			return "redirect:region";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("result", "failed");
			return "redirect:region";
		}
	}
	
	@RequestMapping("/region")
	public String regionList(Model model){
		List<RegionVo> list=rService.getRegion();
		
		model.addAttribute("regionList", list);
		
		return "/user/region";
	}
	
	@RequestMapping("/regionDelete")
	public String deleteRegion(int regionNum,RedirectAttributes ra) {
		try {
			rService.regionDelete(regionNum);
			ra.addFlashAttribute("delete", "success");
			return "redirect:region";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("delete", "failed");
			return "redirect:region";
		}
	}
}
