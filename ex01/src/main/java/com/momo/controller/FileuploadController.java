package com.momo.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.momo.service.FileuploadService;
import com.momo.vo.FileuploadVO;

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
	public String fileuploadAction(List<MultipartFile> files
									, int bno
									, RedirectAttributes rttr) {
		
		int insertRes = 0;
		for(MultipartFile file : files) {
			// 선택된 파일이 없는경우 다음파일로 이동
			if(file.isEmpty()) {
				continue;
			}
			
			log.info("oFileName : " + file.getOriginalFilename());
			log.info("name : " + file.getName());
			log.info("size : " + file.getSize());
			
			try {
				/**
				 * 소프트웨어 구축에 쓰이는 식별자 표준
				 * 파일이름이 중복되어 파일이 소실되지 않도록 uuid를 붙여서 저장
				 */
				UUID uuid = UUID.randomUUID();
				String saveFileName = 
						uuid + "_"+ file.getOriginalFilename();
				
				// dir(c:/upload/2023/07/18)년/월/일
				String uploadpath = getFolder();

				File sFile = 
						new File(ATTACHES_DIR 
								+ uploadpath //경로 반환(2023\07\18\)
								+ saveFileName);
				
				// file(원본파일)을 sFile(저장 대상 파일)에 저장
				file.transferTo(sFile);
				
				FileuploadVO vo = new FileuploadVO();
				vo.setBno(bno);
				vo.setFilename(file.getOriginalFilename());
				vo.setFiletype("I");
				vo.setUploadpath(uploadpath);
				vo.setUuid(uuid.toString());
				
				int res = service.insert(vo);
				
				if(res>0) {
					insertRes++;
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		String msg = insertRes + "건 저장 되었습니다.";
		rttr.addAttribute("msg", msg);
		
		return "redirect:/file/fileupload";
	}
	
	@Autowired
	FileuploadService service;
	
	@GetMapping("/file/list/{bno}")
	public @ResponseBody Map<String, Object> fileuploadList
							(@PathVariable("bno") int bno) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.getList(bno));
		
		return map;
	}
	
	// 중복 방지용 
	//		업로드 날자를 폴더 이름 으로 사용
	// 		2023\07\18\
	public String getFolder() {
		LocalDate currentDate = LocalDate.now();
		String uploadPath 
				= currentDate.toString().replace("-", File.separator)
					+ File.separator;
		log.info("CurrentDate : " + currentDate);
		log.info("경로 : " + uploadPath);
		
		// 폴더 생성(없으면)
		File saveDir = new File(ATTACHES_DIR + uploadPath);
		if(!saveDir.exists()) {
			if(saveDir.mkdirs()) {
				log.info("폴더 생성!!");
			} else {
				log.info("폴더 생성 실패!!");
			}
		}
		
		
		return uploadPath;
		
	}

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		String uploadPath 
				= currentDate.toString().replace("-", File.separator)
					+ File.separator;
		System.out.println("CurrentDate : " + currentDate);
		System.out.println("경로 : " + uploadPath);
	}
}













