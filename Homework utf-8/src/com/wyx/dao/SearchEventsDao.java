package com.wyx.dao;

import java.util.List;

import com.wyx.module.CollegeSort;
import com.wyx.module.EventSort;
import com.wyx.module.StudentInfo;

/**
 * Class Name:SearchEventsDao.java
 * 
 * @Description 赛事查询功能
 * @author GPZoe
 * @since 2019年12月18日
 * @version 1.0 
 */
public interface SearchEventsDao {
	
	/**
	 * Description：根据比赛项目查询
	 * @param info 待查询的比赛项目
	 * @return List<EventSort>
	 * @data 2019年12月18日
	 */
	List<EventSort> eventSearch(String info);
	
	
	/**
	 * Description：查询学院报名信息 - 学院管理员模块 - 只能查询该学院
	 * @param info 学院管理员帐号 - 匹配学院信息
	 * @return List<CollegeSort>
	 * @data 2019年12月18日
	 */
	List<CollegeSort> collegeSearch(String info);
	
	
	/**
	 * Description：查询某学院报名信息 - 系统管理员模块 - 可查询所有学院
	 * @param info 待查询学院名
	 * @return List<CollegeSort>
	 * @data 2019年12月18日
	 */
	List<CollegeSort> collegeSearchByInput(String info);
	
	
	/**
	 * Description：查询个人成绩信息 - 系统管理员模块 - 可查询所有个人信息
	 * @param info 待查询对象帐号
	 * @return List<StudentInfo>
	 * @data 2019年12月18日
	 */
	List<StudentInfo> accountSearch(String info);
	
	
	/**
	 * Description：登记成绩
	 * @param info 待登记的项目名
	 * @param id 登记条目的学号
	 * @param score 登记的成绩
	 * @return boolean 标记是否登记成功
	 * @data 2019年12月18日
	 */
	boolean registScore(String info,String id,String score);
}
