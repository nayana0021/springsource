package com.spring.memo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Item;
import com.spring.memo.entity.ItemSellStatus;

@SpringBootTest 	// 이건 테스트 클래스야
public class ItemRepositoryTest {
	
	// ItemRepository 가 잘 작성되었는지 테스트 : 단위 테스트 -> 테스트 조금씩 개발을 하고 중간중간에 잘 돌아가는지 테스트하는 것임
	
	@Autowired
	private ItemRepository repository;
	
//	@Test
//	public void itemCreateTest() {
//		Item item = new Item();
//		item.setItemNm("에어팟맥스");
//		item.setPrice(750000);
//		item.setStockNumber(30);
//		item.setItemDetail("헤드셋");
//		item.setItemSellStatus(ItemSellStatus.SELL);
//		item.setRegTime(LocalDateTime.now());
//		item.setUpdateTime(LocalDateTime.now());
//		repository.save(item);
		
//		Item item = Item.builder()
//						.itemNm("프롬비")
//						.price(35000)
//						.stockNumber(70)
//						.itemDetail("휴대용 선풍기")
//						.itemSellStatus(ItemSellStatus.SELL)
//						.regTime(LocalDateTime.now())
//						.updateTime(LocalDateTime.now())
//						.build();
//		
//		Item newItem = repository.save(item);	// save 가 item 을 반환해줌
//		System.out.println(newItem);
//	}
		
		// 조회
//	@Test
//	public void getItem() {
////		Optional<Item> item = repository.findById(1L);
////		item.ifPresent(ele -> System.out.println(ele));
//		
//		repository.findById(1L).ifPresent(ele -> System.out.println(ele));
//		
//		Item item = repository.findById(2L).orElseThrow(EntityNotFoundException::new); //	찾았으면 item 에 넣어주고 못 찾으면 예외
//		System.out.println(item);
//	}
	
//	// 전체조회
//	@Test
//	public void getItems() {
//		
//		List<Item> list = repository.findAll();
//		
////		for (Item item : list) {
////			System.out.println(item);
////		}
//		
//		
//		
//		list.forEach(item -> System.out.println(item));
//	}
	
//	// 상품명 조회
//	@Test
//	public void getItems() {
//		
////		List<Item> list = repository.findByItemNm("반팔티");
////		list.forEach(item -> System.out.println(item));
//		
//		repository.findByItemNm("반팔티")
//					.forEach(item -> System.out.println(item));
//	}

//	// 상품명 or 상품상세조회
//	@Test
//	public void getNameOrDetail() {
//		List<Item> list = repository.findByItemNmOrItemDetail("블루투스 스피커", "카라티"); //1,2번 둘 다 나옴
//		
//		list.forEach(item -> System.out.println(item));
//	}
	
	
//	@Test
//	public void getPriceLessThan() {
//		repository.findByPriceLessThan(500000).forEach(item -> System.out.println(item));
//		
//	}

	@Test
	public void getPriceLessThanOrder() {
		repository.findByPriceLessThanOrderByPriceDesc(760000)
					.forEach(item -> System.out.println(item));
	}


		
}
