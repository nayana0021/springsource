package com.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

//	/member/login
	@GetMapping("/login")
	public void loginGet() {
		log.info("로그인 폼 요청");
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		
		model.addAttribute("error","아이디나 비밀번호를 확인해 주세요");
		
		return "/member/login";
	}
	
	@GetMapping("/admin")
	public void adminGet() {
		log.info("admin 요청");
	}
	
	@GetMapping("/auth")
	@ResponseBody	// jsp 찾지말라고.. 텍스트,DTO 형태로 보낼수있는데 pom.xml 에 잭슨데이터바인더 라이브러리를 사용해서 json 형태로 전송됨
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	
}
