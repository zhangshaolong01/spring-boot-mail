/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.service.impl 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:33:01 
 */
package com.itstyle.mail.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.entity.User;
import com.itstyle.mail.repository.UserRepository;
import com.itstyle.mail.service.IUserService;

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
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	public Result listUser(User user) {
		List<User> list =  userRepository.findAll();
		return Result.ok(list);
	}
}
