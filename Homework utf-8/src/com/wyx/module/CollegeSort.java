package com.wyx.module;

/**
 * Class Name:CollegeSort.java
 * 
 * @Description 用于按学院划分的个人信息类
 * @author GPZoe
 * @data 2019年12月16日
 * @version 2.0 抽出父类
 */
public class CollegeSort extends Sort{
	
	/**
	 * 构造方法
	 */
	public CollegeSort() {
		
	}
	
	/**
	 * 构造方法
	 * @param string 学生学号
	 * @param string2 学生姓名
	 * @param string3 所属学院
	 * @param string4 参赛项目
	 * @param string5 比赛成绩
	 */
	public CollegeSort(String string,String string2,String string3,String string4,String string5) {
		setId(string);
		setName(string2);
		setCollege(string3);
		setEvent(string4);
		setScore(string5);
	}
	
	/**
	 * toString - 带成绩
	 */
	public String toString() {
		return getId()+"   "+getName()+"   "+getCollege()+"   "+getEvent()+"   "+getScore();
	}
	
	/**
	 * toString - 不带成绩
	 */
	public String toString1() {
		return getId()+"   "+getName()+"   "+getCollege()+"   "+getEvent();
	}
	
}
