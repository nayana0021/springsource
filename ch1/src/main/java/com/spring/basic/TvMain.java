package com.spring.basic;

public class TvMain {

	public static void main(String[] args) {
		
//		LgTV lgTV = new LgTV();
//		lgTV.turnOn();
//		lgTV.soundUp();
//		lgTV.soundDown();
//		lgTV.turnOff();

		TV samsungTV = new SamsungTV(); //LgTV()로 변경 가능 (다형성 개념) 앞에 변수명은 상관없으니까~
		samsungTV.powerOn();
		samsungTV.volumeUp();
		samsungTV.volumeDown();
		samsungTV.powerOff();
		
	}

}
