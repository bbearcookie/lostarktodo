package com.lostarktodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainpageController {
	
	@GetMapping(value = "/mainpage")
	public String loginSuccess(Model model) {
		return "mainpage/index";
	}
}
