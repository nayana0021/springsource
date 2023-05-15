package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookDTO;
import com.spring.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService { //  serviceImpl 은 DB 메소드 호출
	
	// DAO 메소드( == Mapper Interface 호출 )
	@Autowired
	private BookMapper mapper;
	
	@Override
	public boolean insert(BookDTO dto) {
		return mapper.insert(dto) == 1 ? true : false;
	}

	@Override
	public boolean delete(int code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BookDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookDTO get(int code) {
		return mapper.read(code);
	}

	@Override
	public List<BookDTO> getList() {
		return mapper.getRows();
	}

	@Override
	public List<BookDTO> getSearchList(String criteria, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
