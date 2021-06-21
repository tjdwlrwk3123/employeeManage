package com.yang.empl.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.LoginService;
import com.yang.empl.vo.UserInfoVo;

@Controller
public class LoginController {
	@Autowired
	private LoginService lService;
	
	@RequestMapping(value="/login/accessDenied")
	public String denied() {
		return "/login/denied";
	}
	
	@RequestMapping(value="/login/loginForm")
	public String loginForm() {
		return "/login/loginForm";
	}
	
	@RequestMapping(value="/login/loginSubmit")
	public String submit(Model model, @RequestParam(value="id") String id
			, @RequestParam(value="password") String password
			, HttpSession session
			, RedirectAttributes ra) {
		try {
			if(lService.getUserinfo(id).getChangePassword()==0) {
				if(password.equals(lService.getUserinfo(id).getUserPassword())) {
					System.out.println(lService.getUserinfo(id).getUserId());
					System.out.println(password);
					System.out.println(lService.getUserinfo(id).getUserPassword());
					lService.changeActiveLogin(id);
					session.setAttribute("userid", id);
					return "redirect:/list";
				}else {
					ra.addFlashAttribute("result", "notEqual");
					return "redirect:/login/loginForm";
				}
			}else{
				BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
				String match=lService.getUserinfo(id).getUserPassword();
				if(encoder.matches(password, match)) {
					lService.changeActiveLogin(id);
					session.setAttribute("userid", id);
					return "redirect:/list";
				}else {
					ra.addFlashAttribute("result", "notEqual");
					return "redirect:/login/loginForm";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("result", "noId");
			return "redirect:/login/loginForm";
		}
	}
	@RequestMapping("/login/logout")
	public String logout(HttpSession session,HttpServletRequest hr) {
		String userid=(String)session.getAttribute("userid");
		lService.changeActiveLogout(userid);
		session.invalidate();
		String referer=hr.getHeader("Referer");
		return "redirect:"+referer;
	}
	
	@RequestMapping("/login/changeForm")
	public String changeForm() {
		return "/login/changeForm";
	}
	@RequestMapping("/login/changePassword")
	public String changePassword(HttpSession session,String oldP,String newP,Model model) {
		String userid=(String)session.getAttribute("userid");
		//처음 변경하는 경우(복호화가 필요없음)
		if(lService.getUserinfo(userid).getChangePassword()==0) {
			if(oldP.equals(lService.getUserinfo(userid).getUserPassword())) {
				lService.changePassword(userid,newP);
				return "redirect:/";
			}else {
				model.addAttribute("result","notEqual");
				return "/login/changeForm";
			}
		//두번째 이후 변경하는 경우(복호화 매치필요)
		}else {
			String password=lService.getUserinfo(userid).getUserPassword();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			if(encoder.matches(oldP, password)) {
				lService.changePassword(userid,newP);
				return "redirect:/";
			}else {
				model.addAttribute("result", "notEqual");
				return "/login/changeForm";
			}
		}
	}
	
}
