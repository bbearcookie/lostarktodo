package com.lostarktodo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lostarktodo.service.ScheduleService;

// 특정 주기마다 실행할 로직을 담은 클래스
@Component
public class ScheduledTasks {
	
	@Autowired
	private ScheduleService scheduleService;

	@Scheduled(cron = "0 0 6 * * *") // 매일 오전 6시마다 스케줄의 휴식 게이지와 완료 횟수등 계산
	public void runEvery6oclock() {
		scheduleService.calculateRestingGauge();
	}
}
