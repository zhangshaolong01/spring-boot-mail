/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.common.model 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:27:27 
 */
package com.itstyle.mail.common.model;

import java.util.HashMap;
import java.util.Map;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: Result.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:27:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public class Result extends HashMap<String,Object>{

	private static final long serialVersionUID = 1L;

	public Result() {
		put("code", 0);
	}

	public static Result error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static Result error(String msg) {
		return error(500, msg);
	}

	public static Result error(int code, String msg) {
		Result r = new Result();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Result ok(Object msg) {
		Result r = new Result();
		r.put("msg", msg);
		return r;
	}


	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}

	public static Result ok() {
		return new Result();
	}

	@Override
	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
