package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // 시작이 http://localhost:8080 부터 요청 응답 컨트롤러
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 	value : 해당 컨트롤러가 어떤 요청을 처리할 것인지 작성
	 * 
	 * http://localhost:8080/ + GET
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		return "index"; // => ViewResolver 가 돌아 : /WEB_INF/views/home.jsp 붙여서 실행해줌
	}
	
//	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	@GetMapping("/doA")
	public String doA() {
		logger.info("doA...");	
		//result.jsp 보여주고 싶다면?
		return "result";
	}
//GetMapping / PostMapping 은 메소드에만 붙일수있다

}
