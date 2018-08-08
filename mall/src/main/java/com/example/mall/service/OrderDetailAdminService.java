package com.example.mall.service;

import java.util.Date;
import java.util.List;

import com.example.mall.entity.Orders;

public interface OrderDetailAdminService {
	List<Orders> getOrderProduct(Date start,Date end);
	
	List<Orders> queryOrderDetailById(String id);
}
