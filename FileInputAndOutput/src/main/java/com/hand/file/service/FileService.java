package com.hand.file.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @ClassName: FileService
 * 
 * @Description:文件逻辑处理层
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月9日 下午3:52:05
 * 
 */
@Service
public interface FileService {

	/**
	 * 
	 * @Title: insertFileMassage
	 * 
	 * @Description:
	 * 
	 * @param @param
	 *            multipartfile
	 * @param @return
	 *            字符串用于判断是上传成功
	 * 
	 * @return String
	 * 
	 * @author ZhongLingYun
	 * 
	 */
	String insertFileMassage(MultipartFile multipartfile);

}
