/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.common.util 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:39:35 
 */
package com.itstyle.mail.common.util;

import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: MailUtil.java
* @Description: 异步发送
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:39:35 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public class MailUtil {
    private Logger logger = LoggerFactory.getLogger(MailUtil.class);

    //创建一个定长线程池，支持定时及周期性任务执行。
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(6);

    //原子类型
    private final AtomicInteger count = new AtomicInteger(1);

    public void start(final JavaMailSender mailSender,final SimpleMailMessage message) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (count.get() == 2) {
                        service.shutdown();
                        logger.info("the task is down");
                    }
                    logger.info("start send email and the index is " + count);
                    mailSender.send(message);
                    logger.info("send email success");
                }catch (Exception e){
                    logger.error("send email fail" , e);
                }

            }
        });
    }
    public void startHtml(final JavaMailSender mailSender,final MimeMessage message) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (count.get() == 2) {
                        service.shutdown();
                        logger.info("the task is down");
                    }
                    logger.info("start send email and the index is " + count);
                    mailSender.send(message);
                    logger.info("send email success");
                }catch (Exception e){
                    logger.error("send email fail" , e);
                }

            }
        });
    }
    /**
     * 获取 Sender 多实例发送
     * @return
     */
    public static JavaMailSenderImpl createMailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.mxhichina.com");
        sender.setPort(25);
        sender.setUsername("admin@52itstyle.com");
        sender.setPassword("123456");
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout",1000+"");
        p.setProperty("mail.smtp.auth","true");
        sender.setJavaMailProperties(p);
        return sender;
    }
	
	public static void main(String[] args) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("admin@52itstyle.com");
		message.setTo("345849402@qq.com");
		message.setSubject("测试");
		message.setText("测试");
		createMailSender().send(message);
	}
}
