package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 횡단관심사를 처리해 줄 클래스
// 횡단관심사를 언제 처리할 것인가?
// Before(메소드 호출 전에), After returning(메소드 호출 이후에), After throwing(메소드 예외 발생 후)
// After(메소드 호출 후 예외 발생 여부와 관계없이), Around(메소드 호출 이전과 이후 모두 적용)

@Component("log") // repository, service.. 아니어서 걍 component로 붙임
@Aspect
public class LogAdvice {
	
	// execution() : 표현식 : 특정 메소드만 advice 를 함 - aop를 다 적용할 것이 아니기 때문에 표현식으로..
	// * : 리턴타입
	// com.spring.aop : 패키지명
	// Product : 클래스명
	// getInfo() : 메소드명
	
//	@Before(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출");
//	}
	
//	@After(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void afterLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 후 호출됨(예외 발생 여부와 관계없이 무조건 실행");
//	}
	
//	@AfterThrowing(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void afterThrowingLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 후 예외 발생 시 호출됨"); // 예외가 날 때만 
//	}

//	@AfterReturning(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void afterReturnLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 후 예외발생 없을 때만 호출됨"); // 정상 종료시
//	}
	
	@Around(value = "execution(* com.spring.aop.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출 됨"); 
		try {
			pjp.proceed(); // 처리해여 하는 메소드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("[공통로그] 비즈니스 로직 수행 후 호출 됨"); 
	}



}
