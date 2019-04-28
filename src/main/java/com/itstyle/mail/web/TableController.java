/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.web 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:24:18 
 */
package com.itstyle.mail.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itstyle.mail.common.model.Result;
import com.itstyle.mail.entity.Tables;
import com.itstyle.mail.service.ITableService;

import io.swagger.annotations.Api;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: mailController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:24:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
@Api(tags = "用户管理")
@RestController
@RequestMapping("/table")
public class TableController {
	
	@Autowired
	private ITableService tableService;
	
	@PostMapping("list")
	public Result list(Tables table,int pageNumber,int pageSize) {
		return tableService.listTable(table,pageNumber,pageSize);
	}
	
	@PostMapping("get")
	public Result get(Tables table) {
		return tableService.get(table);
	}
	
	@PostMapping("add")
	public Result add(Tables table) {
		return tableService.addTable(table);
	}
}
