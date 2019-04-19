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
import com.itstyle.mail.entity.User;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: IMailService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午1:59:50 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public interface IUserService {

	public Result listUser(User user);

	public Result addUser(User user);
}
