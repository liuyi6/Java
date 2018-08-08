package com.example.mall.web;

import java.io.UnsupportedEncodingException;
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

import com.example.mall.entity.Product;
import com.example.mall.service.ProductService;

@Controller
public class ProductUserController {
	@Autowired
	private ProductService productService;
	
	/*产品搜索*/
	@RequestMapping(value="/productSerach",method=RequestMethod.GET)
	public String productSerach(HttpServletRequest request,@RequestParam("content") String productName,Map<String,Object> map) throws UnsupportedEncodingException{
		String name = new String(productName.getBytes("ISO-8859-1"),"utf-8");
		List<Product> list = productService.productSerach(name);
		map.put("list", list);
		return "serach";
	}
	
	@RequestMapping(value="/productChoose",method=RequestMethod.GET)
	public String productChoose(HttpServletResponse response,@RequestParam("id") int id) {
		Cookie cookie = new Cookie("productId",""+id);
		response.addCookie(cookie);
		return "news_detail";
	}
}
