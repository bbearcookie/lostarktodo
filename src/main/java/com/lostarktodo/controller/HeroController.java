package com.lostarktodo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.UserDTO;

@Controller
public class HeroController {
	
	// @AuthenticationPrincipal 어노테이션으로 로그인된 유저의 UserDTO 정보를 가져올 수 있다!
	@PostMapping(value = "/hero/write")
	public String createNewHero(@ModelAttribute HeroDTO heroResult, @AuthenticationPrincipal UserDTO userResult, Model model) {
		System.out.println(heroResult);
		System.out.println(userResult);
		
		return "redirect:/mainpage";
	}
	
	@GetMapping(value = "/hero/test")
	public String whycant(Model model) {
		System.out.println("GET /hero/test");
		
		return "mainpage/index";
	}
}
