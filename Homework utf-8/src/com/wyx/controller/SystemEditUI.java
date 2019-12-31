package com.wyx.controller;

import java.util.Scanner;

import com.wyx.module.SystemInfo;
import com.wyx.service.SystemEditService;
import com.wyx.service.impl.SystemEditServiceImpl;

/**
 * Class Name:SystemEditUI.java
 * 
 * @Description 系统管理员的个人信息修改功能
 * @author GPZoe
 * @since 2019年12月18日
 * @version 2.0 增加了显示当前信息功能，方便查看
 */
public class SystemEditUI {
	private static final SystemEditService systemEdit = new SystemEditServiceImpl();
	private static final Scanner input=new Scanner(System.in);
	
	
	/**
	 * @param account 传入系统管理员账号 匹配当前信息
	 * @Description 可修改密码、联系电话。显示当前信息，选择修改项，输入新信息.
	 */
	public static void showMenu(String account) {
		SystemInfo s= systemEdit.getInfo(account);
		
		System.out.println("\n\n\n当前位置 > 系统管理员 > 修改个人信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("【当前信息】");
		System.out.println("用户名（不可修改）： "+s.getAccount());
		System.out.println("密码： "+s.getPassword());
		System.out.println("联系方式： "+s.getPhonenumber());
		System.out.println("备注信息： "+s.getOther());
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
    	System.out.println("	1.修改密码");
    	System.out.println("	2.修改联系电话 ");
    	System.out.println("	3.修改备注信息 ");
    	System.out.println("----------------------------------");
    	System.out.print("请输入：");
    	
    	switch(input.next()) {
		case "exit": 
			SystemFunctionsUI.showMenu(account);break;
		case "1": 
			System.out.print("请输入新密码：");
			String password = input.next();
			if(systemEdit.passwordEdit(account,password)) {
				System.out.println("----------------------------------");
				System.out.println("修改密码成功！");
				showMenu(account);
				break;
			}
			
		case "2": 
			System.out.print("请输入新的联系方式：");
			String phonenumber = input.next();
			if(systemEdit.phonenumberEdit(account,phonenumber)) {
				System.out.println("----------------------------------");
				System.out.println("修改联系方式成功！");
				showMenu(account);
				break;
			}
			
		case "3": 
			System.out.print("请输入其他信息："); //各类备注
			String other = input.next();
			if(systemEdit.otherEdit(account,other)) {
				System.out.println("----------------------------------");
				System.out.println("修改其他信息成功！");
				showMenu(account);
				break;
			}
			
		default:
			System.err.println("请输入正确操作！");
			showMenu(account);
    	}
	}

	
}

