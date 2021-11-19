package com.lostarktodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.ScheduleDTO;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.service.HeroService;
import com.lostarktodo.service.ScheduleService;
import com.lostarktodo.util.URL;

// 스케줄에 관한 요청을 처리하는 컨트롤러
@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private HeroService heroService;
	
	// 스케줄 생성시
	@PostMapping(value = "/schedule/write")
	public String createNewSchedule(@ModelAttribute ScheduleDTO scheduleResult,
									@RequestParam(value="watchingHeroIdx", required=false) String watchingHeroIdx,
									Model model) {
		URL url = new URL("redirect:/mainpage");
		url.addQueryParam("watchingHeroIdx", watchingHeroIdx);
		url.addQueryParam("name", scheduleResult.getName());
		url.addQueryParam("typeIdx", String.valueOf(scheduleResult.getTypeIdx()));
		url.addQueryParam("period", scheduleResult.getPeriod());
		url.addQueryParam("idx", String.valueOf(scheduleResult.getIdx()));
		url.addQueryParam("restingGauge", String.valueOf(scheduleResult.getRestingGauge()));
		url.addQueryParam("completeCount", String.valueOf(scheduleResult.getCompleteCount()));
		url.addQueryParam("maxCompleteCount", String.valueOf(scheduleResult.getMaxCompleteCount()));
		
		// 쿼리 스트링으로 받았었던, 현재 조회중인 캐릭터의 idx를 담은 값인 watchingHeroIdx의 값으로 스케줄의 heroIdx값을 설정함.
		scheduleResult.setHeroIdx(Integer.parseInt(watchingHeroIdx));
		
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
		
		// 스케줄 생성 모달 폼 내용 초기화
		url.removeQueryParam("name");
		url.removeQueryParam("typeIdx");
		url.removeQueryParam("period");
		url.removeQueryParam("idx");
		url.removeQueryParam("restingGauge");
		url.removeQueryParam("completeCount");
		url.removeQueryParam("maxCompleteCount");
		
		return url.getResult();
	}
	
	// 스케줄 제거시
	@PostMapping(value = "/schedule/delete")
	public String deleteSchedule(@AuthenticationPrincipal UserDTO userResult,
								 @RequestParam String idx,
								 @RequestParam(value="watchingHeroIdx", required=false) String watchingHeroIdx,
								 Model model) {
		URL url = new URL("redirect:/mainpage");
		url.addQueryParam("watchingHeroIdx", watchingHeroIdx);
		
		ScheduleDTO schedule = scheduleService.getSchedule(Integer.parseInt(idx));
		HeroDTO watchingHero = heroService.getHero(Integer.parseInt(watchingHeroIdx));
		
		// 지우려는 스케줄이 해당 캐릭터의 것이 아니면 실패
		if (schedule.getHeroIdx() != watchingHero.getIdx()) {
			System.out.println("해당 캐릭터의 스케줄이 아님.");
			return url.getResult();
		}
		// 해당 캐릭터가 로그인한 유저의 것이 아니라면 실패
		if (watchingHero.getUserIdx() != userResult.getIdx()) {
			System.out.println("해당 유저의 캐릭터가 아님.");
			return url.getResult();
		}
		
		scheduleService.deleteSchedule(Integer.parseInt(idx));
		
		return url.getResult();
	}
	
	// 관리자의 기능으로써 날짜가 지나면서 스케줄의 휴식 게이지와 완료 횟수를 수치에 맞게 업데이트하는 기능
	@GetMapping(value = "/admin/schedule/calculation")
	public String calculateSchedule(@AuthenticationPrincipal UserDTO userResult,
									@RequestParam(value="watchingHeroIdx", required=false) String watchingHeroIdx,
									Model model) {
		URL url = new URL("redirect:/mainpage");
		
		// watchingHeroIdx 값이 있는 경우에만 쿼리에 담아서 보내줌. (사용자가 해당 캐릭터에 대해 스케줄 조회를 요청했을때 생김.)
		if (!(watchingHeroIdx == "" || watchingHeroIdx == null)) {
			url.addQueryParam("watchingHeroIdx", watchingHeroIdx);
		}
		
		// 관리자인지 아닌지 확인
		if (userResult.getRole().equals("ROLE_ADMIN")) {
			scheduleService.calculateRestingGauge();
		}
		
		return url.getResult();
	}
	
	// 해당 스케줄의 정보를 REST 방식으로 반환.
	@ResponseBody
	@GetMapping(value = "/api/schedule/{scheduleIdx}")
	public ScheduleDTO getScheduleInfo(@PathVariable String scheduleIdx, Model model) {
		ScheduleDTO params = scheduleService.getSchedule(Integer.parseInt(scheduleIdx));
		return params;
	}
	
	// 해당 스케줄의 completeCount를 1 증가시킴. 만약 maxCompleteCount를 초과한다면 0으로 변경.
	@ResponseBody
	@PatchMapping(value = "/api/schedule/complete/{scheduleIdx}")
	public ScheduleDTO increaseCompleteSchedule(@PathVariable String scheduleIdx, Model model) {
		ScheduleDTO params = scheduleService.increaseCompleteSchedule(Integer.parseInt(scheduleIdx));
		return params;
	}
}
