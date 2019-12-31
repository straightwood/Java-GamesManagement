package com.wyx.service.impl;

import com.wyx.module.CollegeInfo;
import com.wyx.dao.CollegeInfoDao;
import com.wyx.dao.impl.CollegeInfoDaoImpl;
import com.wyx.service.CollegeLoginService;

public class CollegeLoginServiceImpl implements CollegeLoginService{
	
	private CollegeInfoDao collegeInfoDao = new CollegeInfoDaoImpl();

	/**
	 *@description 注册新用户
	 */
	@Override
	public void addCollegeInfo(CollegeInfo info) {
		collegeInfoDao.addCollegeInfo(info);
	}

	/**
	 *@return 
	 * @description 用户登录
	 */
	@Override
	public boolean loginCollege(CollegeInfo info) {
		return collegeInfoDao.loginCollege(info);
	}
	
	/**
	 *@description 添加时验重
	 */
	@Override
	public boolean isCollegeInfoExist(CollegeInfo info) {
		return collegeInfoDao.isCollegeInfoExist(info);
	}

	
}
