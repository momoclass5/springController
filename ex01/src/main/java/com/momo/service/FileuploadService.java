package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.momo.vo.FileuploadVO;

@Service
public interface FileuploadService {

	List<FileuploadVO> getList(int bno);
	
	int insert(FileuploadVO vo);
}
