package com.lostarktodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 주기적으로 코드를 실행하는 스케줄링 기능을 사용하도록 설정
public class LostarkTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostarkTodoApplication.class, args);
		System.out.println("스프링 프로그램 실행됨");
	}

}
