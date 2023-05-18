package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardDTO;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> getList() {
		return mapper.list();
	}

	@Override
	public boolean insert(BoardDTO dto) {
		return mapper.insert(dto)==1?true:false;
	}

}
