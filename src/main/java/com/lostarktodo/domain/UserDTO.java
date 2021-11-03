package com.lostarktodo.domain;

public class UserDTO {
	
	private long idx; // 유저 고유 번호(PK)
	private String userid; // 사용자 아이디
	private String password; // 암호화 되어 저장된 비밀번호
	private String role;
	
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserDTO [idx=" + idx + ", userid=" + userid + ", password=" + password + ", role=" + role + "]";
	}
	
}
