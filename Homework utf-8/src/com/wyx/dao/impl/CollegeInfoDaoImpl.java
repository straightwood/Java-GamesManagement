package com.wyx.dao.impl;

import java.util.Map;

import com.wyx.dao.CollegeInfoDao;
import com.wyx.module.CollegeInfo;
import com.wyx.util.Data;

/**
 * @author GPZoe
 * @description 学院管理员登录-Dao数据交互
 * @version 1.0
 */
public class CollegeInfoDaoImpl implements CollegeInfoDao{
	
	public static Map<String,CollegeInfo> collegeData = Data.collegeData;
	/**
	 * 添加新学院管理员
	 * 问题：已有ID覆盖？
	 */
	@Override
	public void addCollegeInfo(CollegeInfo info) {
		collegeData.put(info.getAccount(), info);
	}
	
	/**
	 * 登录
	 */
	@Override
	public boolean loginCollege(CollegeInfo info) {
		CollegeInfo s = collegeData.get(info.getAccount());
		return info.getPassword().equals(s.getPassword()) ? true : false ;
	}
	
	/**
	 * 判断管理员用户是否存在
	 * @return 存在返回  true
	 */
	@Override
	public boolean isCollegeInfoExist(CollegeInfo info) {
		return collegeData.get(info.getAccount()) != null;
	}

	/**
	 * 修改密码
	 */
	@Override
	public boolean passwordEdit(String account,String password) {
		collegeData.get(account).setPassword(password);
		return true;
	}

	/**
	 * 修改联系电话
	 */
	@Override
	public boolean phonenumberEdit(String account,String phonenumber) {
		collegeData.get(account).setPhonenumber(phonenumber); 
		return true;
	}

	@Override
	public CollegeInfo getInfo(String account) {
		return collegeData.get(account);
	}

	/**
	 * 修改学院信息
	 * 设置为不可修改，系统管理员有权修改
	 */
	@Override
	public boolean otherEdit(String account,String other) {
		collegeData.get(account).setOther(other);
		return true;
	}
	
}