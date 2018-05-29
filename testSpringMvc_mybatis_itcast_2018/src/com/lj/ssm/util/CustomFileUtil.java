package com.lj.ssm.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class CustomFileUtil {
	/**
	 * 上传文件到服务器目录
	 * @author lujian
	 * @throws IOException 
	 * @throws Exception 
	 * @create 2018年5月29日
	 */
	public static String uploadFile(MultipartFile file, HttpServletRequest request) throws Exception {
 		String originalFilename = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		String path = request.getServletContext().getRealPath("upload/" + newFileName);
		
		File newFile = new File(path);
		if(!newFile.exists()) {
			newFile.mkdirs();
		}
		file.transferTo(newFile);
		
		return newFileName;
	}
	
	/**
	 * 使用虚拟路径上传文件到硬盘
	 * @author lujian
	 * @throws IOException 
	 * @throws Exception 
	 * @create 2018年5月29日
	 */
	public static String uploadFile1(MultipartFile file) throws Exception {
		String originalFilename = file.getOriginalFilename();
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		String path = "H:/pic/" + newFileName;
		
		File newFile = new File(path);
		if(!newFile.exists()) {
			newFile.mkdirs();
		}
		file.transferTo(newFile);
		
		return newFileName;
	}
}
