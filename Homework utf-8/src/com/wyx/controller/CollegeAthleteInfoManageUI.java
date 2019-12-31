package com.wyx.controller;

import java.util.List;
import java.util.Scanner;

import com.wyx.MainUI;
import com.wyx.module.CollegeSort;
import com.wyx.module.StudentInfo;
import com.wyx.service.AthleteInfoService;
import com.wyx.service.impl.AthleteInfoServiceImpl;

/**
 * Class Name:CollegeAthleteInfoManageUI.java
 * 
 * @Description 学院管理员对自己学院报名信息管理界面(UI)，包含管理功能菜单、显示功能列表、增删改查运动员报名信息的控制台界面.  注：本学院管理员只能操作本学院信息.
 * @author GPZoe
 * @since 2019年12月18日
 * @version 3.0 改变样式 改变调用结构
 */
public class CollegeAthleteInfoManageUI {
	private static final AthleteInfoService athlete = new AthleteInfoServiceImpl();
	private static final Scanner input = new Scanner(System.in);
	
	static void showMenu(String account) {
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 运动员报名信息管理");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.println("请选择操作类型：");
    	System.out.println("	1.查看本学院运动员列表");
    	System.out.println("	2.添加运动员信息 ");
    	System.out.println("	3.查询运动员信息 ");
    	System.out.println("	4.修改运动员信息 ");
    	System.out.println("	5.删除运动员信息 ");
    	
    	System.out.println("----------------------------------");
    	System.out.print("输入操作：");
    	
    	switch(input.next()) {
		case "main": 
			MainUI.mainMenu();break;
		case "exit": 
			CollegeFunctionsUI.showMenu(account);break;
		case "1": 
			showAthleteList(account);break;
		case "2": 
			addAthleteInfo(account);break;
		case "3": 
			searchAthleteInfo(account);break;
		case "4": 
			editAthleteInfo(account);break;
		case "5": 
			deleteAthleteInfo(account);break;
		default:
			showMenu(account);
    	}
	}
	
	
	/**
	 * @param account 传入学院管理员帐号 匹配本学院信息
	 * @Description 查看报名信息列表
	 */
	public static void showAthleteList(String account) {
		List<CollegeSort> list = athlete.showAthleteList(account);
		if(list!=null && list.size()!=0) {
			System.out.println("学号	     姓名	       学院	          参赛项目");
			for(CollegeSort s: list){
				System.out.println(s.toString1());
			}
		}
		showMenu(account);
	}
	
	/**
	 * @param account 传入学院管理员帐号 匹配本学院信息
	 * @Description 添加运动员信息. 报名时比赛成绩默认为"未登记". 所属学院默认为管理员所在学院(dao层实现)
	 */
	public static void addAthleteInfo(String account) {
		StudentInfo studentInfo = new StudentInfo();
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 添加运动员报名信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		
		System.out.print("请输入学生学号：");
		studentInfo.setId(input.next());
		if("exit".equals(studentInfo.getId())) {
			showMenu(account);
		}else if ("main".equals(studentInfo.getId())) {
			MainUI.mainMenu();
		}else {
			System.out.print("请输入学生姓名：");
			studentInfo.setName(input.next());
			System.out.print("请输入参赛项目：");
			studentInfo.setEvent(input.next());
			System.out.println("----------------------------------");
			studentInfo.setGrade("未比赛");							//比赛成绩默认为报名时未登记
			if(athlete.addAthleteInfo(studentInfo,account)) {
				System.out.println("添加成功！");
			}else {
				System.err.println("信息已存在！");
			}

			addAthleteInfo(account);
		}
	}
	
	/**
	 * @param account 传入学院管理员帐号 匹配本学院信息
	 * @Description 查询运动员信息. 若返回值为列表时打印列表信息.
	 */
	public static void searchAthleteInfo(String account) {
		StudentInfo studentInfo = new StudentInfo();
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 查询运动员报名信息");
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
			List<StudentInfo> getInfo = athlete.searchAthleteInfo(studentInfo,account);
			if(getInfo!=null && getInfo.size()!=0) {
				for(StudentInfo s :getInfo) {
					System.out.println(s.toString());
				}
	    	}else {
	    		System.err.println("信息不存在！");
	    	}
			searchAthleteInfo(account);
		}
	}
	
	/**
	 * @param account 传入学院管理员帐号 匹配本学院信息
	 * @Description 编辑运动员信息. 可对运动员姓名/参赛项目进行更新，不提供修改学院与成绩功能. 
	 * @Note 修改姓名时若有多条信息则一并修改，修改参赛项目只修改选中条目.
	 */
	public static void editAthleteInfo(String account) {
		StudentInfo studentInfo = new StudentInfo();

		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 修改运动员报名信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("------------------------------------------");
		System.out.print("请输入待修改的运动员学号：（2017001）");
		studentInfo.setId(input.next());
		System.out.println("------------------------------------------");
		if("exit".equals(studentInfo.getId())) {
			showMenu(account);
		}else if ("main".equals(studentInfo.getId())) {
			MainUI.mainMenu();
		}else {
			int mark=1;
			//if(athlete.isAthleteInfoExit(studentInfo)) {
			List<StudentInfo> getInfo = athlete.searchAthleteInfo(studentInfo,account);
			if(getInfo!=null && getInfo.size()!=0) {
				for(StudentInfo s :getInfo) {
					studentInfo.setName(s.getName());
					studentInfo.setCollege(s.getCollege());
					studentInfo.setEvent(s.getEvent());
					studentInfo.setGrade(s.getGrade());
					System.out.println(mark+". "+s.toString());
					mark++;
				}
				if(mark>1) {
					System.out.print("请选择编辑条目：");
					String flag = input.next();
					System.out.println("请选择编辑项：");
					System.out.println("1. 姓名 (若有多项，一并更新)");
			    	System.out.println("2. 参赛项目 (只更新选中条目)");
			    	System.out.print("请输入：");
			    	String num = input.next();
			    	System.out.print("请输入更新信息：");
			    	String newInfo = input.next();
			    	
			    	if(athlete.editAthleteInfo(studentInfo,flag,num,newInfo)) {
						System.out.println("修改成功！");
					}else {
						System.err.println("修改失败！");
					}
				}else {
					System.out.print("请选择编辑项：");
					System.out.println("1. 姓名");
			    	System.out.println("2. 参赛项目");
			    	String num = input.next();
			    	System.out.println("请输入更新信息：");
			    	String newInfo = input.next();
			    	
			    	if(athlete.editAthleteInfo(studentInfo,"1",num,newInfo)) {	//单条目默认修改第一条数据
						System.out.println("修改成功！");
					}else {
						System.err.println("修改失败！");
					}
				}
	    	}else {
	    		System.err.println("信息不存在！");
	    	}
			
			editAthleteInfo(account);
		}
	}
	
	/**
	 * @param account 传入学院管理员帐号 匹配本学院信息
	 * @Description 删除运动员信息. 输入学号删除相应信息，若有多条则显示列表，删除列表中选中项。
	 */
	public static void deleteAthleteInfo(String account) {
		StudentInfo studentInfo = new StudentInfo();
		
		System.out.println("\n\n\n");
		System.out.println("当前位置 > 学院管理员 > 删除运动员报名信息");
		System.out.println("	》main.返回开始菜单 ");
		System.out.println("	》exit.返回上一层 ");
		System.out.println("----------------------------------");
		System.out.print("请输入待删除的运动员学号：（2017001）");
		studentInfo.setId(input.next());
		if("exit".equals(studentInfo.getId())) {
			showMenu(account);
		}else if ("main".equals(studentInfo.getId())) {
			MainUI.mainMenu();
		}else {
			int mark=1;
			List<StudentInfo> getInfo = athlete.searchAthleteInfo(studentInfo,account);
			if(getInfo != null && getInfo.size()!=0) {		//判断信息是否存在
				for(StudentInfo s :getInfo) {				//展示匹配信息列表
					studentInfo.setName(s.getName());
					studentInfo.setCollege(s.getCollege());
					studentInfo.setEvent(s.getEvent());
					studentInfo.setGrade(s.getGrade());
					System.out.println(mark+". "+s.toString());
					mark++;
				}
				if(mark>1) {
					System.out.print("请选择删除条目：");
					String flag = input.next();	
					if(athlete.deleteAthleteInfo(studentInfo,flag)) {
						System.out.println("删除成功！");
					}else {
						System.err.println("删除失败！");
					}
//					try {
//						if(athlete.deleteAthleteInfo(studentInfo,flag)) {
//							System.out.println("删除成功！");
//						}else {
//							System.err.println("删除失败！");
//						}
//					}catch(Exception NumberFormatException) {
//						if("exit".equals(flag)) {
//							deleteAthleteInfo(account);
//						}else {
//							//System.err.println("请输入正确操作！");
//							deleteAthleteInfo(account);
//						}
//					}
			    	
				}else {
					if(athlete.deleteAthleteInfo(studentInfo,"1")) { //若只有一条数据则默认删除第一条
						System.out.println("删除成功！");
					}else {
						System.err.println("删除失败！");
					}
				}
			}else {
	    		System.err.println("信息不存在!");
	    	}
			deleteAthleteInfo(account);
		}
	}
}
