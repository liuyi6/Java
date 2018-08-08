package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.OrdersDetailDao;
import com.example.mall.entity.OrdersDetail;
import com.example.mall.service.OrdersDetailService;
@Service
public class OrdersDetailServiceImpl implements OrdersDetailService{
	@Autowired
	OrdersDetailDao ordersDetailDao;

	@Override
	public List<OrdersDetail> queryUnPay(int userId) {
		return ordersDetailDao.queryUnPay(userId);
	}

	@Override
	public List<OrdersDetail> queryUnDeliver(int userId) {
		return ordersDetailDao.queryUnDeliver(userId);
	}

	@Override
	public List<OrdersDetail> queryUnReceive(int userId) {
		return ordersDetailDao.queryUnReceive(userId);
	}

	@Override
	public List<OrdersDetail> queryUnEvalute(int userId) {
		return ordersDetailDao.queryUnEvalute(userId);
	}

	@Override
	public List<OrdersDetail> queryAllOrders(int userId) {
		return ordersDetailDao.queryAllOrders(userId);
	}

	@Override
	public void addOrdersDetail(OrdersDetail ordersDetail) {
		ordersDetailDao.addOrdersDetail(ordersDetail);
	}

	@Override
	public int queryMaxId() {
		return ordersDetailDao.queryMaxId();
	}


	@Override
	public OrdersDetail queryOrderDetailById(int id) {
		return ordersDetailDao.queryOrderDetailById(id);
	}

	@Override
	public void updatePay(int num) {
		ordersDetailDao.updatePay(num);
	}

	@Override
	public void updateDeliver(int num) {
		ordersDetailDao.updateDeliver(num);
	}

	@Override
	public void updateReceive(int num) {
		ordersDetailDao.updateReceive(num);
	}

	@Override
	public void updateEvalute(int num) {
		ordersDetailDao.updateEvalute(num);
	}

	@Override
	public void updateReturn(String reason,int id) {
		ordersDetailDao.updateReturn(reason,id);
	}

	@Override
	public List<OrdersDetail> queryOrders(int id, int start) {
		return ordersDetailDao.queryOrders(id, start);
	}

	@Override
	public List<OrdersDetail> queryOrderss(int id, int start, int state) {
		return ordersDetailDao.queryOrderss(id, start, state);
	}

	@Override
	public int queryAmount(int id) {
		return ordersDetailDao.queryAmount(id);
	}

	@Override
	public int queryAmounts(int id, int state) {
		return ordersDetailDao.queryAmounts(id, state);
	}

	@Override
	public int queryDateAmount(int id, int day) {
		return ordersDetailDao.queryDateAmount(id, day);
	}

	@Override
	public List<OrdersDetail> queryApplayStatus(int id, int start) {
		return ordersDetailDao.queryApplayStatus(id, start);
	}

	

}
