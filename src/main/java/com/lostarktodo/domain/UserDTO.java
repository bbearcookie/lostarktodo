package com.lostarktodo.domain;

public class UserDTO {
	
	private int idx; // 유저 고유 번호(PK)
	private String id; // 사용자 아이디
	private String pw; // 암호화되어 저장된 비밀번호
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "UserDTO [idx=" + idx + ", id=" + id + ", pw=" + pw + "]";
	}
}
