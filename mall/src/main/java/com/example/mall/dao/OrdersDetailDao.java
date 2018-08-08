package com.example.mall.dao;

import java.util.List;

import com.example.mall.entity.OrdersDetail;

public interface OrdersDetailDao {
	public List<OrdersDetail> queryUnPay(int userId);
	public List<OrdersDetail> queryUnDeliver(int userId);
	public List<OrdersDetail> queryUnReceive(int userId);
	public List<OrdersDetail> queryUnEvalute(int userId);
	public List<OrdersDetail> queryAllOrders(int userId);
	public void addOrdersDetail(OrdersDetail ordersDetail);
	public int queryMaxId();
	public void updatePay(int num);
	public void updateDeliver(int num);
	public void updateReceive(int num);
	public void updateEvalute(int num);
	public OrdersDetail queryOrderDetailById(int id);
	//退货状态修改
	public void updateReturn(String reason,int id);
	//分页查询
	public List<OrdersDetail> queryOrders(int id,int start);
	public List<OrdersDetail> queryOrderss(int id,int start,int state);
	///查询总数量
	public int queryAmount(int id);
	public int queryAmounts(int id,int state);
	//根据日期查看订单
	public int queryDateAmount(int id,int day);
	public List<OrdersDetail> queryApplayStatus(int id,int start);
}
