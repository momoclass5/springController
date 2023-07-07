package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.momo.vo.BookVO;

@Service
public interface BookService {
	// 추상메서드 -> 미완성
	public List<BookVO> getList();
}
