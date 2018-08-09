package com.hand.file.util;

import java.util.Calendar;

/**
 * 
 * @ClassName: Time
 * 
 * @Description:时间工具包
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月9日 下午5:04:59
 * 
 */
public abstract class Time {

	/**
	 * 
	 * @Title: getTime
	 * 
	 * @Description:获取当前时间的时间戳，转换为一个string
	 * 
	 * @param @return
	 *            时间戳字符串
	 * 
	 * @return String
	 * 
	 * @author ZhongLingYun
	 * 
	 */
	public static String getTime() {
		Long time = Calendar.getInstance().getTimeInMillis();
		String timeString = time.toString();
		return timeString;
	}

}
