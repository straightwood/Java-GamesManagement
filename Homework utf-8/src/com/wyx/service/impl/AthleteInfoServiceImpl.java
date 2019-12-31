package com.wyx.service.impl;

import java.util.List;

import com.wyx.dao.AthleteInfoDao;
import com.wyx.dao.impl.AthleteInfoDaoImpl;
import com.wyx.module.CollegeSort;
import com.wyx.module.StudentInfo;
import com.wyx.service.AthleteInfoService;

public class AthleteInfoServiceImpl implements AthleteInfoService{
		
	AthleteInfoDao athleteInfoDao = new AthleteInfoDaoImpl();
	

	@Override
	public List<CollegeSort> showAthleteList(String account) {
		return athleteInfoDao.showAthleteList(account);
	}
	
	@Override
	public boolean addAthleteInfo(StudentInfo info,String account) {
		return athleteInfoDao.addAthleteInfo(info,account);
	}

	@Override
	public List<StudentInfo> searchAthleteInfo(StudentInfo info,String account) {
		return athleteInfoDao.searchAthleteInfo(info,account);
	}
	
	@Override
	public List<StudentInfo> searchAthleteInfoBySystem(StudentInfo info) {
		return athleteInfoDao.searchAthleteInfoBySystem(info);
	}

	@Override
	public boolean editAthleteInfo(StudentInfo info,String flag,String num,String newInfo) {
		return athleteInfoDao.editAthleteInfo(info,flag,num,newInfo);
	}

	@Override
	public boolean deleteAthleteInfo(StudentInfo info,String flag) {
		return athleteInfoDao.deleteAthleteInfo(info,flag);
	}

	@Override
	public boolean isAthleteInfoExit(StudentInfo info) {
		return athleteInfoDao.isAthleteInfoExit(info);
	}


}
