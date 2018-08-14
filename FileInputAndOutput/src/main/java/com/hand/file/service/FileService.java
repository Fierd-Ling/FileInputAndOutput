package com.hand.file.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hand.file.pojo.BaseFileDTO;

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

	/**
	 * 
	 * @Title: listFile
	 * 
	 * @Description:
	 * 
	 * @param page
	 *            第几页
	 * @param pageSize
	 *            每页有多少条数据
	 * @return 如果返回值为null 是页码超过数据库中所有的页码,或者pageSize<0或者page<0 List<BaseFileDTO>
	 * 
	 * @author ZhongLingYun
	 * 
	 */
	List<BaseFileDTO> listFile(int page, int pageSize);

	/**
	 * 
	 * @Title: countFile
	 * 
	 * @Description:统计数据库有多少文件
	 * 
	 * @param @return
	 * 
	 * @return Integer 文件数量
	 * 
	 * @author ZhongLingYun
	 * 
	 */
	Integer countFile();

}
