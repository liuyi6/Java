package com.example.mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.AdvertisementShopAdminDao;
import com.example.mall.entity.AdvertisementShop;
import com.example.mall.service.AdvertisementShopAdminService;

@Service
public class AdvertisementShopAdminServiceImpl implements AdvertisementShopAdminService{
	
	@Autowired
	private AdvertisementShopAdminDao advertisementShopAdminDao;

	@Override
	public List<AdvertisementShop> queryAllAdvertisementShop(Date time) {
		return advertisementShopAdminDao.queryAllAdvertisementShop(time);
	}

	@Override
	public List<AdvertisementShop> queryAllAgreeAdvertisementShop(Date time) {
		return advertisementShopAdminDao.queryAllAgreeAdvertisementShop(time);
	}

	@Override
	public void agreeAdvertisementShop(Integer advertisementShopId) {
		advertisementShopAdminDao.agreeAdvertisementShop(advertisementShopId);
	}

	@Override
	public void refuseAdvertisementShop(Integer advertisementShopId) {
		advertisementShopAdminDao.refuseAdvertisementShop(advertisementShopId);
	}

	@Override
	public List<AdvertisementShop> querySuccessfulApplicationShop(Date start, Date end) {
		return advertisementShopAdminDao.querySuccessfulApplicationShop(start, end);
	}
}
