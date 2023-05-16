package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;
	
	// login.jsp 보여주는 컨트롤러 작성
	@GetMapping("/login")
	public void loginGet() {
		log.info("로그인 폼 요청");
	}
	
	@PostMapping("/login")
	public String loginPost(LoginDTO loginDTO, HttpSession session) {
		log.info("로그인 요청 "+loginDTO);
		
		AuthDTO authDTO = service.login(loginDTO);
		
		if(authDTO != null) {
			// session 로그인 정보 담기
			session.setAttribute("authDTO", authDTO);
			// index 이동
			return "redirect:/";
		}else {
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		log.info("로그아웃 요청");
		// session 해제 index 이동
		session.removeAttribute("authDTO");
		return "redirect:/";
	}
	
	@GetMapping("/step1")
	public void stepGet() {
		log.info("약관 페이지 보여주기");
		// member/step1.jsp 보여주기
	}
	
	@PostMapping("/step1")
	public String stepPost(boolean agree, RedirectAttributes rttr){
		log.info("약관동의 "+agree);
		// 약관동의 여부
		
		// true 인 경우 register.jsp 보여주기
		if(agree) return "/member/register"; // forward 로 움직임..
		// false 인 경우 step1.jsp 보여주기
		else {
			rttr.addFlashAttribute("check", false); // session 객체를 쓰는것임 EL 사용 가능
			return "redirect:/member/step1"; // 이것은 redirect 방법
//			return "/member/step1"; // ==> View Resolver 가 돌아 이 방식은 forward (redirect 가 아니면)
		}
	}
	
	@PostMapping("/register")
	public String registerPost(MemberDTO dto) {
		log.info("회원가입 요청 " + dto);
		
		// 회원가입 성공 시 로그인 페이지 이동
		 if(service.register(dto)) {
			 return "redirect:/member/login";
		 }else {
			 return "/member/register";
		 }	
	}
	
	
}
