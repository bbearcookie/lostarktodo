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
		
		System.out.println(scheduleResult);
		System.out.println("watchingHeroIdx: " + watchingHeroIdx);
		
		return url.getResult();
	}
}
