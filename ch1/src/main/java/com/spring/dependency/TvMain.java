package com.spring.dependency;

public class TvMain {
	//String str = "String"; //new와 같은 역할

	public static void main(String[] args) {

		// 생성자를 사용한 멤버 변수 초기화
//		SonySpeaker speaker = new SonySpeaker();
//		TV tv = new SamsungTV(speaker);

//		TV tv = new SamsungTV(new SonySpeaker());

		// setter 를 사용한 멤버 변수 초기화 ( 초기화 안 하면 NullPointerException ) -> 의존성 주입
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(new SonySpeaker());
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
//		TvMain obj = new TvMain();
//		obj.test();
	}
	
//	public void test() {
//		System.out.println(str);
//		System.out.println(str.length());
//	}

}
