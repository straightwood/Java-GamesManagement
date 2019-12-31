package com.wyx.controller;

import java.util.Scanner;

import com.wyx.MainUI;

/**
 * Class Name:SystemFunctionsUI.java
 * 
 * @Description 系统管理员功能列表
 * @author GPZoe
 * @since 2019年12月27日
 * @version 2.0 提示输入错误信息
 */
public class SystemFunctionsUI {
private static final Scanner input=new Scanner(System.in);
	
	public static void showMenu(String account) {

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 系统管理员 > 功能列表");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
    	System.out.println("	1.修改个人信息");
    	System.out.println("	2.学院管理员信息管理 ");
    	System.out.println("	3.赛事登记与查询 ");
    	System.out.println("----------------------------------");
    	System.out.print("请输入：");

    	switch(input.next()) {
    	case "main": 
			MainUI.mainMenu();break;
		case "exit": 
			SystemLoginUI.loginUI();break;
		case "1": 
			SystemEditUI.showMenu(account);break;
		case "2": 
			CollegeAdminInfoManageUI.showMenu(account);break;
		case "3": 
			SortManageUI.showMenu(account);break;
		default:
			System.err.println("请输入正确操作！");
			showMenu(account);
    	}
	}
}
