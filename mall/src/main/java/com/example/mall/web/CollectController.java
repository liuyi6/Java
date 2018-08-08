package com.example.mall.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.entity.Collect;
import com.example.mall.entity.Customer;
import com.example.mall.entity.Product;
import com.example.mall.entity.Shop;
import com.example.mall.service.CollectService;
import com.example.mall.service.ProductService;
import com.example.mall.service.ShopService;

@Controller
public class CollectController {
	@Autowired
	private CollectService collectService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private ProductService productService;
	//添加店铺收藏
		@RequestMapping(value="/addcollect",method=RequestMethod.GET)
		public String addCollect(HttpServletResponse response,HttpServletRequest request){
			Cookie[] cookie = request.getCookies();
			for (int i = 0; i < cookie.length; i++) {
			Cookie cook = cookie[i];
			/*获取店铺id，然后根据是否登录进行跳转*/
			if(cook.getName().equalsIgnoreCase("productId")){ //获取键 
				int productId = Integer.parseInt(cook.getValue());    //获取值 
				Customer customer  = (Customer) request.getSession().getAttribute("customer");
				if (customer!=null) {
					Collect collect = new Collect();
					collect.setCustomer(customer);
					Product product = productService.queryProductByProductId(productId);
					int shopId = product.getShopId();
					Shop shop = shopService.queryShopById(shopId);
					collect.setShop(shop);
					collect.setCreateTime(new Date());
					collect.setLastEditTime(new Date());
					collectService.addCollect(collect);
					return "index";
				}
				/*未登录提示*/
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script type='text/javascript'>"+
							"alert('please login the mall!');"+
							"location.href='logins';"+
							"</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			return null;
		}
	//删除收藏
	@RequestMapping (value="/deleteCollect",method=RequestMethod.GET)
	public String deleteCollect(@RequestParam("collectId") int collectId){
		collectService.deletCollect(collectId);
		return "userCenter";
	}
	
}
