package com.example.mall.dao;

import java.util.List;

import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.AdvertisementShop;

/**
* @author Pencil
* @TODO
*/

public interface ShopAdDao {
	
	public void insertShopAd(AdvertisementShop adShop);
	
	public void insertProductAd(AdvertisementProduct adProduct);
	
	public List<AdvertisementShop> QueryShopState(Integer shopId);
	public List<AdvertisementProduct> QueryProductState(Integer shopId);
}
