package com.example.mall.service;

import java.util.List;

import com.example.mall.entity.Shop;

public interface ShopService {
	public Shop queryShopById(int id);
	public List<Shop> shopSerach(String str);
	public Shop queryShopByProductId(int id);
}
