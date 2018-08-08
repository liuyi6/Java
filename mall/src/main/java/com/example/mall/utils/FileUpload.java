package com.example.mall.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
//	存储图片的目录
	private static final String pathRoot = "F:/tmp/images_upload/";
	
//	Tomcat设置的虚拟路径
	private static final String virtualPath = "/upload/";
	
	/**
	 * 下载文件到本地
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		if (file == null) {
			return "file is null";
		}
		String path = "";
		// 生成uuid作为文件名称
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		// 获得文件类型（可以判断如果不是图片，禁止上传）
		String contentType = file.getContentType();
		// 获得文件后缀名称
		String imageName = contentType.substring(contentType.indexOf("/") + 1);
		path = uuid + "." + imageName;
		File saveFile = new File(pathRoot + path);
		file.transferTo(saveFile);
		return virtualPath + path;
	}
}
