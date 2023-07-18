package com.momo.fileupload;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.FileuploadMapper;
import com.momo.vo.FileuploadVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FileuploadTest {
	@Autowired
	FileuploadMapper mapper;
	
	@Test
	public void test() {
		log.info("insert()");
		
		FileuploadVO vo = new FileuploadVO();
		
		vo.setBno(83);
		vo.setFilename("filename");
		vo.setFiletype("I");
		vo.setUploadpath("uploadpath");
		UUID uuid = UUID.randomUUID();
		vo.setUuid(uuid.toString());
		
		int res = mapper.insert(vo);
		
		assertEquals(1, res);
		
	}
	
	@Test
	public void testGetList() {
		log.info("getList()");
		System.out.println(mapper.getList(83));
		
	}
	
	
}










