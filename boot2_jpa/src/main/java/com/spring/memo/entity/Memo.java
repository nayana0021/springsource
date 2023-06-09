package com.spring.memo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity	// 클래스를 엔티티로 선언 한다는 의미의 어노테이션 - 테이블을 만들어줌
//@Table(name="memos") 클래스명으로 테이블 생성할 때 옵션 지정
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // 
@SequenceGenerator(name="mem_seq_gen", sequenceName = "mem_seq", allocationSize = 1)
public class Memo {

	// name : 임의로 이름 설정(필수), sequenceName : mem_seq.nextval, allocationSize = 증가할 숫자(지정안하면 50씩 증가)
	//@SequenceGenerator(name="mem_seq_gen", sequenceName = "mem_seq", allocationSize = 1)
	
	// GenerationType : 1) AUTO : JPA 구현체가 자동으로 구현, 2) IDENTITY : 기본키 생성을 데이터베이스에 위임
	//					3) SEQUENCE : SequenceGenerator 등록 후 사용
	//					4) TABLE : 키 생성용 테이블 사용 @TableGenerator 사용
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_seq_gen")
	@Id	// pk로 생성
	private Long mno; // long 으로 선언해서 19자리
	
	@Column(length = 200, nullable = false)	//200자, not null
	private String memoText;	// 기본 255자
	
	//자바는 카멜케이스로 문자를 쓰지만 데이터베이스에 자동으로 스네이크케이스로 됨
	
}
