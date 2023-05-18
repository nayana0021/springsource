package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;
import com.spring.domain.PageDTO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 전체 리스트 보여주기 컨르롤러 작성 : list.jsp 보여주기
	@GetMapping("/list")
	public void listGet(Model model, Criteria cri) {
		log.info("전체 리스트 요청");
		
		// 사용자가 요청한 번호에 맞는 게시물 목록 요청 service.getList()
		List<BoardDTO> list = service.getList(cri);
		// 전체 게시물 숫자
		int total = service.getTotalCnt();
		
		model.addAttribute("list", list);
		model.addAttribute("pageDTO", new PageDTO(cri, total)); // 페이지 나누기 관련 정보
	}
	
	// register.jsp 보여주기
	@GetMapping("/register")
	public void registerGet() {
		log.info("글쓰기 폼 요청");
	}
	
	@PostMapping("/register")
	public String registerPost(BoardDTO dto, RedirectAttributes rttr) {
		log.info("글쓰기 등록 요청 "+dto);
		
		if(service.insert(dto)) {
			
			log.info("글 번호 "+dto.getBno());
			
			rttr.addFlashAttribute("result", dto.getBno());
			return "redirect:/board/list";
		}
		return "/board/register";
	}

	// read.jsp , modify.jsp 화면
	// http://localhost:8080/board/read?bno=1
	// http://localhost:8080/board/modify?bno=1
	@GetMapping({"/read", "/modify"})
	public void readGet(int bno, Model model) {
		log.info("내용 조회 "+bno);
		
		// bno 에 맞는 내용 가져오기 모델에 담아서 화면에 보여주기
		BoardDTO dto = service.getRow(bno);
		model.addAttribute("dto", dto);
	}
	
	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto, RedirectAttributes rttr) {
		//성공 시 리스트
		service.update(dto);
		
		rttr.addFlashAttribute("result", "수정이 완료되었습니다");
		return "redirect:/board/list";
	}
	
	// board/remove?bno=21
	@GetMapping("/remove")
	public String removeGet(int bno, RedirectAttributes rttr) {
		// 성공 시 리스트
		service.delete(bno);
		
		rttr.addFlashAttribute("result", "삭제가 완료되었습니다");
		return "redirect:/board/list";
	}
	
}
