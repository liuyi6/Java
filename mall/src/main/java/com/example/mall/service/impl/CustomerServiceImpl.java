package com.example.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.CustomerDao;
import com.example.mall.entity.Customer;
import com.example.mall.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer queryCustomerByUserName(String userName) {
		return customerDao.queryCustomerByUserName(userName);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public void changePassword(Customer customer) {
		customerDao.changePassword(customer);
	}


	@Override
	public Customer queryCustomerByUserId(int id) {
		return customerDao.queryCustomerByUserId(id);
	}

}
