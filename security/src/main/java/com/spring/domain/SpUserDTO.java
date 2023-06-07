package com.spring.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class SpUserDTO {	// left outer join 해서 나올거라
	private String userid;
	private String password;
	private String email;
	private boolean enabled;
	
	private List<SpUserAuthorityDTO> authorites;
}
