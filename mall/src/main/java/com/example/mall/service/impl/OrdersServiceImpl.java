package com.example.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.OrdersDao;
import com.example.mall.entity.Orders;
import com.example.mall.entity.OrdersDetail;
import com.example.mall.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void addOrders(Orders orders) {
		ordersDao.addOrders(orders);
	}

	@Override
	public Orders queryOrdersById(int id) {
		return ordersDao.queryOrdersById(id);
	}

	@Override
	public List<Orders> changeContent(List<OrdersDetail> list) {
		List<Orders> order = new ArrayList<Orders>();
		for(int i = 0;i < list.size(); i ++){
			   Orders orders = ordersDao.queryOrdersById(list.get(i).getOrderDetailId());
			   order.add(orders);
			}
		return order;
	}

	@Override
	public List<Orders> queryOrdesInfo(int id, int start) {
		return ordersDao.queryOrdesInfo(id, start);
	}

	@Override
	public List<Orders> queryOrdesInfos(int id, int state, int start) {
		return ordersDao.queryOrdesInfos(id, state, start);
	}

	@Override
	public List<Orders> queryDateOrders(int userId, int day, int start) {
		return ordersDao.queryDateOrders(userId, day, start);
	}

}
