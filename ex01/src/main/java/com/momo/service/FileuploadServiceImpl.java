package com.momo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.mapper.FileuploadMapper;
import com.momo.vo.FileuploadVO;

@Service
public class FileuploadServiceImpl implements FileuploadService {

	@Autowired
	FileuploadMapper mapper;
	
	@Override
	public List<FileuploadVO> getList(int bno) {
		return mapper.getList(bno);
	}

	@Override
	public int insert(FileuploadVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public int delete(int bno, String uuid) {
		// 파일 삭제
		
		// 데이터 베이스에서 삭제
		return mapper.delete(bno, uuid);
	}

}
