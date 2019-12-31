package com.wyx;

import java.util.Scanner;

import com.wyx.controller.CollegeLoginUI;
import com.wyx.controller.SystemLoginUI;

/**
 * Class Name:MainUI.java
 * 
 * @Description 系统主页面
 * @author GPZoe
 * @since 2019年12月17日
 * @version 2.0 修改样式
 */
public class MainUI {
	private static Scanner input=new Scanner(System.in);
	
	/**
	 *  @Description 主页面菜单
	 */
	public static void mainMenu() {

		System.out.println("\n\n========欢迎进入运动会管理系统！========");
		System.out.println("请选择用户类型：");
		System.out.println("	1.学院管理员 (用户名2018，密码2018)");
		System.out.println("	2.系统管理员 (用户名admin，密码admin)");
		System.out.println("	3.退出");
		System.out.print("请输入：");
		switch(input.next()) {
		case "1": 
			CollegeLoginUI.showMenu();
			break;
		case "2": 
			SystemLoginUI.showMenu();
			break;
		case "3":
			System.out.println("=====================================");
			System.out.println("		感谢使用");
			System.out.println("=====================================");
			break;
		default:
			mainMenu();
			break;
    	}
	}
	
	public static void main(String[] args) {
		MainUI.mainMenu();
	}
}
