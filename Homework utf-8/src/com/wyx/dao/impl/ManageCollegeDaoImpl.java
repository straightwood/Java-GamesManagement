package com.wyx.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.wyx.dao.ManageCollegeDao;
import com.wyx.module.CollegeInfo;
import com.wyx.util.CommonNumber;
import com.wyx.util.Data;

public class ManageCollegeDaoImpl implements ManageCollegeDao{
	
	public static Map<String, CollegeInfo> collegeData = Data.collegeData;
	
	@Override
	public ArrayList<CollegeInfo> showCollegeList() {
		ArrayList<CollegeInfo> list = new ArrayList<CollegeInfo>();
		Collection<CollegeInfo> collection = collegeData.values();
		
		for(CollegeInfo s : collection) {
			list.add(s);
		}
		return list;
	}
	
	@Override
	public boolean addCollegeInfo(CollegeInfo info) {
		collegeData.put(info.getAccount(),info);
		return true;
	}

	@Override
	public CollegeInfo searchCollegeInfo(CollegeInfo info) {
		return collegeData.get(info.getAccount());
	}

	@Override
	public boolean editCollegeInfo(CollegeInfo info, String num, String newInfo) {
		CollegeInfo s = collegeData.get(info.getAccount());
		if(num.equals(CommonNumber.MODIFY_PASSWORD)) {
			s.setPassword(newInfo);
			System.out.print(s.getPassword());
			return true;
		}
		else if(num.equals(CommonNumber.MODIFY_PHONENUMBER)) {
			s.setPhonenumber(newInfo);
			return true;
		}
		else if(num.equals(CommonNumber.MODIFY_OTHER)){
			s.setOther(newInfo);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteCollegeInfo(CollegeInfo info) {
		collegeData.remove(info.getAccount());
		return true;
	}

	@Override
	public boolean isCollegeInfoExit(CollegeInfo info) {
		return collegeData.get(info.getAccount()) != null;
	}

}
