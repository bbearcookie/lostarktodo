package com.lostarktodo.domain;

public class ScheduleDTO {

	private int idx; // 스케줄 고유 번호(PK)
	private String name; // 스케줄 이름
	private String period; // 스케줄 일간, 주간 여부 (D, W)
	private int typeIdx; // 스케줄 코드. 스케줄 이미지 등을 구분하기 위함.
	private int restingGauge; // 현재 휴식 게이지
	private int maxRestingGauge; // 최대 휴식 게이지
	private int completeCount; // 수행 횟수
	private int maxCompleteCount; // 최대 수행 횟수
	private int heroIdx; // HeroDTO의 idx를 가리키는 외래 키(FK)
	private String disabled; // 스케줄 삭제 여부
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public int getTypeIdx() {
		return typeIdx;
	}
	public void setTypeIdx(int typeIdx) {
		this.typeIdx = typeIdx;
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
	public int getHeroIdx() {
		return heroIdx;
	}
	public void setHeroIdx(int heroIdx) {
		this.heroIdx = heroIdx;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	
	@Override
	public String toString() {
		return "ScheduleDTO [idx=" + idx + ", name=" + name + ", period=" + period + ", typeIdx=" + typeIdx
				+ ", restingGauge=" + restingGauge + ", maxRestingGauge=" + maxRestingGauge + ", completeCount="
				+ completeCount + ", maxCompleteCount=" + maxCompleteCount + ", heroIdx=" + heroIdx + ", disabled="
				+ disabled + "]";
	}
	
	
}
