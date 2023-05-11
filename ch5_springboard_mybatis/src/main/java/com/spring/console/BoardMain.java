package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardDTO;
import com.spring.service.BoardService;

public class BoardMain {

	public static void main(String[] args) {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		BoardService service = (BoardService) ctx.getBean("board");
		// 게시글 작성
//		BoardDTO dto = new BoardDTO();
//		dto.setTitle("스프링");
//		dto.setContent("스프링 게시판");
//		dto.setWriter("홍당무");
//		boolean result = service.insertBoard(dto);
//		System.out.println(result ? "입력성공" : "입력실패");

		// 수정
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(1);
//		dto.setTitle("스프링 개념 좀;;");
//		dto.setContent("스프링 제어의 역전의 명수");
//		boolean result = service.updateBoard(dto);
//		System.out.println(result ? "수정성공" : "수정실패");
		
		// 삭제
//		System.out.println(service.deleteBoard(2)?"삭제성공":"삭제실패");
		
		// 특정 게시물 조회
//		System.out.println(service.getRow(1));
		
		
		// 전체리스트 조회
		List<BoardDTO> list = service.getRows();
		for (BoardDTO boardDTO : list) {
			System.out.println(boardDTO);
		}
		
	}

}
