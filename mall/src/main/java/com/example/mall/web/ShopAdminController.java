package com.example.mall.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.mall.entity.Shop;
import com.example.mall.service.ShopAdminService;
import com.example.mall.utils.Page;

@Controller
@RequestMapping("/admin")
public class ShopAdminController {
	
	@Autowired
	private ShopAdminService shopAdminService;
	
	/**
	 * 同意店家的申请
	 * @param shopId
	 * @param userId
	 * @return
	 */
	@Transactional
	@RequestMapping(value="approve/shop/{shopId}",method=RequestMethod.GET)
	public String approveShop(@PathVariable("shopId") Integer shopId) {
		shopAdminService.approveShopRequest(shopId); // 将商铺的状态更新为1
		return "redirect:/admin/apply/1";
	}
	
	@RequestMapping(value="/refuse/shop/{shopId}",method=RequestMethod.GET)
	public String refuseShop(@PathVariable("shopId") Integer shopId) {
		shopAdminService.refuseShopRequest(shopId);
		return "redirect:/admin/apply/1";
	}
	
	/**
	 * 分页查询店家信息
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/query/shop/{id}",method = RequestMethod.GET)
	public String queryAccountByPage(Model model,@PathVariable("id") Integer id) {
		List<Shop> shops = shopAdminService.queryShopList();
		Page page = new Page(shops.size(), id);
		
		List<Shop> shopList = shopAdminService.queryShopByPage(page.getStart(), page.getPageNum());
		model.addAttribute("shopList", shopList);
		List<Integer> amountPage = new ArrayList<>();
		for(int i=1;i<=page.getAllPage();i++)
			amountPage.add(i);
		model.addAttribute("amountPage", amountPage);
		return "owner_admin";
	}
	
	/**
	 * 根据输入的店铺名字或卖家名字进行查询
	 * @param model
	 * @param name
	 * @param select
	 * @return
	 */
	@RequestMapping(value="/query/shop/name",method=RequestMethod.POST)
	public String searchShopByName(Model model,@RequestParam(value="name") String name,
									@RequestParam(value="select") String select) {
		List<Shop> shops = null;
		Integer selectNum = 1;
		if ("ShopName".equals(select)) {
			shops = shopAdminService.queryShopByShopName(name);
		}else {
			shops = shopAdminService.queryShopByUserName(name);
			selectNum = 2;
		}
		model.addAttribute("shopList", shops);
		model.addAttribute("name", name);
		model.addAttribute("selectNum", selectNum);
		return "owner_admin";
	}
	
	/**
	 * 查询所有待审核的商家
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/apply/{id}",method=RequestMethod.GET)
	public String applyShop(Model model,@PathVariable("id") Integer id) {
		List<Shop> shops = shopAdminService.queryApplyShop();
		Page page = new Page(shops.size(), id);
		List<Shop> shopList = shopAdminService.queryApplyShopByPage(page.getStart(), page.getPageNum());
		model.addAttribute("shops", shopList);
		List<Integer> amountPage = new ArrayList<>();
		for(int i=1;i<=page.getAllPage();i++)
			amountPage.add(i);
		model.addAttribute("amountPage", amountPage);
		return "owner_request_admin";
	}
	
	/**
	 * 查询卖家的黑名单
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/query/shop/blacklist",method=RequestMethod.GET)
	public String queryShopBlackList(Model model) {
		List<Shop> shops = shopAdminService.queryShopBlackList();
		model.addAttribute("shops", shops);
		return "owner_blacklist_admin";
	}
	
	/**
	 * 根据商铺id加入黑名单
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value="/add/shop/blacklist/{shopId}",method=RequestMethod.GET)
	public String addShopBlackList(@PathVariable("shopId") Integer shopId) {
		shopAdminService.addShopBlackList(shopId);
		return "redirect:/admin/query/shop/1";
	}
	
	/**
	 * 根据商家id，将商家移除黑名单
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value="/remove/shop/blacklst/{shopId}",method=RequestMethod.GET)
	public String removeShopBlackList(@PathVariable("shopId") Integer shopId) {
		shopAdminService.removeShopBlacklist(shopId);
		return "redirect:/admin/query/shop/blacklist";
	}
	
	@RequestMapping(value="/delete/blacklist/shop/{shopId}",method=RequestMethod.GET)
	public String deleteShopBlackListById(@PathVariable("shopId") Integer shopId) {
		shopAdminService.deleteShop(shopId);
		return "redirect:/admin/query/shop/blacklist";
	}
	
	/**
	 * 根据商铺id删除商铺
	 * @param shopId
	 * @return
	 */
	@RequestMapping(value="/delete/shop/{shopId}",method=RequestMethod.GET)
	public String deleteShopById(@PathVariable("shopId") Integer shopId) {
		shopAdminService.deleteShop(shopId);
		return "redirect:/admin/query/shop/1";
	}
}
