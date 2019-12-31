package com.wyx.service;

import com.wyx.module.SystemInfo;

/**
 * Class Name:SystemEditService.java
 * 
 * @Description 系统管理员 个人信息修改
 * @author GPZoe
 * @since 2019年12月17日
 * @version 1.0 
 */
public interface SystemEditService {
	
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
