package com.wyx.dao.impl;

import java.util.Map;

import com.wyx.dao.SystemInfoDao;
import com.wyx.module.SystemInfo;
import com.wyx.util.Data;

/**
 * @author GPZoe
 * @description 学院管理员登录-Dao数据交互
 * @version 1.0
 */
public class SystemInfoDaoImpl implements SystemInfoDao{
	
	public static Map<String,SystemInfo> systemData = Data.systemData;
	/**
	 * 添加新学院管理员
	 * 问题：已有ID覆盖？
	 */
	@Override
	public void addSystemInfo(SystemInfo info) {
		systemData.put(info.getAccount(), info);
	}
	
	/**
	 * 登录
	 */
	@Override
	public boolean loginSystem(SystemInfo info) {
		SystemInfo s = systemData.get(info.getAccount());
		return info.getPassword().equals(s.getPassword()) ? true : false;
	}
	
	/**
	 * 判断管理员用户是否存在
	 * @return 存在返回  true
	 */
	@Override
	public boolean isSystemInfoExist(SystemInfo info) {
		return systemData.get(info.getAccount()) != null;
	}

	/**
	 * 修改密码
	 */
	@Override
	public boolean passwordEdit(String account,String password) {
		systemData.get(account).setPassword(password);
		return true;
	}

	/**
	 * 修改联系电话
	 */
	@Override
	public boolean phonenumberEdit(String account,String phonenumber) {
		systemData.get(account).setPhonenumber(phonenumber);
		return true;
	}

	/**
	 * 修改其他信息
	 */
	@Override
	public boolean otherEdit(String account,String other) {
		systemData.get(account).setOther(other);
		return true;
	}

	@Override
	public SystemInfo getInfo(String account) {
		return systemData.get(account);
	}

	

	
}