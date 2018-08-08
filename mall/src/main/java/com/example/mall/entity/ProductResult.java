package com.example.mall.entity;

import java.io.Serializable;

public class ProductResult implements Serializable{
	private String name;
	private String type;
	private String tel;
	private int kunumber;
	private String path;
	private double price;
	private int shopId;
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int  shopId) {
		this.shopId = shopId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getKunumber() {
		return kunumber;
	}
	public void setKunumber(int kunumber) {
		this.kunumber = kunumber;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ProductResult [name=" + name + ", type=" + type +  "price=" + price +", tel="
				+ tel + ", kunumber=" + kunumber + ", shopId=" + shopId + ", path=" + path +"]";
	}
	
}
