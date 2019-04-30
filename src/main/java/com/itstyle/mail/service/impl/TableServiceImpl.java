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
	public Result list(Tables tables, int pageNumber, int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
		// 1.使用 Example。
        // 2.使用 ExampleMatcher。
        // 创建 ExampleMatcher。
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
        		.withMatcher("tableName", ExampleMatcher.GenericPropertyMatchers.contains()) //采用“like”的方式查询;
        		.withMatcher("tableComment", ExampleMatcher.GenericPropertyMatchers.contains()) //采用“like”的方式查询;
                // 忽略 id 和 createTime 字段。
                .withIgnorePaths("id", "tableSchema")
                // 忽略大小写。
                //.withIgnoreCase()
                // 忽略为空字段。
                .withIgnoreNullValues();
        // 携带 ExampleMatcher。
        Example<Tables> tablesExample = Example.of(tables, exampleMatcher);
		Page<Tables> list =  tablesRepository.findAll(tablesExample,pageRequest);
		
		//Page<Tables> list =  tablesRepository.findByName("%"+tables.getTableName()+"%",pageRequest);
		return Result.ok(list);
	}

	@Override
	public Result add(Tables tables) {
		tables =  tablesRepository.save(tables);
		return Result.ok(tables);
	}

	@Override
	public Result get(Tables tables) {
		tables =  tablesRepository.findOne(tables.getId());
		return Result.ok(tables);
	}

	@Override
	public Result mod(Tables tables) {
		int num =  tablesRepository.mod(tables.getId(),tables.getTableComment());
		return Result.ok(num);
	}
}
