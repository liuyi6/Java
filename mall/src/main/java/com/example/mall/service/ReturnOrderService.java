package com.example.mall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mall.entity.OrdersDetail;
import com.example.mall.entity.ReturnShop;

/**
 * @author Pencil
 * @TODO
 */
@Service
public interface ReturnOrderService {

	public List<ReturnShop> queryReturnOrder(Integer shopId);
	
	public void agreeReturn(OrdersDetail rDetail);
	
	public void disagreeReturn(OrdersDetail ordersDetail);

}
