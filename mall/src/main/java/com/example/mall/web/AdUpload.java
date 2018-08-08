package com.example.mall.web;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.AdvertisementShop;
import com.example.mall.entity.ProductResult2;
import com.example.mall.service.ShopAdService;
import com.example.mall.utils.FileUpload;

/**
* @author Pencil
* @TODO	上传店铺广告和店铺商品广告
*/

@Controller
@RequestMapping("/upload")
public class AdUpload {
	
	@Autowired
	private ShopAdService shopAdService;
	String url = "/shopurl.do";
	//上传店铺
	@RequestMapping(value = "/adShop.action")
	@ResponseBody
	public AdvertisementShop uploadShop(
			@RequestParam(value="shopId",required=false)Integer shopId,
			@RequestParam(value="price",required=false)Double price,
			@RequestParam(value="shopName",required=false)String shopName,
			@RequestParam(value="file",required=false)MultipartFile file)throws Exception {
		AdvertisementShop adShop = new AdvertisementShop();
		adShop.setShopId(shopId);
		adShop.setPrice(price);
		adShop.setShopName(shopName);
		adShop.setShopUrl(url);
		String url = FileUpload.uploadFile(file);
		adShop.setHeadUrl(url);
		adShop.setCreateTime(new Date());
		shopAdService.insertShopAd(adShop);
		return null;
	}
	
	//商品广告
	String proUrl = "/prourl.do";
	@RequestMapping(value = "/adProduct.action")
	@ResponseBody
	public String uploadProduct(
			@RequestParam(value="proName",required=false)String productName,
			@RequestParam(value="Pprice",required=false)Double price,
			@RequestParam(value="img",required=false)String imageUrl,
			@RequestParam(value="proId",required=false)Integer ProId,
			@RequestParam(value="shopId",required=false)Integer shopId
			) throws Exception{
		AdvertisementProduct adProduct = new AdvertisementProduct();
		adProduct.setShopId(shopId);
		adProduct.setProductId(ProId);
		adProduct.setPrice(price);
		adProduct.setProductUrl(proUrl);
		adProduct.setProductName(productName);
		adProduct.setImageUrl(imageUrl);
		adProduct.setCreateTime(new Date());
		shopAdService.insertProductAd(adProduct);
		return "school";
	}
	
	
	//查询产品状态
	@RequestMapping(value="/queryProstate.action")
	@ResponseBody
	public ProductResult2 QueryState(
			@RequestParam(value="shopId",required=false)Integer shopId){
		List<AdvertisementProduct> list = shopAdService.QueryProductState(shopId);
		ProductResult2 result2 = new ProductResult2();
		result2.setData(list);
		
		return result2;
	}
	
	
	//查询店铺状态
		@RequestMapping(value="/queryShopState.action")
		@ResponseBody
		public ProductResult2 QueryShopState(@RequestParam(value="shopId",required=false)Integer shopId){
			List<AdvertisementShop> list = shopAdService.QueryShopState(shopId);
			ProductResult2 result2 = new ProductResult2();
			result2.setData(list);
			return result2;
		}
	
}
