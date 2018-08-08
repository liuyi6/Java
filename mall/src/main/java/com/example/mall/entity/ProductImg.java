package com.example.mall.entity;

import java.util.Date;

/**
 * 商品图片
 * @author xiaolinzi
 *
 */
public class ProductImg {
	
	private Integer productImgId;
	
	private String imgAddr;
	
	private String imgDesc;
	
	private Integer productId;
	
	private Date createTime;
	
	private Date lastEditTime;

	public Integer getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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
