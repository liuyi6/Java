package com.example.mall.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.AdvertisementProduct;
import com.example.mall.entity.Product;

public interface AdvertisementProductAdminDao {
	
	Product queryShopByProductId(Integer productId);
	
	/**
	 * 查询成功申请的产品广告
	 * @param start
	 * @param end
	 * @return
	 */
	List<AdvertisementProduct> querySuccessfulApplicatonProduct(@Param("start") Date start,@Param("end") Date end);
	
	/**
	 * 分页查询产品广告申请
	 * @param page
	 * @return
	 */
	List<AdvertisementProduct> queryPageAdvertisementProduct(@Param("time") Date time,@Param("start") Integer start,@Param("offset") Integer offset);
	
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
