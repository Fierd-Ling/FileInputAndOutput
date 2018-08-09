package com.hand.img.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 * @ClassName: FileContoller
 * 
 * @Description:文件长传控制层
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月8日 下午8:01:40
 * 
 */
@Controller
@RequestMapping(value = "/fileController")
public class FileContoller {

	private static final Log log = LogFactory.getLog(FileContoller.class);

	/**
	 * 
	 * @Title: inputImg
	 * 
	 * @Description: ajax上传文件
	 * 
	 * @param @return
	 * 
	 * @return String
	 * 
	 * @author ZhongLingYun
	 * @throws IOException 
	 * 
	 */
	@RequestMapping(value = "/inputImg", method = RequestMethod.POST)
	public @ResponseBody String inputImg(HttpServletRequest request,
			// 此处名字要和input中的name同名
			MultipartFile inputfil) throws IOException {
		log.info("---------------------------------------------------------------------");
		// 获取原来的名字
		log.info(inputfil.getOriginalFilename());
		log.info(inputfil.getContentType());
		log.info("---------------------------------------------------------------------");
		// 截取文件类型
		String contentType=inputfil.getContentType();
		String type =contentType.substring(contentType.indexOf("/")+1);
		Long fileName=Calendar.getInstance().getTimeInMillis();
		// 借助Appache io实现文件复制 
        InputStream inputStream = inputfil.getInputStream();
        File targetFile = new File("imgHouse\\"+fileName+"."+type);
        FileUtils.copyInputStreamToFile(inputStream, targetFile);
		return null;
	}

}
