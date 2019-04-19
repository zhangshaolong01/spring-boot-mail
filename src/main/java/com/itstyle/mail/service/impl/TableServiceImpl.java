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
import com.itstyle.mail.entity.Tables;
import com.itstyle.mail.repository.TableRepository;
import com.itstyle.mail.service.ITableService;

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
public class TableServiceImpl implements ITableService {
	private static final Logger logger = LoggerFactory.getLogger(TableServiceImpl.class);
	@Autowired
	private TableRepository tablesRepository;

	@Override
	public Result listTable(Tables tables) {
		List<Tables> list =  tablesRepository.findAll();
		return Result.ok(list);
	}

	@Override
	public Result addTable(Tables tables) {
		tables =  tablesRepository.save(tables);
		return Result.ok(tables);
	}
}
