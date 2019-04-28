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
import com.itstyle.mail.entity.Columns;
import com.itstyle.mail.service.IColumnService;

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
@Api(tags = "列管理")
@RestController
@RequestMapping("/column")
public class ColumnController {
	
	@Autowired
	private IColumnService columnService;
	
	@PostMapping("listForPage")
	public Result listForPage(Columns column, int pageNumber, int pageSize) {
		return columnService.listForPage(column, pageNumber, pageSize);
	}
	
	@PostMapping("list")
	public Result list(Columns column) {
		return columnService.list(column);
	}
	
	@PostMapping("add")
	public Result add(Columns column) {
		return columnService.addColumn(column);
	}
}
