package com.lostarktodo.util;

// 주로 리다이렉션 URL를 지정할 때 쓰일 클래스임.
public class URL {
	private String value;
	
	// 처음에 생성자에 기본 URL를 넣어서 사용. 이후 addQueryParam 메소드로 쿼리 파라미터 변수를 하나씩 추가 가능.
	public URL(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	// URL에 쿼리 파라미터 변수를 추가함.
	public void addQueryParam(String name, String value) {
		// 이미 query 파라미터가 있는 경우
		if (this.value.contains("?")) {
			this.value = this.value + "&" + name + "=" + value;
		// 아직 아무런 query 파라미터가 없는 경우
		} else {
			this.value = this.value + "?" + name + "=" + value;
		}
	}
	
}
