package com.example.mall.entity;

import java.util.Date;

public class OrdersDetail {
	private Integer orderDetailId;
	private Integer amount;
	private double price;
	private String userName;
	private Integer enableStatus;//0未支付；1未发货；2未收货；3未评价；4已评价
	private Integer returnStatus; // 0代表默认情况，1代表提出退货申请，2代表退货申请成功，-1代表退货申请失败
	private String returnReason; // 退货理由
	private Date createTime;
	private Date lastEditTime;
	
	private Customer customer;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
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

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
	
	

	public Integer getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Integer returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	@Override
	public String toString() {
		return "OrdersDetail [orderDetailId=" + orderDetailId + ", amount=" + amount + ", price=" + price
				+ ", enableStatus=" + enableStatus + ", returnStatus=" + returnStatus + ", returnReason=" + returnReason
				+ ", createTime=" + createTime + ", lastEditTime=" + lastEditTime + ", customer=" + customer + "]";
	}
	
}
