package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

public class MemberMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		MemberService service = (MemberService) ctx.getBean("member");
		
		// 삽입
//		MemberDTO dto = new MemberDTO();
//		dto.setUserid("jaypark11");
//		dto.setPassword("jaebum11");
//		dto.setName("박재범");
//		dto.setGender("남");
//		dto.setEmail("jaypark11@aomg.co.kr");
//		boolean result = service.insertMember(dto);
//		System.out.println(result? "입력성공": "입력실패");
		MemberDTO dto = new MemberDTO("iu12","iu112","아이유","여","iu12@gmail.com");
		boolean result = service.insertMember(dto);
		System.out.println(result? "입력성공": "입력실패");
		
		
		// 전체조회
		List<MemberDTO> list = service.getRows();
		for (MemberDTO memberDTO : list) {
			System.out.println(memberDTO);
		}
		
		// 멤버 정보 수정
//		MemberDTO updateDto = new MemberDTO();
//		updateDto.setUserid("hong123");
//		updateDto.setPassword("hong22");
//		updateDto.setEmail("hongdangmoo11@gmail.com");
//		System.out.println(service.updateMember(updateDto)?"수정성공":"수정실패");
		
		// 삭제
//		System.out.println(service.deleteMember("today4#", "1todayis12#$")? "삭제성공" : "삭제실패");
		
		// 특정 멤버 조회
//		System.out.println(service.getRow("today4#","1todayis12#$"));
		
	}

}
