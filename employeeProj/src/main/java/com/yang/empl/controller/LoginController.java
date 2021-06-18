package com.yang.empl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yang.empl.service.LoginService;

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
					lService.changeActive(id);
					session.setAttribute("userid", id);
					return "redirect:/list";
				}else {
					ra.addFlashAttribute("result", "notEqual");
					return "redirect:/login/loginForm";
				}
			}else{
				ra.addFlashAttribute("result", "bycrypt");
				return "redirect:/login/loginForm";
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
		lService.changeActive(userid);
		session.invalidate();
		String referer=hr.getHeader("Referer");
		return "redirect:"+referer;
	}
}
