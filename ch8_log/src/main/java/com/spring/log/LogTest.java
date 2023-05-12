package com.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {

//	private static final Logger logger = LoggerFactory.getLogger(LogTest.class);
	
	
	public static void main(String[] args) {
//		logger.error("error 레벨");
//		logger.warn("warn 레벨");
//		logger.info("info 레벨");
//		logger.debug("debug 레벨");
//		logger.trace("trace 레벨");
		
		log.error("error 레벨");
		log.warn("warn 레벨");
		log.info("info 레벨");
		log.debug("debug 레벨");
		log.trace("trace 레벨"); // 롬복을 사용하면(@Slf4j) 위에 로거 안 불러와도 바로 쓸수있다
	}

}
