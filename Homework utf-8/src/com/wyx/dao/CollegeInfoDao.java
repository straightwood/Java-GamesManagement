package com.wyx.dao;

import com.wyx.module.CollegeInfo;

/**
 * Class Name:CollegeInfoDao.java
 * 
 * @Description 管理员登录注册、个人信息修改
 * @author GPZoe
 * @since 2019年12月17日
 * @version 1.0 
 */
public interface CollegeInfoDao {
	
	/**
	 * Description：注册添加学院管理员账号 - 关闭
	 * @param info
	 * @return void
	 * @data 2019年12月17日
	 */
	void addCollegeInfo(CollegeInfo info);
	
	
	/**
	 * Description：学院管理员登录
	 * @param info 管理员对象 - 待匹配帐号密码
	 * @return boolean 标记是否登录成功
	 * @data 2019年12月17日
	 */
	boolean loginCollege(CollegeInfo info);
	
	
	/**
	 * Description：判断学院管理员是否存在
	 * @param info 待判断管理员对象
	 * @return boolean 标记是否存在
	 * @data 2019年12月17日
	 */
	boolean isCollegeInfoExist(CollegeInfo info);
	
	
	/**
	 * Description：修改密码
	 * @param account 待修改信息的帐号
	 * @param password 新密码
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean passwordEdit(String account,String password);//修改密码
	
	
	/**
	 * Description：修改电话号码
	 * @param account 待修改信息的帐号
	 * @param phonenumber 新手机号码
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean phonenumberEdit(String account,String phonenumber);//修改联系电话
	
	
	/**
	 * Description：获取当前个人信息，用于控制台显示
	 * @param account 当前管理员帐号
	 * @return CollegeInfo 返回一个管理员对象
	 * @data 2019年12月27日
	 */
	CollegeInfo getInfo(String account);
	
	
	/**
	 * Description：修改所属学院 -不开放
	 * @param account
	 * @param other
	 * @return
	 * @return boolean
	 * @data 2019年12月17日
	 */
	boolean otherEdit(String account,String other);
	
}
