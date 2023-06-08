package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class ChangeDTO {
	//changePwd.jsp 와 일치
	private String userid;
	
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	// jsp 의 name 과 일치시켜야 함 자바에서는 - (대쉬)가 안됨
	
	public boolean passwordEquals() {
		return newPassword.equals(confirmPassword);
	}
}
