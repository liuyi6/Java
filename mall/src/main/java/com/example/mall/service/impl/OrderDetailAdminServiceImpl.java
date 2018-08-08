package com.example.mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.OrderDetailAdminDao;
import com.example.mall.entity.Orders;
import com.example.mall.service.OrderDetailAdminService;

@Service
public class OrderDetailAdminServiceImpl implements OrderDetailAdminService{

	@Autowired
	private OrderDetailAdminDao orderDetailAdminDao;
	
	@Override
	public List<Orders> getOrderProduct(Date start, Date end) {
		return orderDetailAdminDao.getOrderProduct(start, end);
	}

	@Override
	public List<Orders> queryOrderDetailById(String id) {
		return orderDetailAdminDao.queryOrderDetailById(id);
	}

}
