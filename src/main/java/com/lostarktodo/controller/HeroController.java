package com.lostarktodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lostarktodo.domain.HeroDTO;

@Controller
public class HeroController {
	
	@PostMapping(value = "/hero/write")
	public String createNewHero(@ModelAttribute HeroDTO heroParams, Model model) {
		System.out.println("POST /hero");
		System.out.println(heroParams);
		
		return "test/hello";
	}
	
	@GetMapping(value = "/hero/test")
	public String whycant(Model model) {
		System.out.println("GET /hero/test");
		
		return "mainpage/index";
	}
}
