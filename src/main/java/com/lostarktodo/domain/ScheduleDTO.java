package com.lostarktodo.domain;

public class ScheduleDTO {

	private int idx; // 스케줄 고유 번호(PK)
	private String scheduleName; // 스케줄 이름
	private int scheduleCode; // 스케줄 코드. 스케줄 이미지 등을 구분하기 위함.
	private int restingGauge; // 현재 휴식 게이지
	private int maxRestingGauge; // 최대 휴식 게이지
	private int completeCount; // 수행 횟수
	private int maxCompleteCount; // 최대 수행 횟수
	private int characterIdx; // CharacterDTO의 idx를 가리키는 외래 키(FK)
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public int getScheduleCode() {
		return scheduleCode;
	}
	public void setScheduleCode(int scheduleCode) {
		this.scheduleCode = scheduleCode;
	}
	public int getRestingGauge() {
		return restingGauge;
	}
	public void setRestingGauge(int restingGauge) {
		this.restingGauge = restingGauge;
	}
	public int getMaxRestingGauge() {
		return maxRestingGauge;
	}
	public void setMaxRestingGauge(int maxRestingGauge) {
		this.maxRestingGauge = maxRestingGauge;
	}
	public int getCompleteCount() {
		return completeCount;
	}
	public void setCompleteCount(int completeCount) {
		this.completeCount = completeCount;
	}
	public int getMaxCompleteCount() {
		return maxCompleteCount;
	}
	public void setMaxCompleteCount(int maxCompleteCount) {
		this.maxCompleteCount = maxCompleteCount;
	}
	public int getCharacterIdx() {
		return characterIdx;
	}
	public void setCharacterIdx(int characterIdx) {
		this.characterIdx = characterIdx;
	}
	
	@Override
	public String toString() {
		return "ScheduleDTO [idx=" + idx + ", scheduleName=" + scheduleName + ", scheduleCode=" + scheduleCode
				+ ", restingGauge=" + restingGauge + ", maxRestingGauge=" + maxRestingGauge + ", completeCount="
				+ completeCount + ", maxCompleteCount=" + maxCompleteCount + ", characterIdx=" + characterIdx + "]";
	}
	
	
}
