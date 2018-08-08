package com.example.mall.service;


import java.util.List;

import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.AdvertisementShop;

/**
* @author Pencil
* @TODO  申请店铺广告和商品广告
*/


public interface ShopAdService {
	
	//申请商铺广告
	public void insertShopAd(AdvertisementShop adShop);
	
	//申请产品广告
	public void insertProductAd(AdvertisementProduct adProduct);
	
	//状态查询
	public List<AdvertisementProduct> QueryProductState(Integer shopId);
	
	public List<AdvertisementShop> QueryShopState(Integer shopId);
}
