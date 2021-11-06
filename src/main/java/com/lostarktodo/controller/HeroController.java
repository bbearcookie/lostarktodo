package com.lostarktodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.service.HeroService;
import com.lostarktodo.util.URL;

@Controller
public class HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@PostMapping(value = "/hero/write")
	public String createNewHero(@AuthenticationPrincipal UserDTO userResult, @ModelAttribute HeroDTO heroResult, Model model) {
		URL url = new URL("redirect:/mainpage");
		url.addQueryParam("name", heroResult.getName());
		url.addQueryParam("typeIdx", String.valueOf(heroResult.getTypeIdx()));

		// 유효성 검사
		// 뭔가 입력 폼에 문제가있다면 쿼리스트링에 정보들을 담아서 redirect 시켜서 GET요청 다시하도록 하면된다. 그후 뭐가 문젠지 화면에서 alert 보여준다.
		if (heroResult.getTypeIdx() == 0) {
			url.addQueryParam("error", "didNotSelectHerotype");
			return url.getResult();
		}
		if (heroResult.getName() == "" || heroResult.getName() == null) {
			url.addQueryParam("error", "didNotTypeHeroname");
			return url.getResult();
		}
		
		// 로직 처리
		heroResult.setUserIdx(userResult.getIdx());
		heroService.createHero(heroResult);
		
		// 캐릭터 생성 모달 폼 내용 초기화
		url.removeQueryParam("name");
		url.removeQueryParam("typeIdx");
		
		return url.getResult();
	}
}
