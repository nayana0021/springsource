package com.spring.memo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository repository;

	@Test
	public void createMember(){
		
//		Member member = new Member();
//		member.setName("우디");
//		member.setEmail("woody11@gmail.com");
//		member.setPassword("woody11");
//		member.setAddress("서울시 종로구 관철동");
//		
//		repository.save(member);
		
		Member member = Member.builder()
								.name("버즈")
								.email("buzz11@gmail.com")
								.address("서울시 종로구")
								.password("buzz1234")
								.build();
				
		repository.save(member);
	}
}
