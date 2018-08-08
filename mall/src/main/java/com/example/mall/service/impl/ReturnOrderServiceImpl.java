package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.ReturnOrderDao;
import com.example.mall.entity.OrdersDetail;
import com.example.mall.entity.ReturnShop;
import com.example.mall.service.ReturnOrderService;

/**
* @author Pencil
* @TODO
*/
@Service
public class ReturnOrderServiceImpl implements ReturnOrderService{

	@Autowired
	private ReturnOrderDao returnOrderDao;
	
	@Override
	public List<ReturnShop> queryReturnOrder(Integer shopId) {
		List<ReturnShop> orders = returnOrderDao.queryReturnOrder(shopId);
		return orders;
	}

	@Override
	public void agreeReturn(OrdersDetail rDetail) {
		returnOrderDao.agreeReturn(rDetail);
	}

	@Override
	public void disagreeReturn(OrdersDetail ordersDetail) {
		returnOrderDao.disagreeReturn(ordersDetail);
	}


}
