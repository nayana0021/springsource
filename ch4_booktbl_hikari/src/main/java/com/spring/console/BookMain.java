package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookDTO;
import com.spring.persistence.BookDAO;
import com.spring.service.BookService;
import com.spring.service.BookServiceImpl;

public class BookMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		// Service 호출
		BookService service = (BookService) ctx.getBean("bookService");
		
		// 도서 추가
//		BookDTO insertDto = new BookDTO(1006, "스프링부트가먼가요?", "윈터", 25000, "스프링부트ㄱㄱ");
//		if(service.insertBook(insertDto)) {
//			System.out.println("입력성공");
//		}
		
		// 도서 수정
//		BookDTO updateDto = new BookDTO();
//		updateDto.setCode(5555);
//		updateDto.setPrice(99999);
//		if(service.updateBook(updateDto)) {
//			System.out.println("수정성공");
//		}
//		
//		// 특정 도서 조회
//		BookDTO row = service.getBook(5555);
//		System.out.println(row);
//			
//		// 도서 삭제
//		if(service.deleteBook(9999)) {
//			System.out.println("삭제성공");
//		}
		
		// 전체 도서 목록 가져오기
		//BookService service = new BookServiceImpl(new BookDAO());
		List<BookDTO> list = service.getBookList();
		
		for (BookDTO bookDTO : list) {
			System.out.println(bookDTO);
		}

	}

}
