package com.example.mall.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mall.entity.OrdersDetail;
import com.example.mall.entity.ProductResult2;
import com.example.mall.entity.ReturnShop;
import com.example.mall.service.ReturnOrderService;

/**
 * @author Pencil
 * @TODO
 */
@Controller
@RequestMapping("/return")
public class ReturnOrder {

	@Autowired
	private ReturnOrderService returnOrderService;
	
	// 查询所有退货订单
	@RequestMapping("/returnOrder.action")
	@ResponseBody
	public ProductResult2 queryReturnOrder(
			@RequestParam(value="shopId",required=false)Integer shopId) {
		List<ReturnShop> list = returnOrderService.queryReturnOrder(shopId);
		ProductResult2 result2 = new ProductResult2();
		result2.setData(list);
		return result2;
	}
	
	@RequestMapping("/agreeReturn.action")
	public String agreeReturn(
			@RequestParam(value="orderId",required=false)Integer orderDetailId) {
		OrdersDetail detail = new OrdersDetail();
		detail.setOrderDetailId(orderDetailId);
		returnOrderService.agreeReturn(detail);
		return "tuihuo";
	}
	
	@RequestMapping("/disagreeReturn.action")
	public String disagreeReturn(
			@RequestParam(value="disagreeId",required=false)Integer orderDetailId) {
		OrdersDetail detail = new OrdersDetail();
		detail.setOrderDetailId(orderDetailId);
		returnOrderService.disagreeReturn(detail);
		return "tuihuo";
	}
	
}
