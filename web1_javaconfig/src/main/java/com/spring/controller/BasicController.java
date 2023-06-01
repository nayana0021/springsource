package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller //@Component 자식
@RequestMapping("/sample") // option(붙일수도있고 안 붙일수도 있음), BasicController는 http://localhost:8080/sample/** 요청에 응답하는 컨트롤러라는 의미
public class BasicController {
	// 컨트롤러 안에 일반 메소드 작성 가능
	// 일반 메소드는 @RequestMapping 어노테이션을 붙이지 않으면 됨
	// 컨트롤러는 @Controller 라는 어노테이션을 반드시 붙인다
	
//	@RequestMapping("/basic") // http://localhost:8080/sample/basic + GET 방식 으로 들어오면
	@GetMapping("/basic")
	public void basic() {
		log.info("basic......요청"); // 얘가 응답해야지 이뜻
	}
	
	//컨트롤러 실행 후(없을수도있음) ViewResolver 가 실행 됨
	// 리턴이 있다면 /WEB-INF/views/리턴값.jsp
	
	// 리턴이 없다면 주소줄문자열(8080이후)을 가지고 만들어 냄 ViewResolver 는 /WEB-INF/views/sample/basic.jsp 으로 만들어서 결과 리턴
	// [/WEB-INF/views/sample/basic.jsp]
	
	// void로 하고 리턴 안했음 - 어찌됐던 뷰리졸버가 실행됨 주소줄 리턴함
}
