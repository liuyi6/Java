package com.example.mall.entity;

import java.util.Date;

/**
 * 
 * @author luis
 *收藏表
 */
public class Collect {
	private int collectId;
	private Date createTime;
	private Date lastEditTime;
	
	private Customer customer;
	private Shop shop;
	public int getCollectId() {
		return collectId;
	}
	public void setCollectId(int collectId) {
		this.collectId = collectId;
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
	@Override
	public String toString() {
		return "Collect [collectId=" + collectId + ", createTime=" + createTime + ", lastEditTime=" + lastEditTime
				+ ", customer=" + customer + ", shop=" + shop + "]";
	}
	
}
