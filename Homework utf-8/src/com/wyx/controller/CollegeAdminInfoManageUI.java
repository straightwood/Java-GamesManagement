package com.wyx.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.wyx.MainUI;
import com.wyx.module.CollegeInfo;
import com.wyx.service.CollegeInfoService;
import com.wyx.service.impl.CollegeInfoServiceImpl;



/**
 * Class Name:CollegeAdminInfoManageUI.java
 * 
 * @Description 系统管理员对各学院管理员的管理界面(UI)，包含管理功能菜单、显示功能列表、增删改查学院管理员信息的控制台界面.
 * 
 * @author GPZoe
 * @since 2019年12月17日
 * @version 2.0 总体改变了显示样式
 */


public class CollegeAdminInfoManageUI {
	private static final CollegeInfoService college = new CollegeInfoServiceImpl();
	private static final Scanner input = new Scanner(System.in);
	
	/**
	 * @param account 传入系统管理员帐号
	 * @Description 系统管理员功能列表，通过输入选择操作
	 */
	public static void showMenu(String account) {
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员 > 学院管理员信息管理");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
    	System.out.println("	1.查看学院管理员列表");
    	System.out.println("	2.添加学院管理员信息 ");
    	System.out.println("	3.查询学院管理员信息 ");
    	System.out.println("	4.修改学院管理员信息 ");
    	System.out.println("	5.删除学院管理员信息 ");
    	System.out.println("----------------------------------");
    	System.out.print("输入操作：");
    	
    	switch(input.next()) {
		case "main": 
			MainUI.mainMenu();break;
		case "exit": 
			SystemFunctionsUI.showMenu(account);break;
		case "1": 
			showCollegeList(account);break;
		case "2": 
			addCollegeInfo(account);break;
		case "3": 
			searchCollegeInfo(account);break;
		case "4": 
			editCollegeInfo(account);break;
		case "5": 
			deleteCollegeInfo(account);break;
		default:
			showMenu(account);
    	}
	}
	

	/**
	 * @param account
	 * @Description 显示学院管理员列表
	 */
	public static void showCollegeList(String account) {
		ArrayList<CollegeInfo> list = college.showCollegeList();
		if(list!=null && list.size()!=0) {
			System.out.println("用户名	联系方式		所属学院");
			for(CollegeInfo s: list){
				System.out.println(s.toString());
			}
		}
		showMenu(account);
	}
	
	/**
	 * @param account
	 * @Description 添加学院管理员信息
	 */
	public static void addCollegeInfo(String account) {
		CollegeInfo collegeInfo = new CollegeInfo();

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员 > 添加学院管理员信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		
		System.out.print("请输入学院管理员用户名：");
		collegeInfo.setAccount(input.next());
		if("exit".equals(collegeInfo.getAccount())) {
			showMenu(account);
		}else if ("main".equals(collegeInfo.getAccount())) {
			MainUI.mainMenu();
		}else {
			System.out.print("请输入学院管理员密码：");
			collegeInfo.setPassword(input.next());
			System.out.print("请输入联系方式：");
			collegeInfo.setPhonenumber(input.next());
			System.out.print("请输入所属学院：");
			collegeInfo.setOther(input.next());
			System.out.println("----------------------------------");
			if(!college.isCollegeInfoExit(collegeInfo)) {
				college.addCollegeInfo(collegeInfo);
	    		System.out.println("添加成功！");
	    	}else {
	    		System.err.println("信息已存在！");
	    	}
			addCollegeInfo(account);
		}
	}
	
	
	/**
	 * @param account
	 * @Description 查询学院管理员信息
	 */
	public static void searchCollegeInfo(String account) {
		CollegeInfo collegeInfo = new CollegeInfo();
		CollegeInfo getInfo = new CollegeInfo();

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员 > 查询学院管理员信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入待查询的学院管理员用户名：");
		collegeInfo.setAccount(input.next());
		System.out.println("----------------------------------");
		if("exit".equals(collegeInfo.getAccount())) {
			showMenu(account);
		}else if ("main".equals(collegeInfo.getAccount())) {
			MainUI.mainMenu();
		}else {
			if(college.isCollegeInfoExit(collegeInfo)) {
				getInfo = college.searchCollegeInfo(collegeInfo);
	    		System.out.println("用户名： "+getInfo.getAccount());
	    		System.out.println("密码： "+getInfo.getPassword());
	    		System.out.println("联系方式： "+getInfo.getPhonenumber());
	    		System.out.println("所属学院： "+getInfo.getOther());
	    	}else {
	    		System.err.println("信息不存在！");
	    	}
			searchCollegeInfo(account);
		}
	}
	
	
	/**
	 * @param account
	 * @Description 编辑学院管理员信息
	 */
	public static void editCollegeInfo(String account) {
		CollegeInfo collegeInfo = new CollegeInfo();
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员 > 修改学院管理员信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("------------------------------------------");
		System.out.print("请输入待修改的学院管理员用户名：");
		collegeInfo.setAccount(input.next());
		System.out.println("------------------------------------------");
		if("exit".equals(collegeInfo.getAccount())) {
			showMenu(account);
		}else if ("main".equals(collegeInfo.getAccount())) {
			MainUI.mainMenu();
		}else {
			System.out.println("请选择编辑项：");
	    	System.out.println("1. 密码");
	    	System.out.println("2. 联系方式");
	    	System.out.println("3. 所属学院");
	    	String num = input.next();
	    	System.out.print("请输入更新信息：");
	    	String newInfo = input.next();
			
			if(college.isCollegeInfoExit(collegeInfo)) {
				if(college.editCollegeInfo(collegeInfo,num,newInfo)) {
					System.out.println("修改成功！");
				}else {
					System.err.println("修改失败！");
				}
	    	}else {
	    		System.err.println("信息不存在！");
	    	}
			editCollegeInfo(account);
		}
	}
	
	/**
	 * @param account
	 * @Description 删除学院管理员信息
	 */
	public static void deleteCollegeInfo(String account) {
		CollegeInfo collegeInfo = new CollegeInfo();
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员 > 删除学院管理员信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入待删除的学院管理员用户名：");
		collegeInfo.setAccount(input.next());
		if(collegeInfo.getAccount().equals("exit")) {
			showMenu(account);
		}else if (collegeInfo.getAccount().equals("main")) {
			MainUI.mainMenu();
		}else {
			if(college.isCollegeInfoExit(collegeInfo)) {
				if(college.deleteCollegeInfo(collegeInfo)) {
					System.out.println("删除成功！");
				}else {
					System.err.println("删除失败！");
				}
	    	}else {
	    		System.err.println("信息不存在！");
		    	}
				deleteCollegeInfo(account);
			}
		}
	}

