package com.wyx.service.impl;

import com.wyx.dao.SystemInfoDao;
import com.wyx.dao.impl.SystemInfoDaoImpl;
import com.wyx.module.SystemInfo;
import com.wyx.service.SystemEditService;

public class SystemEditServiceImpl implements SystemEditService{
	private SystemInfoDao systemInfoDao = new SystemInfoDaoImpl();
	
	@Override
	public boolean passwordEdit(String account,String password) {
		return systemInfoDao.passwordEdit(account,password);
	}

	@Override
	public boolean phonenumberEdit(String account,String phonenumber) {
		return systemInfoDao.phonenumberEdit(account,phonenumber);
	}

	@Override
	public boolean otherEdit(String account,String other) {
		return systemInfoDao.otherEdit(account,other);
	}

	@Override
	public SystemInfo getInfo(String account) {
		return systemInfoDao.getInfo(account);
	}
}
