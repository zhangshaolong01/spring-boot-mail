/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.common.queue 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:54:32 
 */
package com.itstyle.mail.common.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itstyle.mail.common.model.Email;
import com.itstyle.mail.service.IMailService;

/**
 * Copyright: Copyright (c) 2018 LanRu-Caifu
 * 
 * @ClassName: ConsumeMailQueue.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年12月2日 下午10:54:32
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年12月2日
 *        Administrator v1.0.0 修改原因
 */
@Component
public class ConsumeMailQueue {
	private static final Logger logger = LoggerFactory.getLogger(ConsumeMailQueue.class);
	@Autowired
	IMailService mailService;

	@PostConstruct
	public void startThread() {
		ExecutorService e = Executors.newFixedThreadPool(2);// 两个大小的固定线程池
		e.submit(new PollMail(mailService));
		e.submit(new PollMail(mailService));
	}

	class PollMail implements Runnable {
		IMailService mailService;

		public PollMail(IMailService mailService) {
			this.mailService = mailService;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Email mail = MailQueue.getMailQueue().consume();
					if (mail != null) {
						logger.info("剩余邮件总数:{}", MailQueue.getMailQueue().size());
						mailService.send(mail);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@PreDestroy
	public void stopThread() {
		logger.info("destroy");
	}
}
