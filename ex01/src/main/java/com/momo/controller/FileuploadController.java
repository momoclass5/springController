package com.momo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class FileuploadController {

	@GetMapping("/file/fileupload")
	public void fileupload() {
		
	}
	
	private static final String ATTACHES_DIR = "c:\\upload\\";
	
	/**
	 * - 전달된 파일이 없는경우
	 * - enctype="multipart/form-data" 오타
	 * - 설정이 안되었을때
	 * 		라이브러리 추가(commons-fileupload)
	 * 		multipartResolver bean생성
	 *  
	 * @param files
	 * @return
	 */
	@PostMapping("/file/fileuploadAction")
	public String fileuploadAction(List<MultipartFile> files) {
		
		files.forEach(file ->{
			
			if(!file.isEmpty()) {
				log.info("oFileName : " + file.getOriginalFilename());
				log.info("name : " + file.getName());
				log.info("size : " + file.getSize());
				
				// file(원본파일)을 sFile(저장 대상 파일)에 저장
				try {
					/**
					 * 소프트웨어 구축에 쓰이는 식별자 표준
					 * 파일이름이 중복되어 파일이 소실되지 않도록 uuid를 붙여서 저장
					 */
					UUID uuid = UUID.randomUUID();
					String saveFileName = 
							uuid + "_"+ file.getOriginalFilename();
					
					// dir
					// c:/upload/2023/07/18
					// 년/월/일
					File sFile = 
							new File(ATTACHES_DIR + saveFileName);
					
					
					file.transferTo(sFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		return "redirect:/file/fileupload";
	}
	
	
}













