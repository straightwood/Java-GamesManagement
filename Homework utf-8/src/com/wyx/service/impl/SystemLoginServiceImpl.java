package com.wyx.service.impl;

import com.wyx.module.SystemInfo;
import com.wyx.dao.SystemInfoDao;
import com.wyx.dao.impl.SystemInfoDaoImpl;
import com.wyx.service.SystemLoginService;

public class SystemLoginServiceImpl implements SystemLoginService{
	
	private SystemInfoDao systemInfoDao = new SystemInfoDaoImpl();

	/**
	 *@description 注册新用户
	 */
	@Override
	public void addSystemInfo(SystemInfo info) {
		systemInfoDao.addSystemInfo(info);
	}

	/**
	 *@return 
	 * @description 用户登录
	 */
	@Override
	public boolean loginSystem(SystemInfo info) {
		return systemInfoDao.loginSystem(info);
	}
	
	/**
	 *@description 添加时验重
	 */
	@Override
	public boolean isSystemInfoExist(SystemInfo info) {
		return systemInfoDao.isSystemInfoExist(info);
	}

	
}

