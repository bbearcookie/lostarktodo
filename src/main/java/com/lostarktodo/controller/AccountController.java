package com.lostarktodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lostarktodo.domain.UserDTO;
import com.lostarktodo.mapper.UserMapper;
import com.lostarktodo.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/account/login")
	public String openAccountLogin(Model model) {
		return "pages/account/login";
	}
	
	@GetMapping(value = "/account/register")
	public String openAccountRegister(Model model) {
		UserDTO params = new UserDTO();
		params.setIdx(0);
		params.setUsername("");
		params.setPassword("");
		model.addAttribute("params", params);
		return "pages/account/register";
	}

	@PostMapping(value = "/account/login/success")
	public String loginSuccess(Model model) {
		return "redirect:/mainpage";
	}
	
	@PostMapping(value = "/account/login/failure")
	public String loginFailure(@ModelAttribute("params") final UserDTO params, Model model) {
		System.out.println("POST /account/login/failure");
		System.out.println(params);
		
		// 유효성 검사
		if (params.getUsername() == "" || params.getUsername() == null) {
			model.addAttribute("didNotTypeUsername", true);
			return "pages/account/login";
		}
		if (params.getPassword() == "" || params.getPassword() == null) {
			model.addAttribute("didNotTypePassword", true);
			return "pages/account/login";
		}
		
		// 존재하는 아이디인지 확인
		if (!accountService.checkWhetherExistUsername(params.getUsername())) {
			model.addAttribute("didNotExistUsername", true);
			return "pages/account/login";
		}
		
		// 비밀번호가 일치한지 확인
		if (!accountService.checkWhetherSamePassword(params)) {
			model.addAttribute("didNotCorrectPassword", true);
			return "pages/account/login";
		}
		
		return "pages/account/login";
	}
	
	@PostMapping(value = "/account/register")
	public String postAccountRegister(@ModelAttribute("params") final UserDTO params, Model model) {
		System.out.println(params.toString());
		
		// 유효성 검사
		if (params.getUsername() == "" || params.getUsername() == null) {
			model.addAttribute("didNotTypeUsername", true);
			return "pages/account/register";
		}
		if (params.getPassword() == "" || params.getPassword() == null) {
			model.addAttribute("didNotTypePassword", true);
			return "pages/account/register";
		}
		
		// 새로운 유저 등록
		if (accountService.registerUser(params)) {
			return "pages/account/login";
		} else {
			model.addAttribute("alreadyExistUsername", true);
			return "pages/account/register";
		}
	}
	
}
