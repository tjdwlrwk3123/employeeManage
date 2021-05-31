package com.yang.empl.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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

import com.yang.empl.service.EmpService;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Controller
public class InsertEmpController {
	
	@Autowired
	private EmpService eService;
	
	@RequestMapping(method = RequestMethod.GET, value="insertForm")
	public String goInsertForm(Model model) {
		
		List<DepartmentVo> deptList=eService.getDepartment();
		List<RegionVo> regList=eService.getRegion();
		List<PositionVo> posiList=eService.getPosition();
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("posiList", posiList);
		model.addAttribute("regList", regList);
		
		return "/admin/empInsert";
	}
	
	@RequestMapping(value="getBasepay",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public PayforVo getBasepay(@RequestParam(defaultValue = "1")int dept,
			@RequestParam(defaultValue = "1")int posi) {
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("dept", dept);
		map.put("posi", posi);
		
		PayforVo basepay=eService.getBasepay(map);
		
		return basepay;
	}
	
	@RequestMapping(value="empInsert")
	public String empInsert(String name, Date birth, 
			@RequestParam(defaultValue = "1") int sollun, String phone,
			String region, String department, String position, int basepay, 
			@RequestParam(defaultValue = "0") int bonus, Date joining) {
		
		//아이디 만들어내기 (부서번호+직위번호+0+순차적인 시퀀스)
		
		//시퀀스 뽑기
		List<DepartmentVo> dept=eService.getDepartment();
		int seq=eService.getIdSequence();
		
		String id=department+""+position+"0"+seq;
		
		//비밀번호 난수 만들기(6자리)
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();
		for(int i = 0; i < 6; i++){ 
			int index = rnd.nextInt(3);
	    	switch (index) {
	    		case 0:
	    			key.append((char)((int) (rnd.nextInt(26)) + 97));
	    			break;
	    		case 1:
	    			key.append((char)((int) (rnd.nextInt(26)) + 65));
	    			break;
	    		case 2:
	    			key.append((rnd.nextInt(10)));
	    			break;
	    	}
		}
		
		String password=key.toString();
		
		System.out.println("id:"+id);
		System.out.println("password:"+password);
		
		//아이디 패스워드 등록 + 리스트 저장
		HashMap<String, Object> userMap=new HashMap<String, Object>();
		HashMap<String, Object> empMap=new HashMap<String, Object>();
		
		userMap.put("userid", id);
		userMap.put("userpassword", password);
		
		empMap.put("userid", id);
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
		
		int inserting=eService.insertTransaction(userMap, empMap);
		
		if(inserting==1) {
			return "redirect:/list";
		}else {
			return "/login/denied";
		}
	}
}
