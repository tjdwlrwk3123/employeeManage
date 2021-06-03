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
	
	@RequestMapping(method = RequestMethod.GET, value="insertForm")
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
	
	@RequestMapping(value="empInsert")
	public String empInsert(String name, Date birth, 
			@RequestParam(defaultValue = "1") int sollun, String phone,
			String region, String department, String position, int basepay, 
			@RequestParam(defaultValue = "0") int bonus, Date joining,
			HttpServletRequest req, RedirectAttributes ra) {
		
		//아이디 만들어내기 (부서번호+직위번호+0+순차적인 시퀀스)
		
		//시퀀스 뽑기
		List<DepartmentVo> dept=dService.getDepartment();
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
			ra.addFlashAttribute("failed", "failed");
			//이전페이지로 가기
			String referer=req.getHeader("Referer");
			return "redirect:"+referer;
		}
	}
}
