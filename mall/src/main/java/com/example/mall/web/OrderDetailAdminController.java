package com.example.mall.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.entity.Orders;
import com.example.mall.service.OrderDetailAdminService;
import com.example.mall.utils.DateSwitch;
import com.example.mall.utils.Page;

@Controller
@RequestMapping("/admin")
public class OrderDetailAdminController {
	
	@Autowired
	private OrderDetailAdminService orderDetailAdminService;
	
	@GetMapping("/query/order")
	public String queryOrderProduct() {
		return "sales_record_admin";
	}
	
	/**
	 * 查询结果
	 * @param model
	 * @param selectWay
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/query/order",method=RequestMethod.POST)
	public String queryOrderProductByDate(Model model,@RequestParam("selectWay") String selectWay,
			@RequestParam("date") String date,HttpServletResponse response) throws ParseException {
		Date[] dates = DateSwitch.timeConversion(selectWay, date);
		Date start = dates[0];
		Date end = dates[1];
		List<Orders> allOrders = orderDetailAdminService.getOrderProduct(start, end);
		Page page = new Page(allOrders.size(), 1);
		List<Integer> amountPage = new ArrayList<>();
		for(int i=1;i<=page.getAllPage();i++)
			amountPage.add(i);
		int startIndex = page.getStart();
		List<Orders> orders = new ArrayList<>();
		for (int i = 0; i < page.getPageNum(); i++) {
			if (startIndex + i < allOrders.size()) {
				orders.add(allOrders.get(startIndex + i));
			}else {
				break;
			}
		}
		model.addAttribute("orders", orders);
		model.addAttribute("amountPage", amountPage);
		model.addAttribute("date", date);
		model.addAttribute("selectWay", selectWay);
		
		Cookie startCookie = new Cookie("start", start.getTime() + "");
		Cookie endCookie = new Cookie("end", end.getTime() + "");
		Cookie dateCookie = new Cookie("date", date);
		Cookie selectCooie = new Cookie("select", selectWay);
		
		response.addCookie(startCookie);
		response.addCookie(endCookie);
		response.addCookie(dateCookie);
		response.addCookie(selectCooie);
		return "sales_record_admin";
	}
	
	@GetMapping("/query/order/{id}")
	public String queryOrderProductByPage(@PathVariable("id") Integer id,Model model,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Date start = null;
		Date end = null;
		String date = null;
		String select = null;
		for(Cookie cookie : cookies) {
			if (cookie.getName().equals("start")) {
				start = new Date(Long.parseLong(cookie.getValue()));
			}else if (cookie.getName().equals("end")) {
				end = new Date(Long.parseLong(cookie.getValue()));
			}else if (cookie.getName().equals("date")) {
				date = cookie.getValue();
			}else if (cookie.getName().equals("select")) {
				select = cookie.getValue();
			}
		}
		List<Orders> allOrders = orderDetailAdminService.getOrderProduct(start, end);
		Page page = new Page(allOrders.size(), id);
		List<Integer> amountPage = new ArrayList<>();
		for(int i=1;i<=page.getAllPage();i++)
			amountPage.add(i);
		int startIndex = page.getStart();
		List<Orders> orders = new ArrayList<>();
		for (int i = 0; i < page.getPageNum(); i++) {
			if (startIndex + i < allOrders.size()) {
				orders.add(allOrders.get(startIndex + i));
			}else {
				break;
			}
		}
		model.addAttribute("orders", orders);
		model.addAttribute("amountPage", amountPage);
		model.addAttribute("date", date);
		model.addAttribute("selectWay", select);
		return "sales_record_admin";
	}
	
	
	@GetMapping("/search/order")
	public String searchOrderEntrace() {
		return "order_tracking_admin";
	}
	
	@PostMapping("/search/order")
	public String searchOrderById(Model model,@RequestParam("id") String id) {
		List<Orders> orders = orderDetailAdminService.queryOrderDetailById(id);
		model.addAttribute("orders", orders);
		model.addAttribute("id", id);
		return "order_tracking_admin";
	}
}