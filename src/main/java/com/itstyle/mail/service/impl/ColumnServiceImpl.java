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

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.entity.Columns;
import com.itstyle.mail.entity.Tables;
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
	public Result listForPage(Columns column, int pageNumber, int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
        		.withMatcher("columnName", ExampleMatcher.GenericPropertyMatchers.contains()) //采用“like”的方式查询;
        		.withMatcher("columnComment", ExampleMatcher.GenericPropertyMatchers.contains()) //采用“like”的方式查询;
                // 忽略 id 和 createTime 字段。
                .withIgnorePaths("id", "length")
                // 忽略大小写。
                //.withIgnoreCase()
                // 忽略为空字段。
                .withIgnoreNullValues();
        // 携带 ExampleMatcher。
        Example<Columns> columnsExample = Example.of(column, exampleMatcher);
        Page<Columns> list =  columnRepository.findAll(columnsExample,pageRequest);
		return Result.ok(list);
	}
	
	@Override
	public Result list(Columns column) {
		Columns query = new Columns();
		if(StringUtils.isNotBlank(column.getTableName())) {
			query.setTableName(column.getTableName());
		}
	    Example<Columns> columnsExample = Example.of(query);
		List<Columns> list =  columnRepository.findAll(columnsExample);
		return Result.ok(list);
	}

	@Override
	public Result addColumn(Columns column) {
		column =  columnRepository.save(column);
		return Result.ok(column);
	}
}
