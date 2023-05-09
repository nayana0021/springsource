package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Spring framework
// 인스턴스를 생성하고 관리 => 모든 인스턴스를 생성하고 관리하는 것은 아니고 지정한 인스턴스만 처리
//						  인스턴스 생성 시 singleton 방식

public class HelloApp {
	public static void main(String[] args) {
		
		System.out.println("=== 컨테이너 구동 전 ===");
		
		// src/main/resources ==> ClassPath
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml"); //ClassPath에서 xml방식으로 config.xml을 읽어와
		
		System.out.println("=== 컨테이너 구동 후 ===");
		MessageBean msg = (MessageBean)ctx.getBean("msg"); //id로 찾아옴. 왼쪽 부모
		msg.sayHello("홍길동");

				
	}
}
