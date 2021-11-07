package com.lostarktodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lostarktodo.domain.ScheduleDTO;
import com.lostarktodo.service.ScheduleService;
import com.lostarktodo.util.URL;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping(value = "/schedule/write")
	public String createNewSchedule(@ModelAttribute ScheduleDTO scheduleResult,
									@RequestParam(value="watchingHeroIdx", required=false) String watchingHeroIdx,
									Model model) {
		URL url = new URL("redirect:/mainpage");
		url.addQueryParam("watchingHeroIdx", watchingHeroIdx);
		url.addQueryParam("name", scheduleResult.getName());
		url.addQueryParam("typeIdx", String.valueOf(scheduleResult.getTypeIdx()));

		
		// 쿼리 스트링으로 받았었던, 현재 조회중인 캐릭터의 idx를 담은 값인 watchingHeroIdx의 값으로 스케줄의 heroIdx값을 설정함.
		scheduleResult.setHeroIdx(Integer.parseInt(watchingHeroIdx));
		System.out.println(scheduleResult);

		// 유효성 검사
		if (scheduleResult.getTypeIdx() == 0) {
			url.addQueryParam("error", "didNotSelectScheduleIcon");
			return url.getResult();
		}
		if (scheduleResult.getName() == "" || scheduleResult.getName() == null) {
			url.addQueryParam("error", "didNotTypeSchedulename");
			return url.getResult();
		}
		
		// 해당 스케줄 정보 수정 혹은 등록
		scheduleService.registerSchedule(scheduleResult);
		
		return url.getResult();
	}
}
