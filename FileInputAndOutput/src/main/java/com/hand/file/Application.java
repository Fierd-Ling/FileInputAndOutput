package com.hand.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
/** 

    * @ClassName: Application 

    * @Description:启动入口

    * @author ZhongLingYun

    * @date 2018年8月8日 下午7:25:38 
 
*/
@SpringBootApplication
@MapperScan("com.hand.file.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("启动完毕");
	}
}