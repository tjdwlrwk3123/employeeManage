package com.yang.empl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
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
			, @RequestParam(value="password") String password) {
		return null;
	}
}
