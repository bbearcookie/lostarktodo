package com.lostarktodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lostarktodo.domain.HeroTypeDTO;
import com.lostarktodo.service.HeroTypeService;

@Controller
public class MainpageController {
	
	@Autowired
	private HeroTypeService heroTypeService;
	
	@GetMapping(value = "/mainpage")
	public String loginSuccess(Model model) {
		List<HeroTypeDTO> heroTypeList = heroTypeService.getAllHeroType();
		model.addAttribute("heroClassName", "warlord");
		model.addAttribute("heroTypeList", heroTypeList);
		
		return "mainpage/index";
	}
}
