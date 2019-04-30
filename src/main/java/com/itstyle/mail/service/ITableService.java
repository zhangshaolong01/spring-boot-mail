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
import com.itstyle.mail.entity.Tables;

public interface ITableService {

	public Result list(Tables table, int pageNumber, int pageSize);

	public Result add(Tables table);

	public Result get(Tables table);

	public Result mod(Tables table);
}
