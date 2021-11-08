package com.lostarktodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
		
		// 현재로써 최대 휴식게이지는 무조건 100이기 때문에 최대 휴식 게이지를 100으로 설정함.
		scheduleResult.setMaxRestingGauge(100);

		// 유효성 검사
		if (scheduleResult.getTypeIdx() == 0) {
			url.addQueryParam("error", "didNotSelectScheduleIcon");
			return url.getResult();
		}
		if (scheduleResult.getName() == "" || scheduleResult.getName() == null) {
			url.addQueryParam("error", "didNotTypeSchedulename");
			return url.getResult();
		}
		// 목표 완료 횟수를 0이하로 입력받았으면 클라이언트에 다시 요청.
		if (scheduleResult.getMaxCompleteCount() <= 0) {
			url.addQueryParam("error", "didNotTypeValidMaxCompleteCount");
			return url.getResult();
		}
		
		// 해당 스케줄 정보 수정 혹은 등록
		scheduleService.registerSchedule(scheduleResult);
		
		return url.getResult();
	}
	
	// 해당 스케줄의 completeCount를 1 증가시킴. 만약 maxCompleteCount를 초과한다면 0으로 변경.
	@ResponseBody
	@PatchMapping(value = "/api/schedule/complete/{scheduleIdx}")
	public ScheduleDTO increaseCompleteSchedule(@PathVariable String scheduleIdx, Model model) {
		ScheduleDTO params = scheduleService.increaseCompleteSchedule(Integer.parseInt(scheduleIdx));
		
		return params;
	}
}
