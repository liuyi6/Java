package com.example.mall.entity;

import java.util.Date;

public class Orders {
	private Integer ordersId;
	private double price;
	private Date createTime;
	private Date lastEditTime;

	private int productId;
	private int shopId;
	private String shopName;
	private int productAmount;

	private OrdersDetail ordersDetail;
	private Shop shop;
	private Product product;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public Integer getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public OrdersDetail getOrdersDetail() {
		return ordersDetail;
	}

	public void setOrdersDetail(OrdersDetail ordersDetail) {
		this.ordersDetail = ordersDetail;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", price=" + price + ", createTime=" + createTime + ", lastEditTime="
				+ lastEditTime + ", ordersDetail=" + ordersDetail + ", shop=" + shop + ", product=" + product + "]";
	}
}
