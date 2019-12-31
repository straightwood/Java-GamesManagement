package com.wyx.module;

/**
 * Class Name:SystemInfo.java
 * 
 * @Description 系统管理员信息类
 * @author GPZoe
 * @since 2019年12月16日
 * @version 1.0 
 */
public class SystemInfo {
	
	/**
	 * 系统管理员账号
	 */
	private String account;
	
	/**
	 * 系统管理员密码
	 */
	private String password;
	
	/**
	 * 系统管理员联系电话
	 */
	private String phonenumber;
	
	/**
	 * 系统管理员其他信息
	 */
	private String other;
	
	/**
	 * 构造方法
	 */
	public SystemInfo() {
	}
	
	/**
	 * @Description 构造方法
	 * @param string 帐号
	 * @param string2 密码
	 * @param string3 手机号
	 * @param string4 所属学院
	 */
	public SystemInfo(String string, String string2, String string3,String string4) {
		setAccount(string);
		setPassword(string2);
		setPhonenumber(string3);
		setOther(string4);
	}
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
