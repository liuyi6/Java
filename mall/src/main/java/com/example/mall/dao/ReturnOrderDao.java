package com.example.mall.dao;
/**
* @author Pencil
* @TODO
*/

import java.util.List;

import com.example.mall.entity.OrdersDetail;
import com.example.mall.entity.ReturnShop;

public interface ReturnOrderDao {
	//查询退货订单
	public List<ReturnShop> queryReturnOrder(Integer shopId);
	
	public void agreeReturn(OrdersDetail ordersDetail);
	
	public void disagreeReturn(OrdersDetail ordersDetail);
	
}
