package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class AttachFileDTO {	
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
}
