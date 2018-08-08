package com.example.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.AdminDao;
import com.example.mall.entity.Admin;
import com.example.mall.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin loginAdmin(String name, String password) {
		return adminDao.loginAdmin(name, password);
	}

}
