package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginDTO;
import com.spring.domain.RegisterDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 쓸거임
@Controller // http://localhost:8080 요청 응답 컨트롤러 - 이건 고정
@RequestMapping("/member") // 여기에 붙이면 멤버 밑으로 들어오는 요청에 대한 처리만 한다구 안 붙이면 요청 처리가 더 넓어지는 의미
public class MemberController {
	
	// GET + POST 둘 다 응답
	
	// 사용자 입력값 가져오기
	// 1) HttpServletRequest 사용하기
	// 2) 변수 사용 : 변수명은 폼 태그 name 과 일치 2) 폼 태그 name 과 일치하지 않을 때 @RequestParam 사용
	// 3) 바인딩 객체 사용
	
	
//	@RequestMapping("/login") // http://localhost:8080/member/login
//	@RequestMapping(value="/login", method = RequestMethod.GET ) // get일때만 허용할거야
	@GetMapping("/login")
	public void loginGet(HttpServletRequest req) {
		log.info("login...");
		log.info("method "+req.getMethod());
//		return "/member/login"; // (리턴이 있든 없든 뷰리졸버가 돈다) 리턴이 있다면 -> 앞쪽에 무조건 붙여서 /WEB_INF/views/login.jsp 로 만들어줌
	}
	
//	@RequestMapping(value="/login", method = RequestMethod.POST ) // get일때만 허용할거야
//	@PostMapping("/login")
//	public void loginPost(HttpServletRequest req) {
//		log.info("login post...");
//		log.info("method "+req.getMethod());
//		// 사용자 입력값 id, password 가져오기
//		System.out.println("id "+req.getParameter("id"));
//		System.out.println("password "+req.getParameter("password"));
//	}

	
//	@PostMapping("/login") //@RequestParam이 userid 인 것을 id로 받아준다는 뜻임
//	public void loginPost(@RequestParam("userid") String id, String password) { //login.jsp 에서 name인 것 받음
//		log.info("login post...");
//		// 사용자 입력값 id, password 가져오기
//		System.out.println("id "+id);
//		System.out.println("password "+password);
//	}

	@PostMapping("/login") 
	public String loginPost(LoginDTO dto, Model model) { 
		log.info("login post...");
		// 사용자 입력값 id, password 
		System.out.println("id "+dto.getId());
		System.out.println("password "+dto.getPassword());
		
		model.addAttribute("id", dto.getId());
		// main.jsp 보여주기
		return "/member/main";
	}

	
	
	
//	@RequestMapping("/register") // http://localhost:8080/member/register 이렇게 요청이 들어갔고
	@GetMapping("/register")
	public void registerGet() {
		log.info("register...");
//		return "/member/register"; // 리턴이 있다면 뷰리졸버가 돌아서 -> /WEB_INF/views/register.jsp 로 만들어줌
	}

	// /member/register + POST 처리
	// DTO 작성
	// 사용자 입력값이 잘 들어왔는지 확인
	// login.jsp 보여주기
	@PostMapping("/register")
	public String registerPost(RegisterDTO dto) {
		log.info("회원가입 요청");
		log.info(dto.toString());
		
		// redirect : 붙게 되면 뷰리졸버가 도는게 아니고 DispatcherServlet 이 동작
		// == response.sendRedirect()
		// http://localhost:8080/member/login + GET 요청이 들어가게 됨
		return "redirect:/member/login"; // 경로가 되어버림 (redirect: 가 붙지 않으면 뷰리졸버가 돌아서 원하는 jsp 로 이동하게됨 : 포워드)
	}
	
	
}
