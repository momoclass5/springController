package com.momo.mapper;

import java.util.List;

import com.momo.vo.FileuploadVO;

public interface FileuploadMapper {

	/**
	 * 하나의 게시물에 대해 업로드된 파일 목록을 조회
	 * @param bno
	 * @return
	 */
	public List<FileuploadVO> getList(int bno);
	
	public int insert(FileuploadVO vo);
}
