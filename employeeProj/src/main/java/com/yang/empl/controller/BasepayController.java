package com.yang.empl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.BasepayService;
import com.yang.empl.service.DepartmentService;
import com.yang.empl.service.PositionService;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.PayDeptPositionJoinVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;

@Controller
public class BasepayController {
	@Autowired
	private DepartmentService dService;
	@Autowired
	private PositionService pService;
	@Autowired
	private BasepayService bService;
	
	@RequestMapping("/basepay")
	public String payList(Model model) {
		List<PayDeptPositionJoinVo> list=bService.getAllBasepay();
		List<DepartmentVo> dlist=dService.getDepartment();
		List<PositionVo> plist=pService.getPosition();
		
		model.addAttribute("bList", list);
		model.addAttribute("dList", dlist);
		model.addAttribute("pList", plist);
		
		return "/user/basepay";
	}
	
	@RequestMapping(value="getBasepay",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public PayforVo getBasepay(@RequestParam(defaultValue = "1")int dept,
			@RequestParam(defaultValue = "1")int posi) {
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("dept", dept);
		map.put("posi", posi);
		
		PayforVo basepay=bService.getBasepay(map);
		
		return basepay;
	}
	
	@RequestMapping("/mergeBasepay")
	public String mergeBasepay(int deptNum,int ppNum,int basepay,RedirectAttributes ra) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		System.out.println(deptNum);
		System.out.println(ppNum);
		System.out.println(basepay);
		
		map.put("deptNum", deptNum);
		map.put("ppNum", ppNum);
		map.put("basepay", basepay);
		
		try {
			bService.mergeBasepay(map);
			ra.addFlashAttribute("result", "success");
			return "redirect:basepay";
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("result", "failed");
			return "redirect:basepay";
		}
		
	}
}
