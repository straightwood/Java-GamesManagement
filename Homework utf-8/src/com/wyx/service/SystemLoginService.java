package com.wyx.service;

import com.wyx.module.SystemInfo;

/**
 * Class Name:SystemLoginService.java
 * 
 * @Description 系统管理员的登录、注册
 * @author GPZoe
 * @since 2019年12月17日
 * @version 1.0 
 */
public interface SystemLoginService {
	
	
	/**
	 * Description：添加系统管理员帐号
	 * @param info 待添加的新管理员对象 - 包含信息
	 * @return void
	 * @data 2019年12月17日
	 */
	void addSystemInfo(SystemInfo info);
	
	
	/**
	 * Description：系统管理员登录
	 * @param info 管理员对象 - 待匹配帐号密码
	 * @return boolean 标记是否登录成功
	 * @data 2019年12月17日
	 */
	boolean loginSystem(SystemInfo info);
	
	
	/**
	 * Description：判断系统管理员是否存在
	 * @param info 待判断管理员对象
	 * @return boolean 标记是否存在
	 * @data 2019年12月17日
	 */
	boolean isSystemInfoExist(SystemInfo info);
	
}
