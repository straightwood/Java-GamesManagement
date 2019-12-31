package com.wyx.dao;

import com.wyx.module.SystemInfo;

/**
 * Class Name:SystemInfoDao.java
 * 
 * @Description 系统管理员模块. 登录注册、个人信息修改
 * @author GPZoe
 * @since 2019年12月27日
 * @version 1.0 
 */
public interface SystemInfoDao {
	
	
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
	
	/**
	 * Description：修改密码
	 * @param account 待修改信息的帐号
	 * @param password 新密码
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean passwordEdit(String account,String password);
	
	/**
	 * Description：修改电话号码
	 * @param account 待修改信息的帐号
	 * @param phonenumber 新手机号码
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean phonenumberEdit(String account,String phonenumber);
	
	/**
	 * Description：修改其他备注信息
	 * @param account 待修改对象的帐号
	 * @param other 新信息
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean otherEdit(String account,String other);
	
	/**
	 * Description：获取当前个人信息，用于控制台显示
	 * @param account 当前管理员帐号
	 * @return CollegeInfo 返回一个管理员对象
	 * @data 2019年12月27日
	 */
	SystemInfo getInfo(String account);
	
}
