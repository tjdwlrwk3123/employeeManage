package com.yang.empl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
	@RequestMapping(value="/join")
	public String join() {
		return "/user/main";
	}
}
