package com.momo.vo;

import lombok.Data;

@Data
public class FileuploadVO {

	private String uuid;
	private String uploadpath;
	private String filename;
	private String filetype;
	private int bno;
}
