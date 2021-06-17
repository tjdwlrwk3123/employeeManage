package com.yang.empl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			, HttpSession session) {
		try {
			if(lService.getUserinfo(id).getChangePassword()==0) {
				if(password.equals(lService.getUserinfo(id).getUserPassword())) {
					session.setAttribute("userid", id);
					return "/user/main";
				}else {
					model.addAttribute("result", "notEqual");
					return "redirect:/login/loginForm";
				}
			}else{
				model.addAttribute("result", "bycrypt");
				return "redirect:/login/loginForm";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "failed");
			return "redirect:/login/loginForm";
		}
	}
}
