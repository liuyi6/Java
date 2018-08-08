package com.example.mall.dao;

import java.util.List;

import com.example.mall.entity.Orders;

public interface OrdersDao {
	public void addOrders(Orders orders);
	public Orders queryOrdersById(int id);
	public List<Orders> queryOrdesInfo(int id,int start);
	public List<Orders> queryOrdesInfos(int id,int state,int start);
	public List<Orders> queryDateOrders(int userId,int day,int start);
}
