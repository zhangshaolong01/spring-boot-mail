/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.web 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:24:18 
 */
package com.itstyle.mail.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.entity.User;
import com.itstyle.mail.service.IUserService;

import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: mailController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:24:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("list")
	public Result list(User user) {
		return userService.listUser(user);
	}
	
	@PostMapping("add")
	public Result add(User user) {
		return userService.addUser(user);
	}
	
	/**
	 * 订单信息上传
	 * @param user
	 * @return
	 */
	@PostMapping("uploadOderIInfo")
	public Result uploadOderIInfo(String data) {
		System.out.println(data);
		Result result = new Result();
		return result.ok();
	}
	
	/**
	 * 服务执行记录上传
	 * @param user
	 * @return
	 */
	@PostMapping("uploadExeServiceRecord")
	public Map uploadExeServiceRecord(String data) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(Map.class);
		JSONArray fromObject = JSONArray.fromObject(data,jsonConfig);
		System.out.println(fromObject.toString());
		Map<String,Object> map = new HashMap<>();
		map.put("businessCode", "0000");
		return map;
	}
}
