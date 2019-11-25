/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.service.impl 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:33:01 
 */
package com.itstyle.mail.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.entity.Pet;
import com.itstyle.mail.entity.PetDetail;
import com.itstyle.mail.repository.PetDetailRepository;
import com.itstyle.mail.repository.PetRepository;
import com.itstyle.mail.service.IPetService;

/**
 * @author zhangshaolong
 *
 */
@Service
@Component
public class PetServiceImpl implements IPetService {
	private static final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private PetDetailRepository petDetailRepository;

	@Override
	public Result list(Pet pet, int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize);
		// 条件匹配器
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("petNameCn", match -> match.contains());// 模糊查询
		// 定义example条件对象
		Example<Pet> example = Example.of(pet, exampleMatcher);

		Page<Pet> page = petRepository.findAll(example, pageable);
		return Result.ok(page.getContent());
	}

	@Override
	public Result get(PetDetail petDetail) {
		petDetail = petDetailRepository.findOne(petDetail.getId());
		return Result.ok(petDetail);
	}

}
