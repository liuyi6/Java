package com.example.mall.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.example.mall.entity.Orders;
import com.example.mall.entity.OrdersDetail;
import com.example.mall.entity.Product;
import com.example.mall.entity.Shop;
import com.example.mall.service.OrdersDetailService;
import com.example.mall.service.OrdersService;
import com.example.mall.service.ProductService;
import com.example.mall.service.ShopService;
import com.example.mall.service.ShoppingCartService;
import com.example.mall.utils.Page;

@Controller
public class OrdersDetailController {
	@Autowired
	private OrdersDetailService ordersDetailService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	//产品界面生成定单,直接在搜索后购买
	@RequestMapping(value="/addOrderss",method=RequestMethod.GET)
	public String addOrderss(HttpServletResponse response,HttpServletRequest request,Map<String,Object> map) {
		Cookie[] cookie = request.getCookies();
		for (int i = 0; i < cookie.length; i++) {
		Cookie cook = cookie[i];
		if(cook.getName().equalsIgnoreCase("productId")){ //获取键 
			int productId = Integer.parseInt(cook.getValue());    //获取值 
			Customer customer  = (Customer) request.getSession().getAttribute("customer");
			if (customer!=null) {
				OrdersDetail ordersDetail = new OrdersDetail();
				ordersDetail.setCustomer(customer);
				ordersDetail.setAmount(1);
				Product product = productService.queryProductByProductId(productId);
				ordersDetail.setOrderDetailId(ordersDetailService.queryMaxId()+1);
				ordersDetail.setPrice(product.getProductPrice());
				ordersDetail.setCreateTime(new Date());
				ordersDetail.setLastEditTime(new Date());
				ordersDetailService.addOrdersDetail(ordersDetail);
				map.put("ordersDetail", ordersDetail);
				Shop shop = shopService.queryShopById(product.getShopId());
				Orders orders = new Orders();
				orders.setShop(shop);
				orders.setProduct(product);
				orders.setOrdersDetail(ordersDetail);
				orders.setCreateTime(new Date());
				orders.setLastEditTime(new Date());
//				生成定单
				ordersService.addOrders(orders);
				return "pay";
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
	
	
	//购物车生成定单
	@RequestMapping(value="/addorders",method=RequestMethod.GET)
	public String addOrders(HttpServletRequest request,@RequestParam("str") String str,Map<String,Object> map){
		Customer customer  = (Customer) request.getSession().getAttribute("customer");
		String[] arr1 = str.split(";");
		for (int i = 0; i < arr1.length; i++) {
			String [] data = arr1[i].split(",");
			OrdersDetail ordersDetail = new OrdersDetail();
			ordersDetail.setCustomer(customer);
				ordersDetail.setAmount(Integer.parseInt(data[3]));
				Product product = productService.queryProductByProductId(Integer.parseInt(data[2]));
				ordersDetail.setPrice(product.getProductPrice()*Integer.parseInt(data[3]));
				ordersDetail.setOrderDetailId(ordersDetailService.queryMaxId()+1);
				ordersDetail.setCreateTime(new Date());
				ordersDetail.setLastEditTime(new Date());
				shoppingCartService.deleteShoppingCart(Integer.parseInt(data[0]));
				map.put("ordersDetail", ordersDetail);
//				生成详情定单
				ordersDetailService.addOrdersDetail(ordersDetail);
				Shop shop = shopService.queryShopById(Integer.parseInt(data[1]));
				Orders orders = new Orders();
				orders.setShop(shop);
				orders.setProduct(product);
				orders.setOrdersDetail(ordersDetail);
				orders.setCreateTime(new Date());
				orders.setLastEditTime(new Date());
//				生成定单
				ordersService.addOrders(orders);
			}
		return "pay";
	}
	
	//查看定单
		@RequestMapping(value="/queryorders",method=RequestMethod.GET)
		public String queryOrders(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map,
				@RequestParam("pageId") int pageId,
				@RequestParam("state") int state
				){
			Customer customer  = (Customer) request.getSession().getAttribute("customer");
			if (customer!=null) {
				int id = customer.getUserId();
				int amount = 0;
				List<Orders> list = new ArrayList<Orders>();
				Page page = new Page();
					if(state>4) {
						amount = ordersDetailService.queryAmount(id);// 总数量
						page = new Page(amount,pageId);
						list = ordersService.queryOrdesInfo(id, page.getStart());
					}else {
						amount = ordersDetailService.queryAmounts(id,state);
						page = new Page(amount,pageId);
						list = ordersService.queryOrdesInfos(id, state,page.getStart());
					}
				map.put("list", list);
				map.put("page", page);
				map.put("state", state);
				
				return "orders";
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
		//申请退款
		@RequestMapping(value="/applayReturn",method=RequestMethod.POST)
		public String applayReturn(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("reason") String reason,Map<String,Object> map){
			int ordersId = Integer.parseInt(id);
			ordersDetailService.updateReturn(reason,ordersId);
			return "index";
		}
		//支付订单
		@RequestMapping(value="/pay",method=RequestMethod.GET)
		public String pay(HttpServletRequest request,@RequestParam("id") int id,Map<String,Object> map){
			ordersDetailService.updatePay(id);
			return "index";
		}
		//一定日期内订单查询
		@RequestMapping(value="/queryDateOrders",method=RequestMethod.GET)
		public String queryDateOrders(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map,
				@RequestParam("pageId") int pageId,
				@RequestParam("day") int day
				){
			Customer customer  = (Customer) request.getSession().getAttribute("customer");
				int id = customer.getUserId();
				int amount = 0;
				List<Orders> list = new ArrayList<Orders>();
				Page page = new Page();
				amount = ordersDetailService.queryDateAmount(id,day);// 总数量
				page = new Page(amount,pageId);
				list = ordersService.queryDateOrders(id, day, page.getStart());
				map.put("list", list);
				map.put("page", page);
//				map.put("state", state);
				return "orders";
			
		}
		
		
}