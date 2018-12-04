/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.common.interceptor 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:52:23 
 */
package com.itstyle.mail.common.interceptor;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright: Copyright (c) 2018 LanRu-Caifu
 * 
 * @ClassName: MyAdapter.java
 * @Description: 配置首页
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年12月2日 下午10:52:23
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年12月2日
 *        Administrator v1.0.0 修改原因
 */
public class MyAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/login.shtml");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}
}
