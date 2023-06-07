package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)	// 테스트코드가 스프링프레임워크 안에서 실행 됨을 알려주는 의미
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", //db 정보 내용들어있음 경로알랴줌
						"file:src/main/webapp/WEB-INF/spring/security-context.xml"})	// 인증정보는 들어있음 경로알랴줌
public class MemberAuthTest {
		
	@Autowired
	private DataSource ds;
	
	@Test	// 테스트 메소드(파라메터 없음, 리턴타입 없음)임을 알려주는 어노테이션
	public void test() {	// 회원 50명을 임의로 만드는 코드
		
		String sql = "insert into spring_member_auth(userid,auth) values(?,?)";
		
		for(int i = 0; i < 50; i++) {
			
			try(Connection con = ds.getConnection(); 
					PreparedStatement pstmt = con.prepareStatement(sql)){
				
				// 50 명 회원 => 일반회원 20, 매니저 20, 관리자 10
				
				if(i < 20) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(2, "ROLE_MEMBER");
				}else if(i < 40) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(2, "ROLE_MANAGER");
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
