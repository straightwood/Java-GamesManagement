package com.wyx.module;

/**
 * Class Name:EventSort.java
 * 
 * @Description 用于按项目划分的信息类
 * @author GPZoe
 * @data 2019年12月27日
 * @version 2.0 抽出父类
 */
public class EventSort extends Sort{	
	
	/**
	 * 构造方法
	 */
	public EventSort() {
		
	}
	
	/**
	 * 构造方法
	 * @param string 学生学号
	 * @param string2 学生姓名
	 * @param string3 所属学院
	 * @param string4 参赛项目
	 * @param string5 比赛成绩
	 */
	public EventSort(String string,String string2,String string3,String string4,String string5) {
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
	
}
