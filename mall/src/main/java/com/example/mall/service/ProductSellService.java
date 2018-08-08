package com.example.mall.service;

import java.util.Date;

import com.example.mall.entity.ProductResult;
import com.example.mall.entity.ProductResult2;

public interface ProductSellService {
	public ProductResult addProduct(String productName,String shopCategoryName
			,int productCount,String imgAddr,int shopId,double price);
	public ProductResult2 showProduct(int shopId);
	public ProductResult2 pageProduct(int shopId,int num);
	public ProductResult2 updateProduct(Integer productId,String productName,String type,Double price,Integer kunumber,String path,String desc);
	public ProductResult2 deleteProduct(Integer ProductId);
	public ProductResult2 save(String userName,String password,String shopName,String shopAddres,String shopPhone,String shopEmail);
	public ProductResult2 findShopId(String account);
	public ProductResult2 login(String account,String password);
	public ProductResult2 findByProductId(String productId);
	public ProductResult2 findByShopId(String shopId);
	
	public ProductResult2 selectOrders(Date start, Date end, Integer shopId);
	public ProductResult2 selecctCustomer(String detailId);

}
