/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.common.redis 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:57:29 
 */
package com.itstyle.mail.common.redis;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itstyle.mail.common.model.Email;
import com.itstyle.mail.service.IMailService;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: Receiver.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:57:29 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    @Autowired
	private IMailService mailService;
    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("接收email消息 <{}>",message);
        if(message == null){
            LOGGER.info("接收email消息 <" + null + ">");
        }else {
        	ObjectMapper mapper = new ObjectMapper();  
			try {
				Email email = mapper.readValue(message, Email.class);
				mailService.send(email);
				LOGGER.info("接收email消息内容 <{}>",email.getContent());
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        latch.countDown();
    }
}
