package com.wyx.controller;

import java.util.Scanner;

import com.wyx.MainUI;
import com.wyx.module.CollegeInfo;
import com.wyx.service.CollegeLoginService;
import com.wyx.service.impl.CollegeLoginServiceImpl;


/**
 * Class Name:CollegeLoginUI.java
 * 
 * @Description 学院管理员登录界面
 * @author GPZoe
 * @since 2019年12月18日
 * @version 3.0 关闭注册接口
 */
public class CollegeLoginUI {
	private static final CollegeLoginService collegeLogin = new CollegeLoginServiceImpl();
	private static CollegeInfo info= new CollegeInfo();
	
	private static final Scanner input=new Scanner(System.in);
	
	/**
	 * @Description 登录页面菜单
	 */
	public static void showMenu() {

        System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
    	System.out.println("	1.登录");
    	//System.out.println("	2.注册 ");
    	System.out.println("----------------------------------");
    	System.out.print("输入操作：");
    	
    	switch(input.next()) {
    	case "main": 
			MainUI.mainMenu();break;
		case "exit": 
			MainUI.mainMenu();break;
		case "1": 
			loginUI();break;
//		case "2": 				//学院管理员无法进行新用户注册
//			registUI();break;
		default:
			System.err.println("请输入正确操作！ ");
			showMenu();
    	}
	}

	/**
	 * @Description 登录功能 匹配账号密码
	 */
	public static void loginUI() {
		while(true) {
			System.out.println("\n\n\n");
			System.out.println("当前位置 > 学院管理员 > 登录");
			System.out.println("	》main.返回开始菜单 ");
			System.out.println("	》exit.返回上一层 ");
			System.out.println("----------------------------------");
            System.out.print("请输入用户名：（2018）");
            info.setAccount(input.next());
            if("exit".equals(info.getAccount())) {
    			showMenu();
    			break;
    		}else if ("main".equals(info.getAccount())) {
    			MainUI.mainMenu();
    			break;
    		}else {
    			System.out.print("请输入密码：（2018）");
                info.setPassword(input.next());
                System.out.println("----------------------------------");
                if(collegeLogin.isCollegeInfoExist(info)) {
                	if(collegeLogin.loginCollege(info)) {
                		System.out.println("登陆成功！");
                		System.err.println("注：只能操作本学院信息！");
                		CollegeFunctionsUI.showMenu(info.getAccount());
                		break;
                	}
                	else {
                		System.err.println("密码错误！");
                	}
    	    	}else {
    	    		System.err.println("用户名不存在！");
    	    	}
    		}
		}
	}
	
	/**
	 * @Description 注册
	 * @Note 不开放
	 */
	private static void registUI() {
		while(true) {
			System.out.println("\n\n\n");
			System.out.println("当前位置 > 学院管理员 > 登录");
			System.out.println("	》main.返回开始菜单 ");
			System.out.println("	》exit.返回上一层 ");
			System.out.println("----------------------------------");
			
            System.out.print("请输入注册用户名：");
            info.setAccount(input.next());
            if("exit".equals(info.getAccount())) {
    			showMenu();
    			break;
    		}else if ("main".equals(info.getAccount())) {
    			MainUI.mainMenu();
    			break;
    		}else {
    			System.out.print("请设置密码：");
                info.setPassword(input.next());
                System.out.println("----------------------------------");
                if(!collegeLogin.isCollegeInfoExist(info)) {
                	collegeLogin.addCollegeInfo(info);
    	    		System.out.println("注册成功！");
    	    		loginUI();
    	    		break;
    	    	}else {
    	    		System.err.println("用户名已存在！");
    	    	}
    		}
            
		}
		
	}
	
}
