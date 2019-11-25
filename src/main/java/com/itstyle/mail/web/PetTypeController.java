/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.web 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:22:22 
 */
package com.itstyle.mail.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.entity.PetType;
import com.itstyle.mail.service.IPetTypeService;

import io.swagger.annotations.Api;

/**
 * @author zhangshaolong
 *
 */
@Api(tags = "通用访问拦截匹配")
@RestController
@RequestMapping("/petType")
public class PetTypeController {
	@Autowired
	private IPetTypeService petTypeService;

	@PostMapping("list")
	public Result list() {
		PetType type = new PetType();
		return petTypeService.list();
	}

}
