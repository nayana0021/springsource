package com.spring.memo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Memo;

@SpringBootTest	// 테스트 클래스임을 알려줌
public class MemoRepositoryTest {
	
	@Autowired
	private MemoRepository memoRepository;
	
//	@Test
//	public void createMemoTest() {
////		
////		Memo memo = new Memo();
////		memo.setMemoText("메모 첫번째");
////		
////		// save() : insert, update
////		memoRepository.save(memo);
//		
//		for(int i=0; i < 100; i++) {
////			Memo memo = new Memo();
////			memo.setMemoText("Memo...."+i);
////			memoRepository.save(memo);
//			
//			//어노테이션 @Builder 를 썼을 때 (0608 오후 4시 50분 설명)
//			Memo memo = Memo.builder()
//							.memoText("Memo..."+i)
//							.build();	
//			memoRepository.save(memo);
//		}	
//	}
	
//	@Test
//	public void findByMemo() {
//		// 조회 : findById()
//		Optional<Memo> result = memoRepository.findById(90L);
//		
//		if(result.isPresent()) {
//			System.out.println(result.get());
//		}
//	}
	
//	@Test
//	public void findByMemoList() {
//		// 전체 조회
//		List<Memo> result = memoRepository.findAll();
//		
//		result.forEach(memo -> System.out.println(memo));
//	}

//	@Test
//	public void updateMemo() {
//		// save() : insert, update - 조회를 해서(select) 있으면 update 없으면 insert 하는 개념
//		
//		Memo memo = Memo.builder()
//						.mno(80L)
//						.memoText("메모 수정")
//						.build();
//		
//		Memo update = memoRepository.save(memo);
//		System.out.println(update);
//	}

	@Test
	public void deleteMemo() {
		memoRepository.deleteById(90L);	// select 를 했는데 없으면 delete 를 하지 않음
	}

	
	
}
