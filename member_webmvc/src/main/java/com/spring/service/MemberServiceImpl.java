package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.domain.AuthDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	
	@Override
	public AuthDTO login(LoginDTO loginDTO) {
		// 1234 ==> bPasswordEncoder.encode(1234) ==> 암호화
//		loginDTO.setPassword(bPasswordEncoder.encode(loginDTO.getPassword())); 이렇게는 불가!! 비교할 때는 무조건 matches 를 쓴다
		// matches(암호화하기 전 코드, 암호화된 코드)
		// matches(1234, DB암호화된 문자) -> 내부적으로 앞의 비번을 암호화해서 비교해줌 맞으면 true, 틀리면 false
		
		// 비밀번호가 일치하는가 ?
		// db 에서 암호화된 비번 가져오기
		String encodePass = mapper.getPass(loginDTO.getUserid()); // 인터페이스 멤버맵퍼에서 넘겨줌
		
		if(bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
			return mapper.login(loginDTO.getUserid());
		}else {
			return null;
		}
	}
	

	@Override
	public boolean register(MemberDTO memberDTO) {
		// 비밀번호 암호화 : encode(암호화할 원본 코드)
		//				 matches(암호화하기 전, 암호화 코드)
		//				 1234, 암호화된 코드
		memberDTO.setPassword(bPasswordEncoder.encode(memberDTO.getPassword()));
		return mapper.insert(memberDTO) == 1 ? true : false;
	}

}
