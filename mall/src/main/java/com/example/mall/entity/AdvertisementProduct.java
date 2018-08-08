package com.example.mall.entity;

import java.util.Date;

public class AdvertisementProduct {
	
	private Integer advertisementProductId;
	
	private Integer shopId;
	
	private Integer productId;
	
	private String productName;
	
	private String imageUrl; // 产品图片
	
	private String productUrl; // 访问产品的URL
	
	private Integer enableStatus; // 0代表审核，-1代表拒绝，1代表同意
	
	private Double price;
	
	private Date createTime;
	
	private Date lastEditTime;
	
	private Product product;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAdvertisementProductId() {
		return advertisementProductId;
	}

	public void setAdvertisementProductId(Integer advertisementProductId) {
		this.advertisementProductId = advertisementProductId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
}
