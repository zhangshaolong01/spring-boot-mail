/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.service 
 * @author: Administrator   
 * @date: 2018年12月2日 下午1:59:50 
 */
package com.itstyle.mail.service;

import com.itstyle.mail.common.model.Email;
import com.itstyle.mail.common.model.Result;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: IMailService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午1:59:50 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public interface IMailService {
	/**
	  * 纯文本
	  * @Author  科帮网
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年7月20日
	  * 更新日志
	  * 2017年7月20日  科帮网 首次创建
	  */
	 public void send(Email mail) throws Exception;
	 /**
	  * 富文本
	  * @Author  科帮网
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年7月20日
	  * 更新日志
	  * 2017年7月20日  科帮网 首次创建
	  *
	  */
	 public void sendHtml(Email mail) throws Exception;
	 /**
	  * 模版发送 freemarker
	  * @Author  科帮网
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年7月20日
	  * 更新日志
	  * 2017年7月20日  科帮网 首次创建
	  *
	  */
	 public void sendFreemarker(Email mail) throws Exception;
	 /**
	  * 模版发送 thymeleaf(弃用、需要配合模板)
	  * @Author  科帮网
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年7月20日
	  * 更新日志
	  * 2017年7月20日  科帮网 首次创建
	  *
	  */
	 public void sendThymeleaf(Email mail) throws Exception;
	 /**
	  * 队列
	  * @Author  科帮网
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年8月4日
	  * 更新日志
	  * 2017年8月4日  科帮网 首次创建
	  *
	  */
	 public void sendQueue(Email mail) throws Exception;
	 /**
	  * Redis 队列
	  * @Author  科帮网
	  * @param mail
	  * @throws Exception  void
	  * @Date	2017年8月13日
	  * 更新日志
	  * 2017年8月13日  科帮网 首次创建
	  *
	  */
	 public void sendRedisQueue(Email mail) throws Exception;
	 
	 
	 public Result listMail(Email mail);
}
