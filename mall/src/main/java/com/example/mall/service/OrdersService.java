package com.example.mall.service;

import java.util.List;

import com.example.mall.entity.Orders;
import com.example.mall.entity.OrdersDetail;

public interface OrdersService {
	public void addOrders(Orders orders);
	public Orders queryOrdersById(int id);
	public List<Orders> changeContent(List<OrdersDetail> list);
	public List<Orders> queryOrdesInfo(int id, int start);
	public List<Orders> queryOrdesInfos(int id, int state, int start);
	public List<Orders> queryDateOrders(int userId,int day,int start);
}
