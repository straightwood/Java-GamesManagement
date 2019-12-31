package com.wyx.service;

import java.util.ArrayList;

import com.wyx.module.CollegeInfo;

/**
 * Class Name:CollegeInfoService.java
 * 
 * @Description 系统管理员模块  各学院管理员信息管理，列表，增删改查
 * @author GPZoe
 * @since 2019年12月17日
 * @version 1.0 
 */
public interface CollegeInfoService {
	
	
	/**
	 * Description：显示管理员列表
	 * @return ArrayList<CollegeInfo>
	 * @data 2019年12月17日
	 */
	ArrayList<CollegeInfo> showCollegeList();
	
	
	/**
	 * Description：添加学院管理员帐号
	 * @param info 待添加的学院管理员对象
	 * @return boolean
	 * @data 2019年12月17日
	 */
	boolean addCollegeInfo(CollegeInfo info);
	
	
	/**
	 * Description：修改学院管理员信息
	 * @param info 待修改的管理员对象 - 匹配帐号
	 * @param num 修改操作编号
	 * @param newInfo 新信息
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	CollegeInfo searchCollegeInfo(CollegeInfo info);
	
	
	/**
	 * Description：删除学院管理员
	 * @param info 待删除的学院管理员对象 - 匹配帐号
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean editCollegeInfo(CollegeInfo info,String num,String newInfo);
	
	
	/**
	 * Description：删除学院管理员
	 * @param info 待删除的学院管理员对象 - 匹配帐号
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean deleteCollegeInfo(CollegeInfo info);
	
	
	/**
	 * Description：查询该管理员是否存在
	 * @param info 待查询的管理员对象 - 匹配帐号
	 * @return boolean 标记是否存在
	 * @data 2019年12月27日
	 */
	boolean isCollegeInfoExit(CollegeInfo info);
}
