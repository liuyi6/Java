package com.example.mall.entity;

import java.util.Date;

public class ShoppingCart {
	
	private Integer cartId;
	private Integer amount;//商品数量
	private double price;
	private Integer checked;//是否勾选
	private Date createTime;
	private Date lastEditTime;
	
	//和外键相关
	private Customer customer;
	private Shop shop;
	private Product product;
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "ShoppingCart [cartId=" + cartId + ", amount=" + amount + ", price=" + price + ", checked=" + checked
				+ ", createTime=" + createTime + ", lastEditTime=" + lastEditTime + ", customer=" + customer + ", shop="
				+ shop + ", product=" + product + "]";
	}
	
	
}
