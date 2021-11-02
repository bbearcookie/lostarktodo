package com.lostarktodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LostarkTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LostarkTodoApplication.class, args);
		System.out.println("main 함수가 호출되었다");
	}

}
