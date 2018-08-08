package com.example.mall.dao;

import com.example.mall.entity.Customer;

public interface CustomerDao {
	
	//增加用户
	public void addCustomer(Customer customer);
	//改用户密码
	public void changePassword(Customer customer);
	//根据条件查找用户
	public Customer queryCustomerByUserName(String userName);
	public Customer queryCustomerByUserId(int id);
}
