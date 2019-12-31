package com.wyx.controller;

import java.util.List;
import java.util.Scanner;

import com.wyx.MainUI;
import com.wyx.module.CollegeSort;
import com.wyx.module.EventSort;
import com.wyx.module.StudentInfo;
import com.wyx.service.AthleteInfoService;
import com.wyx.service.SearchEventsService;
import com.wyx.service.impl.AthleteInfoServiceImpl;
import com.wyx.service.impl.SearchEventsServiceImpl;

/**
 * Class Name:SortManageUI.java 系统管理员赛事管理页面
 * 
 * @Description 系统管理员的赛事管理与查询页面，包括登记成绩、根据项目查询、根据学院查询、查询个人成绩
 * @author GPZoe
 * @since 2019年12月16日
 * @version 1.0 
 */
public class SortManageUI {
	
	private static final SearchEventsService athlete = new SearchEventsServiceImpl();
	private static final AthleteInfoService athlete1 = new AthleteInfoServiceImpl();
	private static final Scanner input=new Scanner(System.in);
	
	public static void showMenu(String account) {

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员> 赛事管理与查询");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
		System.out.println("	1.登记比赛成绩");
    	System.out.println("	2.根据项目查询");
    	System.out.println("	3.根据学院查询 ");
    	System.out.println("	4.查询个人成绩 ");
    	System.out.println("----------------------------------");
		System.out.print("请输入：");

    	switch(input.next()) {
    	case "main": 
			MainUI.mainMenu();break;
		case "exit": 
			SystemFunctionsUI.showMenu(account);break;
		case "1": 
			manageScore(account);break;
		case "2": 
			eventSearch(account);break;
		case "3": 
			collegeSearch(account);break;
		case "4": 
			searchAthleteInfo(account);break;
		default:
			System.err.println("请输入正确操作！");
			showMenu(account);
    	}
	}
	
	/**
	 * @param account
	 * @Description 登记成绩. 按项目登记：输入待登记项目，按条显示参赛个人信息，操作者根据条目信息输入比赛名次
	 */
	public static void manageScore(String account) {

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员>  赛事管理与查询 > 登记成绩");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入待登记项目名：（比如：男子跳远）");
		String info = input.next();
		if("exit".equals(info)) {
			showMenu(account);
		}else if ("main".equals(info)) {
			MainUI.mainMenu();
		}else {
			List<EventSort> list = athlete.eventSearch(info);
			if(list==null) {
				System.err.println("没有人报名此项目！");
			}else {
				for (EventSort event :list) {
					System.out.println(event.toString());
					System.out.print("请输入名次：(数字)");
					String score = input.next();
					athlete.registScore(info,event.getId(),score);//传入项目名  运动员id  登记成绩
				}
				System.out.println("登记成功！");
			}
		}
		
		manageScore(account);
		
	}
	
	/**
	 * @param account
	 * @Description 根据项目查询
	 */
	public static void eventSearch(String account) {
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员>  赛事管理与查询 > 根据项目查询");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入项目名：（比如：男子跳远）");
		
		String info = input.next();
		if("exit".equals(info)) {
			showMenu(account);
		}else if ("main".equals(info)) {
			MainUI.mainMenu();
		}else {			
			System.out.println("----------------------------------");
			List<EventSort> list = athlete.eventSearch(info);
			if(list==null || list.size()==0) {
				System.err.println("没有相关信息！");
			}else {
				for(EventSort s: list){
					System.out.println(s.toString());
				}
			}	
		}
		eventSearch(account);
	}
	
	/**
	 * @param account
	 * @Description 根据学院查询比赛成绩. 输入学院返回该学院所有报名信息
	 * @version 2.0 改变所用的hashmap
	 */
	public static void collegeSearch(String account) {

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员>  赛事管理与查询 > 学院成绩表");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入查询学院：（比如：医学院）");
		String info = input.next();
		if("exit".equals(info)) {
			showMenu(account);
		}else if ("main".equals(info)) {
			MainUI.mainMenu();
		}else{			
			System.out.println("----------------------------------");
			System.out.println("学号	     姓名	       学院	          参赛项目	名次");
			List<CollegeSort> list = athlete.collegeSearchByInput(info);
			if(list!=null && list.size()!=0) {
				for(CollegeSort s: list){
					System.out.println(s.toString());
				}
			}else {
				System.err.println("没有相关信息！");
			}
		}
		collegeSearch(account);
	}
	
	/**
	 * @param account
	 * @Description 查询个人比赛成绩. 系统管理员可查询所有人的报名信息
	 */
	public static void searchAthleteInfo(String account) {
		StudentInfo studentInfo = new StudentInfo();
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员 > 赛事管理与查询 > 查询运动员比赛信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入查询学号：（比如：2017001）");
		studentInfo.setId(input.next());
		System.out.println("----------------------------------");
		if("exit".equals(studentInfo.getId())) {
			showMenu(account);
		}else if ("main".equals(studentInfo.getId())) {
			MainUI.mainMenu();
		}else {
			if(athlete1.isAthleteInfoExit(studentInfo)) {
				List<StudentInfo> getInfo = athlete1.searchAthleteInfoBySystem(studentInfo);
				if(getInfo!=null && getInfo.size()!=0) {
					for(StudentInfo s :getInfo) {
						System.out.println(s.toString());
					}
				}else {
		    		System.err.println("信息不存在！");
		    	}
	    	}else {
	    		System.err.println("信息不存在！");
	    	}
		}
		searchAthleteInfo(account);
	}
}
