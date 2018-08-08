package com.example.mall.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.entity.Admin;
import com.example.mall.service.AdminService;
import com.example.mall.service.AdvertisementProductAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdvertisementProductAdminService advertisementProductAdminService;
	
	/**
	 * 管理员登录入口
	 * @return
	 */
	@RequestMapping
	public String login() {
		return "login_admin";
	}
	
	/**
	 * 校验管理员登录
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String loginAdmin(@RequestParam(value="name",required = true) String name,
							@RequestParam(value="password",required=true) String password) {
		Admin admin = adminService.loginAdmin(name, password);
		if (admin == null) {
//			model.addAttribute("errMsg", "用户名或密码错误");
			return "redirect:/admin/";
		}
//		model.addAttribute("name", name);
		return "redirect:/admin/apply/1";
	}
	
	@GetMapping("/advertisement/shop/{shopId}")
	public String advertisementShop(@PathVariable("shopId") Integer shopId,HttpServletRequest request,HttpServletResponse response) {
		Cookie cookie = new Cookie("shopId", shopId + "");
		response.addCookie(cookie);
		return "school2";
	}
	
	@GetMapping("/advertisement/product/{productId}")
	public String advertisementProduct(@PathVariable("productId") Integer productId,HttpServletResponse response) {
		Cookie product = new Cookie("productId", productId + ""); 
		Cookie shop = new Cookie("shopName", advertisementProductAdminService.queryShopByProductId(productId).getShop().getShopName());
		response.addCookie(product);
		response.addCookie(shop);
		return "news_detail2";
	}
}
