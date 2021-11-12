package com.lostarktodo.domain;

public class GlobalVariables {
	
	private static int scheduleResetCycle = 0; // 주간 스케줄은 7일마다 초기화해야함. 일간 스케줄이 몇번 초기화 되었는지를 나타내는 변수.

	public static int getScheduleResetCycle() {
		return scheduleResetCycle;
	}

	public static void setScheduleResetCycle(int scheduleResetCycle) {
		GlobalVariables.scheduleResetCycle = scheduleResetCycle;
	}
	
	public static void increaseScheduleResetCycle() {
		if (scheduleResetCycle < 6) {
			GlobalVariables.scheduleResetCycle += 1;
		} else {
			GlobalVariables.scheduleResetCycle = 0;
		}
	}

}
