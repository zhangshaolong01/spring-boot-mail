/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.web 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:22:22 
 */
package com.itstyle.mail.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: IndexController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:22:22 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
@Api(tags = "通用访问拦截匹配")
@Controller
public class IndexController {
	
	/**
	 * 页面跳转
	 * @param module
	 * @param url
	 * @return
	 */
	@RequestMapping("/")
	public String page() {
		return "main";
	}
	
	/**
	 * 页面跳转
	 * @param module
	 * @param url
	 * @return
	 */
	@GetMapping("{url}.shtml")
	public String page(@PathVariable("url") String url) {
		return  url;
	}
	/**
	 * 页面跳转(二级目录)
	 * @param module
	 * @param function
	 * @param url
	 * @return
	 */
	@GetMapping("{module}/{url}.shtml")
	public String page(@PathVariable("module") String module,@PathVariable("url") String url) {
		return module + "/" + url;
	}
	
}
