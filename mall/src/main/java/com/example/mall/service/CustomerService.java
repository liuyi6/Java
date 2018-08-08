package com.example.mall.service;

import com.example.mall.entity.Customer;

public interface CustomerService {
	//增
	public void addCustomer(Customer customer);
	//改
	public void changePassword(Customer customer);
	//查
	public Customer queryCustomerByUserName(String userName);
	public Customer queryCustomerByUserId(int id);
}
