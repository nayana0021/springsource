package com.spring.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// web.xml 대신	상속 받고 들어왔기 때문에 왠만한건 해결이 됨(디스패처서블릿 설정)	
	
	@Override	// 루트 구성 담당
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override	// 서블릿 구성 담당
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override	// 맵핑 설정
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override	// 한글 필터 설정
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		return new Filter[] {filter};
	}
	
}
