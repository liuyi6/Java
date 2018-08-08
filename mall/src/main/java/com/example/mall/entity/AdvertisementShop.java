package com.example.mall.entity;

import java.util.Date;

/**
 * 店铺申请广告表
 * @author xiaolinzi
 *
 */
public class AdvertisementShop {
	
	private Integer advertisementShopId;
	
	private Integer shopId;
	
	private String headUrl; // 店铺头像
	
	private Integer enableStatus; // 申请状态，0为审核，-1为拒绝，1为同意
	
	private String shopName; // 店铺的名字
	
	private String shopUrl; // 店铺的URL
	
	private Double price; // 店铺所给的价格
	
	private Date createTime;
	
	private Date lastEditTime;
	
	private Shop shop; // 外键关联

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Integer getAdvertisementShopId() {
		return advertisementShopId;
	}

	public void setAdvertisementShopId(Integer advertisementShopId) {
		this.advertisementShopId = advertisementShopId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	@Override
	public String toString() {
		return "AdvertisementShop [advertisementShopId=" + advertisementShopId + ", shopId=" + shopId + ", headUrl="
				+ headUrl + ", enableStatus=" + enableStatus + ", shopName=" + shopName + ", shopUrl=" + shopUrl
				+ ", price=" + price + ", createTime=" + createTime + ", lastEditTime=" + lastEditTime + "]";
	}
	
	
}
