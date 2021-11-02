package com.lostarktodo.domain;

public class CharacterDTO {

	private int idx; // 캐릭터 고유 번호(PK)
	private String name; // 캐릭터 닉네임
	private int classCode; // 직업 코드. 캐릭터 이미지 등을 구분하기 위함.
	private int userIdx; // UserDTO의 idx를 가리키는 외래 키(FK)
	
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
	public int getClassCode() {
		return classCode;
	}
	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	
	@Override
	public String toString() {
		return "CharacterDTO [idx=" + idx + ", name=" + name + ", classCode=" + classCode + ", userIdx=" + userIdx
				+ "]";
	}
	
}
