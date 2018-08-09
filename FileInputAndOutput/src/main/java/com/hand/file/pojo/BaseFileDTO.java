package com.hand.file.pojo;

/**
 * 
 * @ClassName: BaseFile
 * 
 * @Description:文件实体
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月9日 上午11:18:36
 * 
 */
public class BaseFileDTO {

	/**
	 * 
	 * 上传文件所在的id编号
	 * 
	 */
	private Integer fileId;

	/**
	 * 
	 * 文件大小
	 * 
	 */
	private Long size;

	/**
	 * 
	 * 文件类型
	 */
	private String fileType;

	/**
	 * 
	 * 文件最初的名字
	 * 
	 */
	private String fileOldName;

	/**
	 * 文件在文件库中名字
	 * 
	 */
	private String fileNewName;

	@Override
	public String toString() {
		return "BaseFileDTO [fileId=" + fileId + ", size=" + size + ", fileType=" + fileType + ", fileOldName="
				+ fileOldName + ", fileNewName=" + fileNewName + "]";
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getFileOldName() {
		return fileOldName;
	}

	public void setFileOldName(String fileOldName) {
		this.fileOldName = fileOldName;
	}

	public String getFileNewName() {
		return fileNewName;
	}

	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
