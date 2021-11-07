package com.lostarktodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.HeroTypeDTO;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.service.HeroService;
import com.lostarktodo.service.HeroTypeService;

@Controller
public class MainpageController {
	
	@Autowired
	private HeroService heroService;
	
	@Autowired
	private HeroTypeService heroTypeService;

	// @AuthenticationPrincipal 어노테이션으로 로그인된 유저의 UserDTO 정보를 가져올 수 있다!
	@GetMapping(value = "/mainpage")
	public String loginSuccess(@AuthenticationPrincipal UserDTO user,
							   @ModelAttribute HeroDTO heroWriteParams,
							   @RequestParam(value="error", required=false) String error,
							   Model model) {
		
		// 캐릭터 생성 모달 안에서 사용되는 값임.
		List<HeroTypeDTO> heroTypeList = heroTypeService.getAllHeroType();
		model.addAttribute("heroTypeList", heroTypeList);
		
		// 쿼리 파라미터로 넘어온 캐릭터 이름이 없다면 기본 값은 ""으로 설정.
		if (heroWriteParams.getName() == "" || heroWriteParams.getName()== null) {
			heroWriteParams.setName("");
		}
		
		List<HeroDTO> possesedHeroList = heroService.selectHeroListAndHeroTypeByUseridx(user.getIdx());
		
		// 모델에 담아서 보내줌.
		model.addAttribute("heroList", possesedHeroList);
		model.addAttribute("heroWriteParams", heroWriteParams);
		model.addAttribute("error", error);
		
		return "pages/mainpage/index";
	}
}
