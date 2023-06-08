package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration	//환경설정 파일이야 알려주는 역할
public class SecurityConfig {

	
	@Bean	// 비밀번호 암호화
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * spring-boot-starter-security : 시큐리티 라이브러리 모음(묶여서 들어옴)
	 * 프로젝트에 시큐리티가 적용이 되어버림 => 비밀번호 암호화만 필요함
	 * form login 동작이 되어버림 , 사실 암호화만 쓸거라서 약간의 설정이 필요한 상황
	 * 
	 */
	
	@Bean	// 시큐리티 기능 안 쓴다는 코드(csrf 안 쓸거야..) - 비밀번호 암호화만쓰면 되는 상황이라
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().anyRequest().permitAll().and().httpBasic().and().csrf().disable();
		
		return http.getOrBuild();
	}

}
