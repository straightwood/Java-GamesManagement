package com.wyx.service.impl;

import java.util.List;

import com.wyx.dao.SearchEventsDao;
import com.wyx.dao.impl.SearchEventsDaoImpl;
import com.wyx.module.CollegeSort;
import com.wyx.module.EventSort;
import com.wyx.module.StudentInfo;
import com.wyx.service.SearchEventsService;

public class SearchEventsServiceImpl implements SearchEventsService{

	SearchEventsDao searchEventsDao = new SearchEventsDaoImpl();
	
	@Override
	public List<EventSort> eventSearch(String info) {
		return searchEventsDao.eventSearch(info);
	}

	@Override
	public List<CollegeSort> collegeSearch(String info) {
		return searchEventsDao.collegeSearch(info);
	}
	
	public List<CollegeSort> collegeSearchByInput(String info) {
		return searchEventsDao.collegeSearchByInput(info);
	}

	@Override
	public List<StudentInfo> accountSearch(String info) {
		return searchEventsDao.accountSearch(info);
	}

	@Override
	public boolean registScore(String info,String id,String score) {
		return searchEventsDao.registScore(info,id,score);
	}

}
