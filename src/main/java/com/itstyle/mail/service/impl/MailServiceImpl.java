/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.service.impl 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:33:01 
 */
package com.itstyle.mail.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.itstyle.mail.common.dynamicquery.DynamicQuery;
import com.itstyle.mail.common.model.Email;
import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.common.queue.MailQueue;
import com.itstyle.mail.common.util.Constants;
import com.itstyle.mail.entity.OaEmail;
import com.itstyle.mail.repository.MailRepository;
import com.itstyle.mail.service.IMailService;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: MailServiceImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:33:01 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
@Service
@Component
public class MailServiceImpl implements IMailService {
	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private JavaMailSender mailSender;//执行者
	@Autowired
	public Configuration configuration;//freemarker
	@Autowired
	private SpringTemplateEngine  templateEngine;//thymeleaf
	@Value("${spring.mail.username}")
	public String USER_NAME;//发送者
	@Value("${server.path}")
	public String PATH;//发送者
	
	
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	static {
		 System.setProperty("mail.mime.splitlongparameters","false");
	}

	@Override
	public void send(Email mail) throws Exception {
		logger.info("发送邮件：{}",mail.getContent());
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(USER_NAME);
		message.setTo(mail.getEmail());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		mailSender.send(message);
	}

	@Override
	public void sendHtml(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		//这里可以自定义发信名称比如：爪哇笔记
		helper.setFrom(USER_NAME,"爪哇笔记");
		helper.setTo(mail.getEmail());
		helper.setSubject(mail.getSubject());
		helper.setText(
				"<html><body><img src=\"cid:springcloud\" ></body></html>",
				true);
		// 发送图片
		File file = ResourceUtils.getFile("classpath:static"
				+ Constants.SF_FILE_SEPARATOR + "image"
				+ Constants.SF_FILE_SEPARATOR + "springcloud.png");
		helper.addInline("springcloud", file);
		// 发送附件
		file = ResourceUtils.getFile("classpath:static"
				+ Constants.SF_FILE_SEPARATOR + "file"
				+ Constants.SF_FILE_SEPARATOR + "关注科帮网获取更多源码.zip");
		helper.addAttachment("科帮网", file);
		mailSender.send(message);
	}

	@Override
	public void sendFreemarker(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		//这里可以自定义发信名称比如：爪哇笔记
		helper.setFrom(USER_NAME,"爪哇笔记");
		helper.setTo(mail.getEmail());
		helper.setSubject(mail.getSubject());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("mail", mail);
		model.put("path", PATH);
		Template template = configuration.getTemplate(mail.getTemplate());
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(
				template, model);
		helper.setText(text, true);
		mailSender.send(message);
		mail.setContent(text);
		OaEmail oaEmail = new OaEmail(mail);
		mailRepository.save(oaEmail);
	}
	//弃用
	@Override
	public void sendThymeleaf(Email mail) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(USER_NAME);
		helper.setTo(mail.getEmail());
		helper.setSubject(mail.getSubject());
		Context context = new Context();
		context.setVariable("email", mail);
		String text = templateEngine.process(mail.getTemplate(), context);
		helper.setText(text, true);
		mailSender.send(message);
	}

	@Override
	public void sendQueue(Email mail) throws Exception {
		MailQueue.getMailQueue().produce(mail);
	}
	@Override
	public void sendRedisQueue(Email mail) throws Exception {
		redisTemplate.convertAndSend("mail",mail);
	}

	@Override
	public Result listMail(Email mail) {
		List<OaEmail> list =  mailRepository.findAll();
		return Result.ok(list);
	}
}
