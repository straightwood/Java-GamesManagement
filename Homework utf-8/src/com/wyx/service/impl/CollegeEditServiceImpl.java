package com.wyx.service.impl;

import com.wyx.dao.CollegeInfoDao;
import com.wyx.dao.impl.CollegeInfoDaoImpl;
import com.wyx.module.CollegeInfo;
import com.wyx.service.CollegeEditService;

public class CollegeEditServiceImpl implements CollegeEditService{
	
	private CollegeInfoDao collegeInfoDao = new CollegeInfoDaoImpl();
	
	@Override
	public boolean passwordEdit(String account,String password) {
		return collegeInfoDao.passwordEdit(account,password);
	}

	@Override
	public boolean phonenumberEdit(String account,String phonenumber) {
		return collegeInfoDao.phonenumberEdit(account,phonenumber);
	}

	@Override
	public CollegeInfo getInfo(String account) {
		return collegeInfoDao.getInfo(account);
	}

//	@Override
//	public boolean otherEdit(String account,String other) {
//		return collegeInfoDao.otherEdit(account,other);
//	}

}
