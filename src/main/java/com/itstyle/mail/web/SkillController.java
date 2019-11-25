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
import com.itstyle.mail.entity.Skill;
import com.itstyle.mail.service.ISkillService;

import io.swagger.annotations.Api;

/**
 * @author zhangshaolong
 *
 */
@Api(tags = "通用访问拦截匹配")
@RestController
@RequestMapping("/skill")
public class SkillController {
	@Autowired
	private ISkillService skillService;

	@PostMapping("petSkillList")
	public Result petSkillList(String id) {
		return skillService.getPetSkillList(id);
	}
	
	@PostMapping("skillPetList")
	public Result skillPetList(String skillId) {
		return skillService.getSkillPetList(skillId);
	}
	
	@PostMapping("get")
	public Result get(String id) {
		return skillService.get(id);
	}
}
