package com.example.mall.web;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import com.example.mall.utils.DateSwitch;
import com.example.mall.utils.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.mall.entity.ProductResult;
import com.example.mall.entity.ProductResult2;
import com.example.mall.service.ProductSellService;

@Controller
@RequestMapping("/product")
public class ProductSellController {
	@Resource
	private ProductSellService service;
	
	
	@RequestMapping("/selectOrders.do")
	@ResponseBody
	public ProductResult2 excute11(String selectWay,String date,Integer shopId)throws ParseException {
		Date[] dates= DateSwitch.timeConversion(selectWay,date);
		System.out.println(selectWay+" "+date+" "+shopId);

		ProductResult2 result=service.selectOrders(dates[0],dates[1],shopId);
		System.out.println(result);
		return result;

	}
	
	
	@RequestMapping("/selectCustomer.do")
	@ResponseBody
	public ProductResult2 excute12(String detailId) {


		ProductResult2 result=service.selecctCustomer(detailId);
		return result;

	}

	
	@RequestMapping("/addProduct.do")
	@ResponseBody
	public ProductResult excute(// 增加商品
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "type", required = false) String type,
			@RequestParam(name = "kunumber", required = false) Integer kunumber,
			@RequestParam(name = "path", required = false) MultipartFile path,
			@RequestParam(name = "shopId", required = false) Integer shopId,
			@RequestParam(name = "price", required = false) Double price) throws Exception {

		String url = FileUpload.uploadFile(path);

		ProductResult result = service.addProduct(name, type, kunumber, url, shopId, price);
		return result;

	}

	@RequestMapping("/showProduct.do")
	@ResponseBody // 计算页数
	public ProductResult2 excute2(int shopId) {
		ProductResult2 result = service.showProduct(shopId);
		return result;

	}

	@RequestMapping("/pageProduct.do")
	@ResponseBody
	public ProductResult2 excute3(int shopId, int num) {// 查询页数商品
		ProductResult2 result = service.pageProduct(shopId, num);
		return result;

	}

	@RequestMapping("/modifyProduct.do")
	@ResponseBody
	public ProductResult2 excute4(@RequestParam(name = "productId", required = false) Integer productId,
			@RequestParam(name = "productName", required = false) String productName,
			@RequestParam(name = "type", required = false) String type,
			@RequestParam(name = "price", required = false) Double price,
			@RequestParam(name = "kunumber", required = false) Integer kunumber,
			@RequestParam(name = "path", required = false) MultipartFile path,
			@RequestParam(name = "desc", required = false) String desc) throws Exception {
		String url = FileUpload.uploadFile(path);

		ProductResult2 result = service.updateProduct(productId, productName, type, price, kunumber, url, desc);
		return result;

	}

	@RequestMapping("/deleteProduct.do")
	@ResponseBody
	public ProductResult2 excute5(Integer productId) {

		ProductResult2 result = service.deleteProduct(productId);
		return result;

	}

	@RequestMapping("/saveUser.do")
	@ResponseBody
	public ProductResult2 excute6(String userName, String password, String shopName, String shopAddres,
			String shopPhone, String shopEmail) {

		ProductResult2 result = service.save(userName, password, shopName, shopAddres, shopPhone, shopEmail);
		return result;

	}

	@RequestMapping("/findShopId.do")
	@ResponseBody
	public ProductResult2 excute7(String account) {

		ProductResult2 result = service.findShopId(account);
		return result;

	}

	@RequestMapping("/login.do")
	@ResponseBody
	public ProductResult2 excute8(String account, String password) {
		ProductResult2 result = service.login(account, password);
		return result;

	}

	@RequestMapping("/findByProductId.do")
	@ResponseBody
	public ProductResult2 excute9(String productId) {
		ProductResult2 result = service.findByProductId(productId);
		return result;
	}

	@RequestMapping("/findShopName.do")
	@ResponseBody
	public ProductResult2 excute10(String shopId) {
		ProductResult2 result = service.findByShopId(shopId);
		return result;
	}
}