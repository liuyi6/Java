package com.example.mall.web;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.entity.Shop;
import com.example.mall.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	/*产品搜索*/
	@RequestMapping(value="/shopSerach",method=RequestMethod.GET)
	public String shopSerach(HttpServletRequest request,@RequestParam("content") String shopName,Map<String,Object> map) throws UnsupportedEncodingException{
		String name = new String(shopName.getBytes("ISO-8859-1"),"utf-8");
		List<Shop> list = shopService.shopSerach(name);
		map.put("list", list);
		return "serachShop";
	}
}
