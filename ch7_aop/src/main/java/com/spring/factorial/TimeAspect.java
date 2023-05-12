package com.spring.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 횡단관심사를 처리해 줄 클래스
@Component
@Aspect
public class TimeAspect {
	
	@Around(value = "execution(* com.spring.factorial..*(..))") // fatorial 폴더 밑에 어떤것이 오더라도의 표현 (인자를 몇개 받아도 상관없어)
	public Object measure(ProceedingJoinPoint pjp) {
		long start = System.nanoTime();
		Object obj = null;
		try {
			obj = pjp.proceed(); // 주된관심사 처리하는 부분
		} catch (Throwable e) {
			e.printStackTrace();
		}finally {
			long end = System.nanoTime();
			System.out.println("걸린 시간 : "+(end-start));
		}
		return obj;
	}
}
