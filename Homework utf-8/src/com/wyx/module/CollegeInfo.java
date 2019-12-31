package com.wyx.module;

/**
 * Class Name:CollegeInfo.java
 * 
 * @Description 学院管理员类
 * @author GPZoe
 * @data 2019年12月27日
 * @version 1.0 
 */
public class CollegeInfo {
	
	/**
	 * 学院管理员账号
	 */
	private String account;
	
	
	/**
	 * 学院管理员密码
	 */
	private String password;
	
	
	/**
	 * 学院管理员联系电话
	 */
	private String phonenumber;
	
	
	/**
	 * 学院管理员所属学院
	 */
	private String other;
	

	/**
	 * @Description 构造方法
	 */
	public CollegeInfo() {
	}
	
	
	/**
	 * @Description 构造方法
	 * @param string 帐号
	 * @param string2 密码
	 * @param string3 手机号
	 * @param string4 所属学院
	 */
	public CollegeInfo(String string, String string2, String string3, String string4) {
		setAccount(string);
		setPassword(string2);
		setPhonenumber(string3);
		setOther(string4);
	}
	
	/**
	 * @description toString重写
	 */
	public String toString() {
		return getAccount()+"   "+getPhonenumber()+"   "+getOther();
	}
	
	
	/**
	 * Description：对应get/set方法
	 * @return String
	 * @data 2019年12月27日
	 */
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
}
