/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.service 
 * @author: Administrator   
 * @date: 2018年12月2日 下午1:59:50 
 */
package com.itstyle.mail.service;

import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.entity.Skill;

/**
 * @author zhangshaolong
 *
 */
public interface ISkillService {

	public Result get(String id);
	
	public Result getPetSkillList(String petId);

	public Result getSkillPetList(String skillId);

}
