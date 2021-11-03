package com.lostarktodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/account/login")
	public String openAccountLogin(Model model) {
		return "account/login";
	}
	
	@GetMapping(value = "/account/register")
	public String openAccountRegister(Model model) {
		UserDTO params = new UserDTO();
		params.setIdx(0);
		params.setUserid("");
		params.setPassword("");
		model.addAttribute("params", params);
		return "account/register";
	}
	
//	@PostMapping(value = "/account/login")
//	public String postAccountLogin(@ModelAttribute("params") final UserDTO params, Model model) {
//		System.out.println(params.toString());
//		return "account/login";
//	}
	
	@PostMapping(value = "/account/register")
	public String postAccountRegister(@ModelAttribute("params") final UserDTO params, Model model) {
		System.out.println(params.toString());
		
		// 유효성 검사
		if (params.getUserid() == "" || params.getUserid() == null) {
			model.addAttribute("didNotTypeUserid", true);
			return "account/register";
		}
		if (params.getPassword() == "" || params.getUserid() == null) {
			model.addAttribute("didNotTypePassword", true);
			return "account/register";
		}
		
		// 새로운 유저 등록
		if (accountService.registerUser(params)) {
			return "account/login";
		} else {
			model.addAttribute("alreadyExistUserid", true);
			return "account/register";
		}
	}
	
}
