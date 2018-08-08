package com.example.mall.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.AdvertisementShop;
import com.example.mall.entity.Collect;
import com.example.mall.entity.Customer;
import com.example.mall.entity.Orders;
import com.example.mall.entity.OrdersDetail;
import com.example.mall.service.AdvertisementProductAdminService;
import com.example.mall.service.AdvertisementShopAdminService;
import com.example.mall.service.CollectService;
import com.example.mall.service.CustomerService;
import com.example.mall.service.OrdersDetailService;
import com.example.mall.service.OrdersService;
import com.example.mall.utils.DateSwitch;
import com.example.mall.utils.Page;

/**
 * 账号controller层
 * 
 * @author luis
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrdersDetailService ordersDetailService;
	
	@Autowired
	private CollectService collectService;
	
	@Autowired
	private AdvertisementProductAdminService advertisementProductAdminService;
	
	@Autowired
	private AdvertisementShopAdminService advertisementShopAdminService;

	// 注册
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletResponse response, Customer customer, @RequestParam("user_name") String userName,
			@RequestParam("password") String password, @RequestParam("phone") String phone,
			@RequestParam("address") String address, Map<String, Object> map) {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		customer.setUserName(userName);
		customer.setCreateTime(new Date());
		customer.setEnableStatus(1);
		customer.setLastEditTime(new Date());
		customerService.addCustomer(customer);
		return "login";
	}

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response,Model model,
			@RequestParam("account") String userName, @RequestParam("password") String password,
			Map<String, Object> map) {
		Customer customer = customerService.queryCustomerByUserName(userName);
		PrintWriter out;
		if (customer != null && customer.getPassword().equals(password)) { // 用户登录
			request.getSession().setAttribute("customer", customer);
			Cookie cookie = new Cookie("shopId", "" + customer.getUserId());
			response.addCookie(cookie);
			map.put("customer", customer);
			model.addAttribute("customer", customer);
			
			return "redirect:/index";

		} else {
			try {
				out = response.getWriter();
				out.println("<script type='text/javascript'>" + "alert('Username or Password is wrong!');"
						+ "location.href='logins';" + "</script>");
			} catch (IOException e) {
				System.out.println("error！！！");
			}
		}
		return null;
	}

	// 注销
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}

	// 改密
	@RequestMapping(value = "/changePwd", method = RequestMethod.POST)
	public String changePwd(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("newpwd") String newPwd, @RequestParam("newpwd2") String newPwd2) {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if (newPwd.equals(newPwd2)) {
			customer.setPassword(newPwd);
			customerService.changePassword(customer);
			logout(request);// 注销重新登录
			return "login";
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script type='text/javascript'>"
						+ "alert('The two passwords are not the same, please input again！');"
						+ "location.href='user-account.jsp';" + "</script>");
			} catch (IOException e) {
			}
		}
		return null;
	}

	// 个人中心
	@RequestMapping(value = "/customerCenter", method = RequestMethod.GET)
	public String center(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map,
			@RequestParam("pageId") int pageId) {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if (customer != null) {
			int amount = ordersDetailService.queryAmount(customer.getUserId());// 总数量
			Page page = new Page(amount, pageId);
			List<Orders> list = ordersService.queryOrdesInfo(customer.getUserId(), page.getStart());
			List<Collect> collectList = collectService.queryCollectById(customer.getUserId());
			List<OrdersDetail> list2 = ordersDetailService.queryApplayStatus(customer.getUserId(), page.getStart());
			map.put("customer", customer);
			map.put("collectList", collectList);
			map.put("list", list);
			map.put("page", page);
			map.put("list2", list2);
			return "userCenter";
		}
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script type='text/javascript'>" + "alert('please login the mall!');"
					+ "location.href='logins';" + "</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/index")
	public String changeIndex(Model model) throws ParseException {
		Date yesterday = DateSwitch.getYesterDate();
		Date today = DateSwitch.getTodayDate();
		
		List<AdvertisementProduct> advertisementProducts = advertisementProductAdminService.querySuccessfulApplicatonProduct(yesterday, today);
		List<AdvertisementShop> advertisementShops = advertisementShopAdminService.querySuccessfulApplicationShop(yesterday, today);
		
//		System.out.println(advertisementShops);
//		System.out.println(advertisementProducts);
		
		model.addAttribute("shops", advertisementShops);
		model.addAttribute("products", advertisementProducts);
		return "index";
	}

	@RequestMapping("/logins")
	public String loginShop(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping("/registers")
	public String registerShop() {
		return "register";
	}
}
