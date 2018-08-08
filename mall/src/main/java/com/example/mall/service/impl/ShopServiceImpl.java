package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.ShopDao;
import com.example.mall.entity.Shop;
import com.example.mall.service.ShopService;
@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	ShopDao shopDao;
	@Override
	public Shop queryShopById(int id) {
		
		return shopDao.queryShopById(id);
	}
	@Override
	public List<Shop> shopSerach(String str) {
		
		return shopDao.shopSerach(str);
	}
	@Override
	public Shop queryShopByProductId(int id) {
		return shopDao.queryShopByProductId(id);
	}
}
