package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookDTO;
import com.spring.domain.SearchDTO;
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
	// http://localhost:8080/book/modify?code=5555 => book/modify.jsp
	@GetMapping({"/read", "/modify"})
	public void readGet(int code, Model model) {
		log.info("read 요청 "+code);
		
		BookDTO dto = service.get(code);
		model.addAttribute("dto", dto);	
		// view Resolver 동작 					http://localhost:8080/book/read ==> /WEB-INF/views/book/read.jsp
		//동일한 작업은 굳이 경로를 여러개 할 필요가 없다	http://localhost:8080/book/modify ==> /WEB-INF/views/book/modify.jsp
	}
	
//	@GetMapping("/modify")
//	public void modifyGet(int code, Model model) {
//		log.info("read 요청 "+code);
//		
//		BookDTO dto = service.get(code);
//		model.addAttribute("dto", dto);		
//	}

	//http://localhost:8080/book/modify + POST
	@PostMapping("/modify")
	public String updatePost(BookDTO dto, RedirectAttributes rttr) { // 주소줄에 따라가기만 하면 됨 - code
		log.info("도서 정보 수정 "+dto); // 넘어오는거 확인하려고 찍어봥
		
		service.update(dto);
		
		rttr.addAttribute("code", dto.getCode());
		
		// /book/read 로 이동 - 경로를 다시 들어가는 개념 - 리턴을 해야하는 상황
		return "redirect:/book/read"; // 위에서 read 로 보내려면 int code 를 받아야 하는데 여기서는 code값이 없다 -> 500 에러 
		//							=> 페이지 이동 시 무언가를 딸려 보내고 싶다면 RedirectAttributes 를 사용한다 
		//								주소줄에 code가 따라가기만 하면 되기 때문에 addAttribute 로 사용 

	}
	
	@GetMapping("/remove")
	public String removeGet(int code) {
		log.info("도서 정보 삭제 "+code);
		
		// 삭제 후 목록 보여주기
		service.delete(code);
		return "redirect:/book/list";
	}
	
	// 사용자 입력 값 가져오기 = > 변수 사용 (개별로 받을때)
//	@GetMapping("/search")
//	public String searchGet(String criteria, String keyword, Model model) {
//		log.info("도서 정보 검색 "+criteria+", "+keyword);
//		
//		List<BookDTO> list = service.getSearchList(criteria, keyword);
//		
//		model.addAttribute("list", list);
//		
//		return "/book/list";
//	}
	
	@GetMapping("/search")
	public String searchGet(SearchDTO search, Model model) {
		log.info("도서 정보 검색 " + search);
		
		List<BookDTO> list = service.getSearchList(search.getCriteria(), search.getKeyword());
		
		model.addAttribute("list", list);
		model.addAttribute("searchDTO", search);
		
		return "/book/list";
	}

	
	
}
