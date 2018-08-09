package com.hand.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
