package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.CustomerAdminDao;
import com.example.mall.entity.Customer;
import com.example.mall.service.CustomerAdminService;

@Service
public class CustomerAdminServiceImpl implements CustomerAdminService{
	
	@Autowired
	private CustomerAdminDao customerAdminDao;
	
	@Override
	public void deleteCustomerById(Integer userId) {
		customerAdminDao.deleteCustomerById(userId);
	}
	
	
	@Override
	public List<Customer> queryAccountList() {
		return customerAdminDao.queryAccountList();
	}

	@Override
	public Customer queryAccountById(Integer userId) {
		return customerAdminDao.queryAccountById(userId);
	}

	@Override
	public List<Customer> queryAccountByName(String userName) {
		return customerAdminDao.queryAccountByName(userName);
	}

	@Override
	public void addUserBlackList(Integer userId) {
		customerAdminDao.addUserBlackList(userId);
	}

	@Override
	public List<Customer> queryBlackList() {
		return customerAdminDao.queryBlackList();
	}

	@Override
	public List<Customer> queryAccountByPage(Integer start, Integer offset) {
		return customerAdminDao.queryAccountByPage(start, offset);
	}

	@Override
	public void removeUserBlackList(Integer userId) {
		customerAdminDao.removeUserBlackList(userId);
	}
}
