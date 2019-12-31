package com.wyx.service;

import com.wyx.module.CollegeInfo;

/**
 * Class Name:CollegeLoginService.java
 * 
 * @Description 管理员登录、注册（不开放）
 * @author GPZoe
 * @since 2019年12月16日
 * @version 1.0 
 */
public interface CollegeLoginService {
	
	/**
	 * Description：注册添加学院管理员账号 - 关闭
	 * @param info
	 * @return void
	 * @data 2019年12月16日
	 */
	void addCollegeInfo(CollegeInfo info);
	
	/**
	 * Description：学院管理员登录
	 * @param info 管理员对象 - 待匹配帐号密码
	 * @return boolean 标记是否登录成功
	 * @data 2019年12月16日
	 */
	boolean loginCollege(CollegeInfo info);
	
	/**
	 * Description：判断学院管理员是否存在
	 * @param info 待判断管理员对象
	 * @return boolean 标记是否存在
	 * @data 2019年12月16日
	 */
	boolean isCollegeInfoExist(CollegeInfo account);
	
}
