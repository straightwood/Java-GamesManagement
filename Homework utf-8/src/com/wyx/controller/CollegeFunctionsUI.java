package com.wyx.controller;

import java.util.Scanner;

import com.wyx.MainUI;


/**
 * Class Name:CollegeFunctionsUI.java
 * 
 * @Description 学院管理员功能列表界面
 * @author GPZoe
 * @since 2019年12月27日
 * @version 2.0 改变样式 提示输入错误信息 
 */
public class CollegeFunctionsUI {
	private static final Scanner input=new Scanner(System.in);
	
	public static void showMenu(String account) {

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 功能列表");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
    	System.out.println("	1.修改个人信息");
    	System.out.println("	2.运动员报名信息管理 ");
    	System.out.println("	3.赛事查询 ");
    	System.out.println("----------------------------------");
		System.out.println("请输入：");

    	switch(input.next()) {
    	case "main": 
			MainUI.mainMenu();break;
		case "exit": 
			CollegeLoginUI.loginUI();break;
		case "1": 
			CollegeEditUI.showMenu(account);break;
		case "2": 
			CollegeAthleteInfoManageUI.showMenu(account);break;
		case "3": 
			SearchEventsUI.showMenu(account);break;
		default:
			System.err.println("请输入正确操作！");
			showMenu(account);
    	}
	}

}
