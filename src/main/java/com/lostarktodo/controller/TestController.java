package com.lostarktodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lostarktodo.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;

	@GetMapping(value = "/hello")
	public String helloWorld(Model model) {
		System.out.println("GET /hello");
		return "test/hello";
	}
}
