package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.spring.handler.CustomLoginSuccessHandler;
import com.spring.service.CustomUserDetailService;

//	5.7.X security 환경 설정 작성 방법은 변경됨 - 이전 버전 방법으로 작성(지금은 5.6.10버전임)

@Configuration 	// 환경 설정 파일임을 알려줌
@EnableWebSecurity	// 그 중 웹 시큐리티 담당임
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public DataSource dataSource;
	
	@Bean	// 스프링이 관리해주세여
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {	// 부모임
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public UserDetailsService customUserService() { //@Service("detail") 과 같은 역할
		return new CustomUserDetailService();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	// <security:authentication-manager> 해당
		auth.userDetailsService(customUserService())
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	// <security:http> 해당
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter,CsrfFilter.class);
		
		http.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/login") //loginPost 일때 어디로 갈거냐 지정
			.failureUrl("/member/login-error")
			.successHandler(loginSuccessHandler());
		
		http.logout()
			.logoutSuccessUrl("/");
		
		http.rememberMe()
			.tokenRepository(perTokenRepository())
			.tokenValiditySeconds(604800);
	}
	
	@Bean
	public PersistentTokenRepository perTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
}
