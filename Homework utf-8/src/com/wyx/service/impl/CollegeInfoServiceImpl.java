package com.wyx.service.impl;

import java.util.ArrayList;

import com.wyx.dao.ManageCollegeDao;
import com.wyx.dao.impl.ManageCollegeDaoImpl;
import com.wyx.module.CollegeInfo;
import com.wyx.service.CollegeInfoService;

public class CollegeInfoServiceImpl implements CollegeInfoService{

	ManageCollegeDao collegeInfoDao = new ManageCollegeDaoImpl();
	
	@Override
	public ArrayList<CollegeInfo> showCollegeList() {
		return collegeInfoDao.showCollegeList();
	}
	
	@Override
	public boolean addCollegeInfo(CollegeInfo info) {
		return collegeInfoDao.addCollegeInfo(info);
	}

	@Override
	public CollegeInfo searchCollegeInfo(CollegeInfo info) {
		return collegeInfoDao.searchCollegeInfo(info);
	}

	@Override
	public boolean editCollegeInfo(CollegeInfo info,String num,String newInfo) {
		return collegeInfoDao.editCollegeInfo(info,num,newInfo);
	}

	@Override
	public boolean deleteCollegeInfo(CollegeInfo info) {
		return collegeInfoDao.deleteCollegeInfo(info);
	}

	@Override
	public boolean isCollegeInfoExit(CollegeInfo info) {
		return collegeInfoDao.isCollegeInfoExit(info);
	}
	
}
