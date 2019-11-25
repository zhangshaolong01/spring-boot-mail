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
import com.itstyle.mail.entity.PetSkill;
import com.itstyle.mail.entity.Skill;
import com.itstyle.mail.entity.SkillPet;
import com.itstyle.mail.repository.PetSkillRepository;
import com.itstyle.mail.repository.SkillPetRepository;
import com.itstyle.mail.repository.SkillRepository;
import com.itstyle.mail.service.ISkillService;

/**
 * @author zhangshaolong
 *
 */
@Service
@Component
public class SkillServiceImpl implements ISkillService {
	private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);

	@Autowired
	private PetSkillRepository petSkillRepository;
	@Autowired
	private SkillPetRepository skillPetRepository;
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public Result get(String id) {
		Skill skill = skillRepository.findOne(Integer.valueOf(id));
		return Result.ok(skill);
	}

	@Override
	public Result getPetSkillList(String id) {
		List<PetSkill> list = petSkillRepository.getPetSkillList(id);
		return Result.ok(list);
	}

	@Override
	public Result getSkillPetList(String skillId) {
		List<SkillPet> list = skillPetRepository.getSkillPetList(skillId);
		return Result.ok(list);
	}

}
