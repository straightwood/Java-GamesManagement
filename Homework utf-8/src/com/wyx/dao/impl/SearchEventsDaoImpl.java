package com.wyx.dao.impl;

import java.util.List;
import java.util.Map;

import com.wyx.dao.SearchEventsDao;
import com.wyx.module.CollegeInfo;
import com.wyx.module.CollegeSort;
import com.wyx.module.EventSort;
import com.wyx.module.StudentInfo;
import com.wyx.util.Data;

public class SearchEventsDaoImpl implements SearchEventsDao{
	
	public static Map<String, List<StudentInfo>> athleteData = Data.studentData;
	public static Map<String, List<EventSort>> eventsortData = Data.eventSortData;
	public static Map<String, List<CollegeSort>> collegesortData = Data.collegeSortData;
	public static Map<String,CollegeInfo> collegeData = Data.collegeData;
	
	@Override
	public List<EventSort> eventSearch(String info) {
		return eventsortData.get(info);
	}

	@Override
	public List<CollegeSort> collegeSearch(String info) {
		return collegesortData.get(collegeData.get(info).getOther());
	}
	
	@Override
	public List<CollegeSort> collegeSearchByInput(String info) {
		return collegesortData.get(info);
	}

	@Override
	public List<StudentInfo> accountSearch(String info) {
		return athleteData.get(info);
	}

	@Override
	public boolean registScore(String info,String id,String score) {
		List<EventSort> list = eventsortData.get(info);
		for(EventSort event :list) {
			if(event.getId().equals(id)) {
				event.setScore(score);
			}
		}
		return false;
	}

}
