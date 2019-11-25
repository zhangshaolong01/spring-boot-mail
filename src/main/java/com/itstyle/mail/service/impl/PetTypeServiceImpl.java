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
import com.itstyle.mail.entity.PetType;
import com.itstyle.mail.repository.PetTypeRepository;
import com.itstyle.mail.service.IPetTypeService;

/**
 * @author zhangshaolong
 *
 */
@Service
@Component
public class PetTypeServiceImpl implements IPetTypeService {
	private static final Logger logger = LoggerFactory.getLogger(PetTypeServiceImpl.class);
	@Autowired
	private PetTypeRepository petTypeRepository;

	@Override
	public Result list() {
		List<PetType> list = petTypeRepository.findAll();
		return Result.ok(list);
	}

}
