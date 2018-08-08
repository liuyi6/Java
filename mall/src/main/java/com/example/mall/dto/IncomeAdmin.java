package com.example.mall.dto;

import java.io.Serializable;

public class IncomeAdmin implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Double rate; // 佣金率
	
	private Integer amount; // 订单数量
	
	private Double orderIncome; // 订单抽成收入
	
	private Double advertisementIncome; // 广告收入
	
	public IncomeAdmin() {
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getOrderIncome() {
		return orderIncome;
	}

	public void setOrderIncome(Double orderIncome) {
		this.orderIncome = orderIncome;
	}

	public Double getAdvertisementIncome() {
		return advertisementIncome;
	}

	public void setAdvertisementIncome(Double advertisementIncome) {
		this.advertisementIncome = advertisementIncome;
	}
}
