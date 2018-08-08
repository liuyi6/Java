package com.example.mall.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.Product;

public interface AdvertisementProductAdminService {
	
	Product queryShopByProductId(Integer productId);
	
	/**
	 * 查询成功申请的产品广告
	 * @param start
	 * @param end
	 * @return
	 */
	List<AdvertisementProduct> querySuccessfulApplicatonProduct(Date start,Date end);
	
	/**
	 * 分页查询产品广告申请
	 * @param time
	 * @param start
	 * @param offset
	 * @return
	 */
	List<AdvertisementProduct> queryPageAdvertisementProduct(@Param("time") Date time,@Param("start") int start,@Param("offset") int offset);
	
	/**
	 * 查询所有申请商品广告
	 * @return
	 */
	public List<AdvertisementProduct> queryAllAdvertisementProduct(Date time);
	
	/**
	 * 根据id同意产品广告申请
	 * @param id
	 */
	public void agreeAdvertisementProduct(Integer id);
	
	/**
	 * 拒绝产品广告申请
	 * @param id
	 */
	public void refuseAdvertisementProduct(Integer id);
}
