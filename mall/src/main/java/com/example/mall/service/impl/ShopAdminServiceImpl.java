package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.ShopAdminDao;
import com.example.mall.entity.Shop;
import com.example.mall.service.ShopAdminService;

@Service
public class ShopAdminServiceImpl implements ShopAdminService{
	
	@Autowired
	private ShopAdminDao shopAdminDao;
	
	@Override
	public void removeShopBlacklist(Integer shopId) {
		shopAdminDao.removeShopBlacklist(shopId);
	}
	
	@Override
	public List<Shop> queryShopList() {
		return shopAdminDao.queryShopList();
	}
	
	@Override
	public List<Shop> queryApplyShop() {
		return shopAdminDao.queryApplyShop();
	}

	@Override
	public void approveShopRequest(Integer shopId) {
		shopAdminDao.approveShopRequest(shopId);
	}

	@Override
	public void refuseShopRequest(Integer shopId) {
		shopAdminDao.refuseShopRequest(shopId);
	}

	@Override
	public List<Shop> queryShopByUserName(String userName) {
		return shopAdminDao.queryShopByUserName(userName);
	}

	@Override
	public List<Shop> queryShopByShopName(String shopName) {
		return shopAdminDao.queryShopByShopName(shopName);
	}

	@Override
	public void addShopBlackList(Integer shopId) {
		shopAdminDao.addShopBlackList(shopId);
	}

	@Override
	public void deleteShop(Integer shopId) {
		shopAdminDao.deleteShop(shopId);
	}

	@Override
	public List<Shop> queryShopByPage(Integer start, Integer offset) {
		return shopAdminDao.queryShopByPage(start, offset);
	}
	
	@Override
	public List<Shop> queryApplyShopByPage(Integer start, Integer offset) {
		return shopAdminDao.queryApplyShopByPage(start, offset);
	}

	@Override
	public List<Shop> queryShopBlackList() {
		return shopAdminDao.queryShopBlackList();
	}
}
