package com.example.mall.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.entity.Customer;
import com.example.mall.entity.Product;
import com.example.mall.entity.Shop;
import com.example.mall.entity.ShoppingCart;
import com.example.mall.service.ProductService;
import com.example.mall.service.ShopService;
import com.example.mall.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ShopService shopService;
	
	//进入购物车
	@RequestMapping(value="/cart")
	public String queryCart(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map){
		Customer customer  = (Customer) request.getSession().getAttribute("customer");
		if (customer!=null) {
			List<ShoppingCart> list = shoppingCartService.queryShoppingCartsById(customer.getUserId());
			map.put("list", list);
			return "shoppingCart";
		} 
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
		return null;
	}
	//加入购物车
	@RequestMapping(value="/addCart",method=RequestMethod.GET)
	public String addCart(HttpServletResponse response,HttpServletRequest request,ShoppingCart shoppingCart){
		Cookie[] cookie = request.getCookies();
		for (int i = 0; i < cookie.length; i++) {
		Cookie cook = cookie[i];
		if(cook.getName().equalsIgnoreCase("productId")){ //获取键 
			int productId = Integer.parseInt(cook.getValue());    //获取值 
			Customer customer  = (Customer) request.getSession().getAttribute("customer");
			if (customer!=null) {
				shoppingCart.setCustomer(customer);
				Product product = productService.queryProductByProductId(productId);
				shoppingCart.setProduct(product);
				int shopId = product.getShopId();
				Shop shop = shopService.queryShopById(shopId);
				shoppingCart.setShop(shop);
				shoppingCart.setCreateTime(new Date());
				shoppingCart.setLastEditTime(new Date());
				shoppingCartService.addShoppingCart(shoppingCart);
				return "index";
			}
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
	//删除购物车
	@RequestMapping(value="/deleteCart",method=RequestMethod.GET)
	public String deleteCart(@RequestParam("cartId") int cartId){
		shoppingCartService.deleteShoppingCart(cartId);
		return "redirect:/cart";
	}
	//修改购物车,修改数量
	@RequestMapping("updateCart")
	public String updateCart(int cartId){
		shoppingCartService.updataAmount(cartId);
		return null;
	}
	//进入订单确认
	@RequestMapping("/checkOrders")
	public String checkOrders(){
		return "checkOrders";
	}
}
