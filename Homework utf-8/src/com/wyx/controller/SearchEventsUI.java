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
 * Class Name:SearchEventsUI.java
 *  
 * @Description 学院管理员赛事查询功能. 包括根据项目查询、查本学院成绩表、查询个人成绩.
 * @author GPZoe
 * @since 2019年12月27日
 * @version 1.0 
 */
public class SearchEventsUI {
	private static final SearchEventsService athlete = new SearchEventsServiceImpl();
	private static final AthleteInfoService athlete1 = new AthleteInfoServiceImpl();
	private static final Scanner input=new Scanner(System.in);
	
	/**
	 * @param account 传入管理员帐号 匹配学院信息
	 * @Description 显示赛事查询功能列表
	 */
	public static void showMenu(String account) {

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 赛事查询");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
    	System.out.println("	1.根据项目查询");
    	System.out.println("	2.本学院成绩表 ");
    	System.out.println("	3.查询个人成绩 ");
    	System.out.println("----------------------------------");
		System.out.print("请输入：");

    	switch(input.next()) {
    	case "main": 
			MainUI.mainMenu();break;
		case "exit": 
			CollegeFunctionsUI.showMenu(account);break;
		case "1": 
			eventSearch(account);break;
		case "2": 
			collegeSearch(account);break;
		case "3": 
			searchAthleteInfo(account);break;
		default:
			System.err.println("请输入正确操作！");
			showMenu(account);
    	}
	}
	
	/**
	 * @param account
	 * @Description 按项目查询，输入项目名称，可看到各个学院的该项比赛成绩
	 * @version 3.0 改变所用的hashmap
	 */
	public static void eventSearch(String account) {
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 赛事查询 > 根据项目查询");
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
			if(list!=null && list.size()!=0) {
				for(EventSort s: list){
					System.out.println(s.toString());
				}
			}else {
				System.err.println("没有相关信息！");
			}
			eventSearch(account);
		}
	}
	
	/**
	 * @param account 传入学院管理员帐号 匹配学院信息
	 * @Description 查看本学院成绩表
	 * @version 4.0 改变样式 - 添加表头 - 删除“查询确认” - 改变所用的Hashmap
	 */
	public static void collegeSearch(String account) {
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 赛事查询 > 本学院成绩表");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		List<CollegeSort> list = athlete.collegeSearch(account);
		if(list!=null && list.size()!=0) {
			System.out.println("学号	     姓名	       学院	          参赛项目	比赛名次");
			for(CollegeSort s: list){
				System.out.println(s.toString());
			}
		}else {
			System.err.println("没有相关信息！");
		}
		showMenu(account);
//		collegeSearch(account);
//		System.out.print("确认查询请按1：");
//		String in = input.next();
//		if("exit".equals(in)) {
//			showMenu(account);
//		}else if ("main".equals(in)) {
//			MainUI.mainMenu();
//		}else if (in.equals("1")){			
//			
//		}
	}

	/**
	 * @param account 
	 * @Description 只能查询本学院的个人运动员信息，与管理功能的查询调用同一接口
	 */
	public static void searchAthleteInfo(String account) {
		StudentInfo studentInfo = new StudentInfo();
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 赛事查询  > 查询运动员报名信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入查询学号：（2017001）");
		studentInfo.setId(input.next());
		System.out.println("----------------------------------");
		if("exit".equals(studentInfo.getId())) {
			showMenu(account);
		}else if ("main".equals(studentInfo.getId())) {
			MainUI.mainMenu();
		}else {
			if(athlete1.isAthleteInfoExit(studentInfo)) {
				List<StudentInfo> getInfo = athlete1.searchAthleteInfo(studentInfo,account);
				if(getInfo!=null && getInfo.size()!=0) {
					for(StudentInfo s :getInfo) {
						System.out.println(s.toString());
					}
				}else {
					System.err.println("没有相关信息！");
				}
				
	    	}else {
	    		System.err.println("信息不存在！");
	    	}
			searchAthleteInfo(account);
		}
	}
}
