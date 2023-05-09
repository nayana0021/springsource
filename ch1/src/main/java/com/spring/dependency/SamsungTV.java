package com.spring.dependency;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker; // has-a(포함)관계
	// 멤버변수로 선언하면서 객체 생성? - 안되는건 아님 private SonySpeaker speaker = new SonySpeaker speaker;
//	private int money; 기본타입은 null익셉션 안 남
	
	// 매개변수를 받지 않는 생성자 : default생성자
	public SamsungTV() {}
	
	// 생성자 초기화
	public SamsungTV(SonySpeaker speaker) {
		super();
		this.speaker = speaker; // 멤버 변수 초기화
	}
	
	// setter 초기화
	public void setSpeaker(SonySpeaker speaker) {
		this.speaker = speaker;
	}


	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 파워 On");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 파워 Off");
	}
	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV - 볼륨 Up");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
//		System.out.println("SamsungTV - 볼륨 Down");
		speaker.volumeDown();
	}
	
}
