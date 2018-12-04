/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.common.util 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:37:07 
 */
package com.itstyle.mail.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: CommonUtil.java
* @Description: 单例
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:37:07 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public class CommonUtil {
	private static ObjectMapper mapper;   
	  
    public static synchronized ObjectMapper getMapperInstance(boolean createNew) {   
        if (createNew) {   
            return new ObjectMapper();   
        } else if (mapper == null) {   
            mapper = new ObjectMapper();   
        }   
        return mapper;   
    }  
}
