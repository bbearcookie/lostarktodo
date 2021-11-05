package com.lostarktodo.domain;

public class HeroTypeDTO {
	private int idx; // 직업 고유 번호(PK)
	private String nameKr; // 직업 이름
	private String nameEn; // 직업 이름(영어). 저장되어있는 아이콘 파일들의 이름과 일치해야한다!
	
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
		return "HeroTypeDTO [idx=" + idx + ", nameKr=" + nameKr + ", nameEn=" + nameEn + "]";
	}
}
