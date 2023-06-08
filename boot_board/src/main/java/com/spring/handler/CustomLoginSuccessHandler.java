package com.spring.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	// 로그인 성공 후 시작 페이지로 돌아감(디폴트)
	// 로그인 성공 후 특정 작업 추가하고 싶거나 이동해야 하는 경로 지정
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException { //Authentication authentication 인증과 관련된 객체
		// 로그인 사용자의 권한 확인
		// ROLE_ADMIN 이라면 adminpage 이동, ROLE_USER 이라면 userpage 이동

		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(auth -> roleNames.add(auth.getAuthority())); // auth 라는 이름으로 지정 후 권한 목록을 가져옴 
		// 권한 목록 안에 ROLE_ADMIN, ROLE_USER 등이 있음
		
		if(roleNames.contains("ROLE_ADMIN")) {	// 포함되어있다면 경로 지정하여 이동
			response.sendRedirect("/member/admin");
			return;
		}
		if(roleNames.contains("ROLE_MEMBER") || roleNames.contains("ROLE_MANAGER") ) {	// 포함되어있다면 경로 지정하여 이동
			response.sendRedirect("/board/list");
			return;
		}
		
		response.sendRedirect("/");	// 두 조건에 안 걸리는 경우 인덱스페이지로 이동
		
	}

}
