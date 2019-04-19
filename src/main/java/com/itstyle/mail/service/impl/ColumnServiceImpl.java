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
import com.itstyle.mail.entity.Columns;
import com.itstyle.mail.repository.ColumnRepository;
import com.itstyle.mail.service.IColumnService;

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
public class ColumnServiceImpl implements IColumnService {
	private static final Logger logger = LoggerFactory.getLogger(ColumnServiceImpl.class);
	@Autowired
	private ColumnRepository columnRepository;

	@Override
	public Result listColumn(Columns column) {
		List<Columns> list =  columnRepository.findAll();
		return Result.ok(list);
	}

	@Override
	public Result addColumn(Columns column) {
		column =  columnRepository.save(column);
		return Result.ok(column);
	}
}
