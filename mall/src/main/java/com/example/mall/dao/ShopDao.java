package com.example.mall.dao;

import java.util.List;

import com.example.mall.entity.Shop;

public interface ShopDao {
	public Shop queryShopById(int id);
	public Shop queryShopByProductId(int id);
	public List<Shop> shopSerach(String str);
}
