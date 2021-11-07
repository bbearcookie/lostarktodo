package com.lostarktodo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

// 주로 리다이렉션 URL를 지정할 때 쓰일 클래스임.
public class URL {
	private String url;
	private Map<String, String> params;
	
	// 처음에 생성자에 기본 URL를 넣어서 사용. 이후 addQueryParam 메소드로 쿼리 파라미터 변수를 하나씩 추가 가능.
	public URL(String url) {
		this.url = url;
		params = new HashMap<String, String>();
	}
	
	// URL에 쿼리 파라미터 변수를 추가함.
	public void addQueryParam(String name, String value) {
		if (value != null) {
			params.put(name, value);
		}
	}
	
	// URL에 있는 특정 쿼리 파라미터 변수를 제거함.
	public void removeQueryParam(String name) {
		params.remove(name);
	}
	
	// 최종 URL 결과를 반환함.
	public String getResult() {
		for (Map.Entry<String, String> entry : params.entrySet()) {
			try {
				// 이미 query 파라미터가 있는 경우
				if (url.contains("?")) {
					url = url + "&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
				// 아직 아무런 query 파라미터가 없는 경우
				} else {
					url = url + "?" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}

		return url;
	}
	
	@Override
	public String toString() {
		return url;
	}
}
