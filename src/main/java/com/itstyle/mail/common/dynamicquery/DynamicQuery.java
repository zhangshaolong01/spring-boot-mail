/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.itstyle.mail.common.dynamicquery 
 * @author: Administrator   
 * @date: 2018年12月2日 下午10:47:30 
 */
package com.itstyle.mail.common.dynamicquery;

import java.util.List;

/**   
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: DynamicQuery.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年12月2日 下午10:47:30 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年12月2日     Administrator           v1.0.0               修改原因
*/
public interface DynamicQuery {

	public void save(Object entity);

	public void update(Object entity);

	public <T> void delete(Class<T> entityClass, Object entityid);

	public <T> void delete(Class<T> entityClass, Object[] entityids);
	
	 /**
     * 查询对象列表，返回List
     * @param resultClass
     * @param nativeSql
     * @param params
     * @return  List<T>
     * @Date	2018年3月15日
     * 更新日志
     * 2018年3月15日  张志朋  首次创建
     *
     */
	<T> List<T> nativeQueryList(String nativeSql, Object... params);
	
	 /**
     * 查询对象列表，返回List<Map<key,value>>
     * @param nativeSql
     * @param params
     * @return  List<T>
     * @Date	2018年3月15日
     * 更新日志
     * 2018年3月15日  张志朋  首次创建
     *
     */
	<T> List<T> nativeQueryListMap(String nativeSql,Object... params);

	 /**
     * 查询对象列表，返回List<组合对象>
     * @param resultClass
     * @param nativeSql
     * @param params
     * @return  List<T>
     * @Date	2018年3月15日
     * 更新日志
     * 2018年3月15日  张志朋  首次创建
     *
     */
	<T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params);
	
	/**
	 * 执行nativeSql统计查询
	 * @param nativeSql
	 * @param params 占位符参数(例如?1)绑定的参数值
	 * @return 统计条数
	 */
	Long nativeQueryCount(String nativeSql, Object... params);


}
