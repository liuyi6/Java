package com.example.mall.web;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.mall.entity.AdvertisementShop;
import com.example.mall.service.AdvertisementShopAdminService;
import com.example.mall.utils.DateSwitch;

@Controller
@RequestMapping("/admin")
public class AdvertisementShopAdminController {
	
	@Autowired
	private AdvertisementShopAdminService advertisementShopAdminService;
	
	/**
	 * 查询当日的店铺申请广告
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/query/advertisement/shop",method=RequestMethod.GET)
	public String queryAllApplyShop(Model model)  {
		try {
			Date date = DateSwitch.getTodayDate();
			List<AdvertisementShop> advertisementShops = advertisementShopAdminService.queryAllAdvertisementShop(date);
//			System.out.println(advertisementShops);
//			System.out.println(date);
			model.addAttribute("shops", advertisementShops);
			return "ad_shop_admin";
		} catch (ParseException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 同意店铺广告的申请
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/agree/advertisement/shop/{id}",method=RequestMethod.GET)
	public String agreeAdvertisementShop(@PathVariable("id") Integer id) {
		advertisementShopAdminService.agreeAdvertisementShop(id);
		return "redirect:/admin/query/advertisement/shop";
	}
	
	/**
	 * 拒绝店铺广告的申请
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/refuse/advertisement/shop/{id}",method=RequestMethod.GET)
	public String refuseAdvertisementShop(@PathVariable("id") Integer id) {
		advertisementShopAdminService.refuseAdvertisementShop(id);
		return "redirect:/admin/query/advertisement/shop";
	}
}
