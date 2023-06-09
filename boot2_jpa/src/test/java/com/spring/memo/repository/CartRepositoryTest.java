package com.spring.memo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Cart;
import com.spring.memo.entity.Member;

@SpringBootTest
public class CartRepositoryTest {

	@Autowired
	private CartRepository repository;
	
	@Autowired
	private MemberRepository memberRepository;
	
//	@Test
//	public void createCart() {
//		
//		Optional<Member> member = memberRepository.findById(1L); 	// Optional<Member> 은 안 들어올수도 있다는 뜻을 내포하기 때문에 .builder().member(member) 가 안됨
//		
//		member.ifPresent(mem -> {
//			Cart cart = Cart.builder().member(mem).build();
//			repository.save(cart);
//		});
//			// ORM 에서는 해당 멤버를 찾아서 바로 넣어줘야 함
//	}
	
	// 카트 조회
	@Test
	public void getCart() {
		Optional<Cart> cart = repository.findById(3L);
		
		cart.ifPresent(c -> System.out.println(c));
	}
	
	
}
