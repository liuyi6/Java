package com.example.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.mall.dao.ShopAdDao;
import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.AdvertisementShop;
import com.example.mall.service.ShopAdService;

/**
* @author Pencil
* @TODO
*/

@Service
public class ShopAdServiceIMP implements ShopAdService {

	@Resource
	private ShopAdDao shopAdDao;
	
	//申请商铺广告
	@Override
	public void insertShopAd(AdvertisementShop adShop) {
		shopAdDao.insertShopAd(adShop);
	}

	//申请产品广告
	@Override
	public void insertProductAd(AdvertisementProduct adProduct) {
		shopAdDao.insertProductAd(adProduct);
	}

	//商品状态查询
	@Override
	public List<AdvertisementProduct> QueryProductState(Integer shopId) {
		List<AdvertisementProduct> proList = shopAdDao.QueryProductState(shopId);
		return proList;
	}

	//店铺状态查询
	@Override
	public List<AdvertisementShop> QueryShopState(Integer shopId) {
		List<AdvertisementShop> shopList = shopAdDao.QueryShopState(shopId);
		return shopList;
	}
	
	

}
