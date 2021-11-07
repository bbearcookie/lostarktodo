package com.lostarktodo.domain;

public class ScheduleTypeDTO {
	private int idx; // 스케줄 고유 번호(PK)
	private String nameKr; // 스케줄 아이콘 한글이름
	private String nameEn; // 스케줄 아이콘 영어이름. 저장되어있는 아이콘 파일들의 이름과 일치해야한다!
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getNameKr() {
		return nameKr;
	}
	public void setNameKr(String nameKr) {
		this.nameKr = nameKr;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	
	@Override
	public String toString() {
		return "ScheduleTypeDTO [idx=" + idx + ", nameKr=" + nameKr + ", nameEn=" + nameEn + "]";
	}

}
