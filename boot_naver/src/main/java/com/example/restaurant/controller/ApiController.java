package com.example.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.naver.service.WishListService;
import com.example.restaurant.wishlist.dto.WishListDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
public class ApiController {
	
	@Autowired
	private WishListService wishListService;
	
	@GetMapping("/search")
	public WishListDTO search(String query) {
		log.info("검색 요청 "+query);
		return wishListService.search(query);	// 자식 서비스인 WishListServiceImpl 에 @service 어노테이션이 붙어있어서 잘 돌아가는 것임 부모=자식 으로 생성한것과 같다
	}
	
	@PostMapping("")	//		/api/restaurant + post
	public WishListDTO add(@RequestBody WishListDTO wishListDTO) { // json으로 넘어오는 데이터는 @RequestBody 을 써야 제대로 넘어온다!
		log.info("wish 추가 "+wishListDTO);	// 웹브라우저에서는 idx 가 아직 없는 상황
		return wishListService.add(wishListDTO);	// 데이터베이스에서 오는 데이터이기 때문에 idx가 존재
	}
	
	
}
