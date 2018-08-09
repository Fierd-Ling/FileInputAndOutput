package com.hand.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hand.file.mapper.FileMapper;
import com.hand.file.pojo.BaseFileDTO;
import com.hand.file.service.FileService;
import com.hand.file.util.AbstractConstant;
import com.hand.file.util.Time;

/**
 * 
 * @ClassName: FileServiceImpl
 * 
 * @Description:FileService实现类
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月9日 下午4:00:39
 * 
 */
@Service
public class FileServiceImpl implements FileService {

	private static final Log log = LogFactory.getLog(FileServiceImpl.class);

	@Autowired
	private FileMapper fileMapper;

	@Override
	public String insertFileMassage(MultipartFile multipartFile) {
		String resultString = AbstractConstant.INSERT_FILE_FAILURE;
		// 判断对象是否为空为空直接回退
		if(multipartFile==null) {
			return resultString;	
		}
		// 截取文件类型
		String contentType = multipartFile.getContentType();
		String type = contentType.substring(contentType.indexOf("/") + 1);
		Long size=multipartFile.getSize();
		// 获取文件名字
		String oldFileName = multipartFile.getOriginalFilename();
		String fileNewName=Time.getTime();
		// 修改名字防止冲突覆盖
		File houseFile = new File(AbstractConstant.FILE_URL + fileNewName + "." + type);
		// 复制到文件存放库
		try {
			InputStream inputStream = multipartFile.getInputStream();
			// 借助Appache io实现文件复制
			FileUtils.copyInputStreamToFile(inputStream, houseFile);
		} catch (IOException e) {
			// 记录异常日志
			log.debug(e.toString());
			// 文件存储失败，直接回退
			return resultString;
		}
		BaseFileDTO baseFileDTO = new BaseFileDTO();
		baseFileDTO.setFileNewName(fileNewName);
		baseFileDTO.setFileOldName(oldFileName);
		baseFileDTO.setSize(size);
		baseFileDTO.setFileType(type);
		Integer result = fileMapper.insertFile(baseFileDTO);
		if (result==1) {
			resultString = AbstractConstant.INSERT_FILE_SUCCESS;
			log.info("上传文件成功文件类型是 ：" + contentType + "  文件名称是：" + oldFileName);
			return resultString;
		}  
			// 如果数据库受影响的行数不是1，数据库存储出错，返回错误提示，用户重新上传
			log.debug("上传文件失败文件类型是：" + contentType + "  文件名称是：" + oldFileName + "数据库记录出错");
			return resultString;	
	}

}
