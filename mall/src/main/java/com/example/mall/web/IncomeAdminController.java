package com.example.mall.web;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.dto.IncomeAdmin;
import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.AdvertisementShop;
import com.example.mall.entity.Orders;
import com.example.mall.service.AdvertisementProductAdminService;
import com.example.mall.service.AdvertisementShopAdminService;
import com.example.mall.service.OrderDetailAdminService;
import com.example.mall.utils.DateSwitch;

@Controller
@RequestMapping("/admin")
public class IncomeAdminController {
	
	@Autowired
	private AdvertisementProductAdminService aProductAdminService;
	
	@Autowired
	private AdvertisementShopAdminService aShopAdminService;
	
	@Autowired
	private OrderDetailAdminService orderDetailAdminService;
	
	@GetMapping("/income")
	public String entrace() {
		return "commission_income_admin";
	}
	
	@PostMapping("/income")
	public String income(Model model,@RequestParam("selectWay") String selectWay,
			@RequestParam("date") String date,HttpServletRequest request) throws ParseException {
		Date[] dates = DateSwitch.timeConversion(selectWay, date);
		Date start = dates[0];
		Date end = dates[1];
		List<AdvertisementProduct> advertisementProducts = aProductAdminService.querySuccessfulApplicatonProduct(start, end);
		List<AdvertisementShop> advertisementShops = aShopAdminService.querySuccessfulApplicationShop(start, end);
		List<Orders> orders = orderDetailAdminService.getOrderProduct(start, end);
		IncomeAdmin incomeAdmin = new IncomeAdmin();
		incomeAdmin.setAmount(orders.size());
		Double orderIncome = 0.0;
		Double advertisementIncome = 0.0;
		for(AdvertisementProduct product : advertisementProducts) {
			advertisementIncome += product.getPrice();
		}
		for(AdvertisementShop shop : advertisementShops) {
			advertisementIncome += shop.getPrice();
		}
		for(Orders order : orders) {
			orderIncome += order.getPrice();
		}
		incomeAdmin.setAdvertisementIncome(advertisementIncome);
		
		Double rate = 0.02;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if (cookie.getName().equals("rate")) {
				rate = Double.parseDouble(cookie.getValue());
			}
		}
		
		incomeAdmin.setRate(rate);
		incomeAdmin.setOrderIncome(orderIncome * rate);
		
		model.addAttribute("income", incomeAdmin);
		model.addAttribute("date", date);
		model.addAttribute("selectWay", selectWay);
		
		return "commission_income_admin";
	}
}
