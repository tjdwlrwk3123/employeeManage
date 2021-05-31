package com.yang.empl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
	@RequestMapping(value="/list")
	public String join() {
		return "/user/main";
	}
}
