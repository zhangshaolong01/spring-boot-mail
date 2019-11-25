/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail 
 * @author: Administrator   
 * @date: 2018年12月1日 上午11:19:17 
 */
package com.itstyle.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 启动类 API: http://localhost:8080/springboot_mail/swagger-ui.html
 * 
 * 启动 java -jar spring-boot-mail.jar --server.port=8886 linux 下 后台启动 nohup java
 * -jar spring-boot-mail.jar --server.port=8886 &
 * 
 */
@SpringBootApplication
@EnableDubboConfiguration
//@ImportResource({"classpath:spring-context-task.xml"})
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("邮件服务项目启动 ");
	}

}
