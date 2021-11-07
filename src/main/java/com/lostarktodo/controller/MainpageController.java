package com.lostarktodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.lostarktodo.domain.HeroDTO;
import com.lostarktodo.domain.HeroTypeDTO;
import com.lostarktodo.domain.ScheduleDTO;
import com.lostarktodo.domain.ScheduleTypeDTO;
import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.service.HeroService;
import com.lostarktodo.service.HeroTypeService;
import com.lostarktodo.service.ScheduleService;
import com.lostarktodo.service.ScheduleTypeService;

@Controller
public class MainpageController {
	
	@Autowired
	private HeroService heroService;
	
	@Autowired
	private HeroTypeService heroTypeService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private ScheduleTypeService scheduleTypeService;

	// @AuthenticationPrincipal 어노테이션으로 로그인된 유저의 UserDTO 정보를 가져올 수 있다!
	@GetMapping(value = "/mainpage")
	public String loginSuccess(@AuthenticationPrincipal UserDTO user,
							   @ModelAttribute HeroDTO heroWriteParams,
							   @ModelAttribute ScheduleDTO scheduleWriteParams,
							   @RequestParam(value="error", required=false) String error,
							   @RequestParam(value="watchingHeroIdx", required=false) String watchingHeroIdx,
							   Model model) {
		
		// 캐릭터 타입, 스케줄 타입 정보 보내줌. =======================================
		List<HeroTypeDTO> heroTypeList = heroTypeService.getAllHeroType();
		List<ScheduleTypeDTO> scheduleTypeList = scheduleTypeService.selectScheduleTypeList();
		model.addAttribute("heroTypeList", heroTypeList);
		model.addAttribute("scheduleTypeList", scheduleTypeList);
		
		// 쿼리 파라미터로 넘어온 캐릭터 이름이 없다면 기본 값은 ""으로 설정.
		if (heroWriteParams.getName() == "" || heroWriteParams.getName()== null) {
			heroWriteParams.setName("");
		}
		
		// 해당 유저가 가지고 있는 모든 캐릭터들
		List<HeroDTO> possesedHeroList = heroService.selectHeroListAndHeroTypeByUseridx(user.getIdx());
		model.addAttribute("heroList", possesedHeroList);
		
		// 해당 캐릭터가 가지고 있는 일간 주간 스케줄들
		if (watchingHeroIdx != null) {
			List<ScheduleDTO> possesedDailyScheduleList = scheduleService.selectDailyScheduleListAndScheduleTypeByHeroidx(Integer.parseInt(watchingHeroIdx));
			List<ScheduleDTO> possesedWeeklyScheduleList = scheduleService.selectWeeklyScheduleListAndScheduleTypeByHeroidx(Integer.parseInt(watchingHeroIdx));
			model.addAttribute("dailyScheduleList", possesedDailyScheduleList);
			model.addAttribute("weeklyScheduleList", possesedWeeklyScheduleList);
		}
		
		// 스케줄 조회 기능에서 사용되는 값임. ==========================================
		// watchingHeroIdx 값이 있는 경우에만 모델에 담아서 보내줌. (사용자가 해당 캐릭터에 대해 스케줄 조회를 요청했을때 생김.)
		if (!(watchingHeroIdx == "" || watchingHeroIdx == null)) {
			model.addAttribute("watchingHeroIdx", watchingHeroIdx);
		}
		
		// 모델에 담아서 보내줌.  ===================================================
		model.addAttribute("heroWriteParams", heroWriteParams);
		model.addAttribute("scheduleWriteParams", scheduleWriteParams);
		model.addAttribute("error", error);
		
		return "pages/mainpage/index";
	}
}
