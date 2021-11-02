package com.lostarktodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping(value = "/hello")
	public String helloWorld(Model model) {
		System.out.println("GET /hello");
		return "test/hello";
	}
}
