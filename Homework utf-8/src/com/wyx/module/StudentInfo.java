package com.wyx.module;

/**
 * Class Name:StudentInfo.java
 * 
 * @Description 学生信息类
 * @author GPZoe
 * @data 2019年12月29日
 * @version 2.0 抽出父类
 */
public class StudentInfo extends Sort{
	
	/**
	 * 成绩
	 */
	private String grade;

	/**
	 * 构造方法
	 */
	public StudentInfo() {
	}
	
	/**
	 * 构造方法
	 * @param string 学生学号
	 * @param string2 学生姓名
	 * @param string3 所属学院
	 * @param string4 参赛项目
	 * @param string5 比赛成绩
	 */
	public StudentInfo(String string, String string2, String string3,String string4,String string5) {
		setId(string);
		setName(string2);
		setCollege(string3);
		setEvent(string4);
		setGrade(string5);
	}
	
	/**
	 * @toString重写
	 */
	public String toString() {
		return getId()+"   "+getName()+"   "+getCollege()+"   "+getEvent()+"   "+getGrade();
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
