package com.wyx.service;

import java.util.List;

import com.wyx.module.CollegeSort;
import com.wyx.module.StudentInfo;

/**
 * Class Name:AthleteInfoService.java
 * 
 * @Description 学院管理员模块 运动员报名信息管理
 * @author GPZoe
 * @since 2019年12月17日
 * @version 1.0 
 */
public interface AthleteInfoService {
	/**
	 * Description：显示报名信息列表
	 * @param account 传入学院管理员帐号 匹配学院                                             
	 * @return List<CollegeSort>
	 * @data 2019年12月17日
	 */
	List<CollegeSort> showAthleteList(String account);
	
	
	/**
	 * Description：添加运动员报名信息
	 * @param info 传入新增的学生对象
	 * @param account 传入管理员帐号
	 * @return boolean 标志是否添加成功
	 * @data 2019年12月17日
	 */
	boolean addAthleteInfo(StudentInfo info,String account);
	
	

	/**
	 * Description：查询某运动员报名信息 - 学院管理员只能查询本学院信息
	 * @param info 传入新增的学生对象 - 匹配学号
	 * @param account 传入管理员帐号 - 匹配本学院信息
	 * @return List<StudentInfo>
	 * @data 2019年12月17日
	 */
	List<StudentInfo> searchAthleteInfo(StudentInfo info,String account);
	
	
	/**
	 * Description：查询某运动员报名信息 - 系统管理员可查询所有报名信息
	 * @param info 传入新增的学生对象 - 匹配学号
	 * @return List<StudentInfo>
	 * @data 2019年12月17日
	 */
	List<StudentInfo> searchAthleteInfoBySystem(StudentInfo info);
	
	
	/**
	 * Description：编辑报名信息
	 * @param info 待修改的信息对象 - 匹配学号
	 * @param flag 若查询到的信息为多项的列表 标记待修改的条目序号
	 * @param num 标记操作选项（修改姓名or...
	 * @param newInfo 更新的新信息对象
	 * @return boolean 标记是否修改成功
	 * @data 2019年12月17日
	 */
	boolean editAthleteInfo(StudentInfo info,String flag,String num,String newInfo);
	
	
	/**
	 * Description：删除报名信息
	 * @param info 待删除的学生对象 - 匹配学号
	 * @param flag 若查询到的信息为多项的列表 标记待删除的条目序号
	 * @return boolean 标记是否删除成功
	 * @data 2019年12月17日
	 */
	boolean deleteAthleteInfo(StudentInfo info,String flag);
	
	
	/**
	 * Description：验证查询信息是否存在
	 * @param info 待查询的信息对象 - 匹配学号
	 * @return boolean 标记是否存在
	 * @data 2019年12月17日
	 */
	boolean isAthleteInfoExit(StudentInfo info);
}
