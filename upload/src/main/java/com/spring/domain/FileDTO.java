package com.spring.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class FileDTO {
	private String name;
	// file 요소 처리 타입은 반드시 multipartfile로 한다 (multiple 여러 개로 올리려면 배열로 선언한다)
	private MultipartFile[] file;
}
