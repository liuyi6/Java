package com.example.mall.entity;

import java.util.Date;

/**
 * 账户信息表
 * @author xiaolinzi
 *
 */
public class Customer {
	private Integer userId;
	private String userName;
	private String password;
	private String phone;
	private String address;
	private Integer enableStatus; // 1 代表允许使用商城  0 代表禁止使用商城
	private Date createTime;
	private Date lastEditTime;

	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getEnableStatus() {
		return enableStatus;
	}
	
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getLastEditTime() {
		return lastEditTime;
	}
	
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
