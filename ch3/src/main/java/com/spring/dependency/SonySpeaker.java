package com.spring.dependency;

import org.springframework.stereotype.Component;

@Component // sonySpeaker 로 객체 생성됨
public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("SonySpeker 인스턴스 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker Volume Up");

	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker Volume Down");

	}

}
