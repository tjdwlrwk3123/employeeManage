package com.yang.empl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		}catch(DataIntegrityViolationException de) {
			System.out.println("제약조건 오류발생");
			ra.addFlashAttribute("delete", "failed");
			return "redirect:region";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("delete", "idk");
			return "redirect:region";
		}
	}
	
	@RequestMapping("/updateRegion")
	public String updateRegion(int regionNum,String regionName,RedirectAttributes ra) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("regionnum", regionNum);
		map.put("regionname", regionName);
		
		try {
			rService.updateRegion(map);
			ra.addFlashAttribute("update", "success");
			return "redirect:region";
		}catch(Exception e) {
			System.out.println("에러발생");
			ra.addFlashAttribute("update", "failed");
			return "redirect:region";
		}
	}
}
