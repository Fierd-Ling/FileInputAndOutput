package com.hand.file.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hand.file.pojo.BaseFileDTO;

/**
 * 
 * @ClassName: FileMapper
 * 
 * @Description:File表数据库操作接口
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月9日 下午12:06:19
 * 
 */
@Repository
public interface FileMapper {

	/**
	 * 
	 * @Title: insertFile
	 * 
	 * @Description:新增一条文件信息到数据库
	 * 
	 * @param @param
	 *            baseFileDTO
	 * @param @return
	 *            数据库影响的行数
	 * 
	 * @return Integer
	 * 
	 * @author ZhongLingYun
	 * 
	 */
	Integer insertFile(BaseFileDTO baseFileDTO);

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

	/**
	 * 
	 * @Title: listFile
	 * 
	 * @Description:
	 * 
	 * @param begin
	 *            記錄的起始行數
	 * @return
	 * 
	 * 		List<BaseFileDTO>
	 * 
	 * @author ZhongLingYun
	 * 
	 */
	List<BaseFileDTO> listFile(Integer begin);

}
