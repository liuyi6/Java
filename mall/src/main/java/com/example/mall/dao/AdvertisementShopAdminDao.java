package com.example.mall.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.AdvertisementShop;

public interface AdvertisementShopAdminDao {
	
	/**
	 * 查询所在时间段内成功店铺申请
	 * @param start
	 * @param end
	 * @return
	 */
	List<AdvertisementShop> querySuccessfulApplicationShop(@Param("start") Date start,@Param("end") Date end);
	
	/**
	 * 查询所有申请店铺广告的店铺
	 * @param time 当天申请第二天的广告位
	 * @return
	 */
	List<AdvertisementShop> queryAllAdvertisementShop(Date time);
	
	/**
	 * 查询所有同意请求的店铺
	 * @param time
	 * @return
	 */
	List<AdvertisementShop> queryAllAgreeAdvertisementShop(Date time);
	
	/**
	 * 同意店铺的申请
	 * @param shopId
	 */
	void agreeAdvertisementShop(Integer advertisementShopId);
	
	/**
	 * 拒绝店铺的申请
	 * @param advertisementShopId
	 */
	void refuseAdvertisementShop(Integer advertisementShopId);
}
