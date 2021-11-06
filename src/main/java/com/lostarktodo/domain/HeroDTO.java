package com.lostarktodo.domain;

public class HeroDTO {

	private int idx; // 캐릭터 고유 번호(PK)
	private String name; // 캐릭터 닉네임
	private int typeIdx; // 직업 코드. 캐릭터 이미지 등을 구분하기 위함.
	private int userIdx; // UserDTO의 idx를 가리키는 외래 키(FK)
	private String disabled; // 캐릭터 삭제 여부
	private HeroTypeDTO heroTypeDTO; // HeroTypeDTO와 join
	
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
	public int getTypeIdx() {
		return typeIdx;
	}
	public void setTypeIdx(int typeIdx) {
		this.typeIdx = typeIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public HeroTypeDTO getHeroTypeDTO() {
		return heroTypeDTO;
	}
	public void setHeroTypeDTO(HeroTypeDTO heroTypeDTO) {
		this.heroTypeDTO = heroTypeDTO;
	}
	
	@Override
	public String toString() {
		return "HeroDTO [idx=" + idx + ", name=" + name + ", typeIdx=" + typeIdx + ", userIdx=" + userIdx
				+ ", disabled=" + disabled + ", heroTypeDTO=" + heroTypeDTO + "]";
	}
	
	
}
