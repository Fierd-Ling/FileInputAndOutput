package com.hand.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hand.file.service.FileService;
import com.hand.file.util.AbstractConstant;

/**
 * 
 * @ClassName: FileContoller
 * 
 * @Description:文件上传控制层
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月8日 下午8:01:40
 * 
 */
@Controller
@RequestMapping(value = "/fileController")
public class FileContoller {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/inputImg", method = RequestMethod.POST)
	public @ResponseBody String inputImg(
			// 此处名字要和input中的name同名
			MultipartFile inputfil) {
		String result = AbstractConstant.INSERT_FILE_FAILURE;
		// 入参参数校验
		if (inputfil == null) {
			return result;
		}
		result = fileService.insertFileMassage(inputfil);
		return result;
	}

	/**
	 * 
	 * @Title: download
	 * 
	 * @Description:文件下载
	 * 
	 * @param @return
	 * @param @throws
	 *            IOException
	 * 
	 * @return ResponseEntity<byte[]>
	 * 
	 * @author ZhongLingYun
	 * 
	 */
	// TODO 异常处理，需要处理异常，文件转字节数组出现异常不能直接抛出，文件大小需要限制，需要下载之前需要异步调用校验
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download() throws IOException {
		// 文件下载有限制，不能超过一定的大小暂时没有解决大文件下载
		File file = new File("E:\\poi-bin-3.17-20170915.tar.gz");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", "poi-bin-3.17-20170915.tar.gz");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// FileUtils.readFileToByteArray(file);
		byte[] fileArray = FileUtils.readFileToByteArray(file);
		return new ResponseEntity<byte[]>(fileArray, headers, HttpStatus.CREATED);
	}
}
