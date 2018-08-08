package com.example.mall.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.entity.Comment;
import com.example.mall.entity.Customer;
import com.example.mall.entity.Orders;
import com.example.mall.service.CommentService;
import com.example.mall.service.OrdersDetailService;
import com.example.mall.service.OrdersService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private OrdersDetailService ordersSetailService;
	//添加评论
	@RequestMapping(value="/addcomment",method=RequestMethod.POST)
	public String addComment(HttpServletRequest request,@RequestParam("content") String content,@RequestParam("ordersid") String ordersid){
		Comment comment =  new Comment();
		comment.setContent(content);
		comment.setCreateTime(new Date());
		comment.setLastEditTime(new Date());
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		comment.setCustomer(customer);
		Orders orders = ordersService.queryOrdersById(Integer.parseInt(ordersid));
		comment.setOrders(orders);
		commentService.addComment(comment);
		ordersSetailService.updateEvalute(Integer.parseInt(ordersid));
		return "index";
	}
}
