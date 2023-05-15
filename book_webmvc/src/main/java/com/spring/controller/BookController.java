package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.BookDTO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller //컨트롤러를 만든다면 조건 붙이기 컨트롤러 만들었다면 서버 다시 돌리기
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;
	

	// insert.jsp 보여주기 => http://localhost:8080/book/insert + GET
	// /product/insert.jsp 보여주기
//	@GetMapping("/insert")
//	public String insertForm() { // 메소드명 마음대로 짓기(insertForm)
//		log.info("도서 정보 추가 폼 요청");
//		
//		return "/product/insert";
//	}
//	
//	// http://localhost:8080/book/insert + POST
//	@PostMapping("/insert")
//	public String insertPost(BookDTO dto) {
//		log.info("도서 정보 추가");
//		
//		// 입력값 가져오기 - HttpServletRequest, 변수, ~~DTO
//		// 서비스 작업 
//		try {
//			boolean insertFlag = service.insert(dto);
//			if(insertFlag) {
//				// 입력 성공 시 목록 보여주기
//				return "redirect:/book/list"; // jsp 로 가는게 아니라 경로찾아줘야함
//			}else {
//				// 입력 실패 시 insert.jsp 보여주기
//				return "/product/insert"; // list.jsp 로 감
//			}
//		} catch (Exception e) {
//			System.out.println("오류");
//			return "/product/insert"; // 500 에러는 안 뜨고 insert 화면으로 감
//		}
//	}
//	
//	
//	// http://localhost:8080/book/list + GET => list.jsp 보여주기
//	@GetMapping("/list")
//	public String listForm(Model model) {
//		log.info("도서 정보 목록 요청");
//		
//		// 사용자가 작성한 값 가져오기 - 없으면 pass
//		// service 작업
//		List<BookDTO> list = service.getList();
//		
//		// list 에 담긴 정보를 list.jsp 에 보여주고 싶다면?
//		model.addAttribute("list", list); // == request.setAttribute() 와 같은 개념 -> forward 방식으로 움직인다
//		
//		return "/product/list";
//	}
//	
//	// http://localhost:8080/book/read?code=1001 + GET
//	@GetMapping("/read")
//	public String readGet(int code, Model model) {
//		log.info("read 요청 "+code);
//		
//		BookDTO dto = service.get(code);
//		model.addAttribute("dto", dto);
//		
//		return "/product/read";
//	}
	
	//  http://localhost:8080/book/insert + GET
	// /book/insert.jsp 보여주기
	@GetMapping("/insert")
	public void insertForm() { 
		log.info("도서 정보 추가 폼 요청");		
	}
	
	// http://localhost:8080/book/insert + POST
	@PostMapping("/insert")
	public String insertPost(BookDTO dto) { // 보여줄 페이지가 다르니 이 경우엔 String 으로 가야함
		log.info("도서 정보 추가");
		
		// 입력값 가져오기 - HttpServletRequest, 변수, ~~DTO
		// 서비스 작업 
		try {
			boolean insertFlag = service.insert(dto);
			if(insertFlag) {
				// 입력 성공 시 목록 보여주기
				return "redirect:/book/list"; // jsp 로 가는게 아니라 경로찾아줘야함
			}else {
				// 입력 실패 시 insert.jsp 보여주기
				return "/book/insert"; // list.jsp 로 감
			}
		} catch (Exception e) {
			System.out.println("오류");
			return "/book/insert"; // 500 에러는 안 뜨고 insert 화면으로 감
		}
	}
	
	
	// http://localhost:8080/book/list + GET => book/list.jsp 보여주기
	@GetMapping("/list")
	public void listForm(Model model) {
		log.info("도서 정보 목록 요청");
		
		// 사용자가 작성한 값 가져오기 - 없으면 pass
		// service 작업
		List<BookDTO> list = service.getList();
		// list 에 담긴 정보를 list.jsp 에 보여주고 싶다면?
		model.addAttribute("list", list); // == request.setAttribute() 와 같은 개념 -> forward 방식으로 움직인다
		
	}
	
	// http://localhost:8080/book/read?code=1001 + GET => book/read.jsp
	@GetMapping("/read")
	public void readGet(int code, Model model) {
		log.info("read 요청 "+code);
		
		BookDTO dto = service.get(code);
		model.addAttribute("dto", dto);		
	}
	
}
