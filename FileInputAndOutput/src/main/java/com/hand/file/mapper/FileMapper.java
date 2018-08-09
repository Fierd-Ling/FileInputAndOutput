package com.hand.file.mapper;

import org.springframework.stereotype.Repository;

import com.hand.file.pojo.BaseFileDTO;

/** 

    * @ClassName: FileMapper 

    * @Description:File表数据库操作接口

    * @author ZhongLingYun

    * @date 2018年8月9日 下午12:06:19 
 
*/
@Repository
public interface FileMapper {
	
	 
	    /** 
	
	    * @Title: insertFile 
	
	    * @Description:新增一条文件信息到数据库
	
	    * @param @param baseFileDTO
	    * @param @return   数据库影响的行数
	
	    * @return Integer      
	
		* @author ZhongLingYun
	
	    */
	Integer insertFile(BaseFileDTO baseFileDTO);

}
