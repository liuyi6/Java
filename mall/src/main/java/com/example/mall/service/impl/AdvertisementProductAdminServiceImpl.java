package com.example.mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.AdvertisementProductAdminDao;
import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.Product;
import com.example.mall.service.AdvertisementProductAdminService;

@Service
public class AdvertisementProductAdminServiceImpl implements AdvertisementProductAdminService{
	
	@Autowired
	private AdvertisementProductAdminDao aProductAdminDao;
	
	@Override
	public List<AdvertisementProduct> queryAllAdvertisementProduct(Date time) {
		return aProductAdminDao.queryAllAdvertisementProduct(time);
	}

	@Override
	public void agreeAdvertisementProduct(Integer id) {
		aProductAdminDao.agreeAdvertisementProduct(id);
	}

	@Override
	public void refuseAdvertisementProduct(Integer id) {
		aProductAdminDao.refuseAdvertisementProduct(id);
	}

	@Override
	public List<AdvertisementProduct> queryPageAdvertisementProduct(Date time, int start, int offset) {
		return aProductAdminDao.queryPageAdvertisementProduct(time,start,offset);
	}

	@Override
	public List<AdvertisementProduct> querySuccessfulApplicatonProduct(Date start, Date end) {
		return aProductAdminDao.querySuccessfulApplicatonProduct(start, end);
	}

	@Override
	public Product queryShopByProductId(Integer productId) {
		return aProductAdminDao.queryShopByProductId(productId);
	}

}
