/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.repository 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:30:59 
 */
package com.itstyle.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itstyle.mail.entity.OaEmail;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: MailRepository.java
* @Description: 邮件管理
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:30:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public interface MailRepository extends JpaRepository<OaEmail, Integer>{

}
