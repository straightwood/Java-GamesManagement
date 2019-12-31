package com.wyx.module;
/** 

* @author GPZoe
* @data 2019年12月29日
* @version 1.0
* description 运动员信息类基类
*/
public class Sort {
	/**
	 * 学生学号
	 */
	public String id;
	
	/**
	 * 学生姓名 
	 */
	public String name;
	
	/**
	 * 学生所属学院
	 */
	public String college;
	
	/**
	 * 成绩
	 */
	public String score;
	
	/**
	 * 参赛项目
	 */
	public String event;
	
	public String toString() {
		return getId()+"   "+getName()+"   "+getCollege()+"   "+getEvent();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}
