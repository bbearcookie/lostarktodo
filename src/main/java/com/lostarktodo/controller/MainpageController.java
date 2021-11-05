package com.lostarktodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.HeroTypeDTO;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.service.HeroTypeService;

@Controller
public class MainpageController {
	
	@Autowired
	private HeroTypeService heroTypeService;
	
	@GetMapping(value = "/mainpage")
	public String loginSuccess(Model model) {
		
		// 캐릭터 생성 모달 안에서 사용되는 값임.
		List<HeroTypeDTO> heroTypeList = heroTypeService.getAllHeroType();
		model.addAttribute("heroTypeList", heroTypeList);
		
		// 캐릭터 생성 모달에서 작성해야할 양식임. 폼으로부터 POST요청을 받으려면 먼저 받아야 할 양식을 미리 제공해줘야함.
		HeroDTO heroParams = new HeroDTO();
		heroParams.setIdx(0);
		heroParams.setName("");
		heroParams.setTypeIdx(0);
		heroParams.setUserIdx(0);
		model.addAttribute("heroParams", heroParams);
		
		return "mainpage/index";
	}
}
