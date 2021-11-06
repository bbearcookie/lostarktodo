package com.lostarktodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.HeroTypeDTO;
import com.lostarktodo.service.HeroTypeService;

@Controller
public class MainpageController {
	
	@Autowired
	private HeroTypeService heroTypeService;
	
	@GetMapping(value = "/mainpage")
	public String loginSuccess(@ModelAttribute HeroDTO heroParams,
							   @RequestParam(value="error", required=false) String error, 
							   Model model) {
		
		// 캐릭터 생성 모달 안에서 사용되는 값임.
		List<HeroTypeDTO> heroTypeList = heroTypeService.getAllHeroType();
		model.addAttribute("heroTypeList", heroTypeList);
		
		// 쿼리 파라미터로 넘어온 캐릭터 이름이 없다면 기본 값은 ""으로 설정.
		if (heroParams.getName() == "" || heroParams.getName()== null) {
			heroParams.setName("");
		}
		
		model.addAttribute("heroParams", heroParams);
		model.addAttribute("error", error);
		
		return "mainpage/index";
	}
}
