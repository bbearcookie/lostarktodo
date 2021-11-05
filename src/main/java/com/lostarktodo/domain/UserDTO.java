package com.lostarktodo.domain;

public class UserDTO {
	
	private int idx; // 유저 고유 번호(PK)
	private String username; // 사용자 아이디
	private String password; // 암호화 되어 저장된 비밀번호
	private String role;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return "UserDTO [idx=" + idx + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
}
