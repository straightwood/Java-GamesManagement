package com.wyx.service;

import com.wyx.module.CollegeInfo;

/**
 * Class Name:CollegeEditService.java
 * 
 * @Description 
 * @author GPZoe
 * @since 2019年12月27日
 * @version 1.0 
 */
public interface CollegeEditService {
	
	/**
	 * Description：获取当前个人信息，用于控制台显示
	 * @param account 当前管理员帐号
	 * @return CollegeInfo 返回一个管理员对象
	 * @data 2019年12月27日
	 */
	CollegeInfo getInfo(String account);
	

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
	 * Description：修改所属学院 -不开放
	 * @param account
	 * @param other
	 * @return
	 * @return boolean
	 * @data 2019年12月17日
	 */
	//boolean otherEdit(String account,String other);
}
