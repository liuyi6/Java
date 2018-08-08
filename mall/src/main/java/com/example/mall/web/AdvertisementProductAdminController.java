package com.example.mall.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.service.AdvertisementProductAdminService;
import com.example.mall.utils.DateSwitch;
import com.example.mall.utils.Page;

@Controller
@RequestMapping("/admin")
public class AdvertisementProductAdminController {
	
	@Autowired
	private AdvertisementProductAdminService adminService;
	
	/**
	 * 查询所有申请产品广告
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/query/advertisement/product/{pageId}",method=RequestMethod.GET)
	public String queryAllAdvertisementProduct(Model model,@PathVariable("pageId") Integer pageId) {
		try {
			Date today = DateSwitch.getTodayDate();
			List<AdvertisementProduct> advertisementProducts = adminService.queryAllAdvertisementProduct(today);
			
			Page page = new Page(advertisementProducts.size(), pageId);
//			System.out.println(page);
			List<AdvertisementProduct> aList = adminService.queryPageAdvertisementProduct(today, page.getStart(), page.getPageNum());
			model.addAttribute("products", aList);
			List<Integer> pages = new ArrayList<>();
			for (int i = 1; i <= page.getAllPage(); i++) {
				pages.add(i);
			}
			model.addAttribute("pages", pages);
			return "ad_product_admin";
		} catch (ParseException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 同意产品广告的申请
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/agree/advertisement/product/{id}",method=RequestMethod.GET)
	public String agreeAdvertisementProduct(@PathVariable("id") Integer id) {
		adminService.agreeAdvertisementProduct(id);
		return "redirect:/admin/query/advertisement/product/1";
	}
	
	/**
	 * 拒绝产品广告的申请
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/refuse/advertisement/product/{id}",method=RequestMethod.GET)
	public String refusedvertisementProduct(@PathVariable("id") Integer id) {
		adminService.refuseAdvertisementProduct(id);
		return "redirect:/admin/query/advertisement/product/1";
	}
}
