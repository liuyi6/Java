package com.example.mall.entity;

/**
 * 商品表
 * @author xiaolinzi
 *
 */
public class Product {
	
	private Integer productId;
	
	private Integer shopId;

	private String productName;
	
	private String productDesc;
	
	private String shopCategoryName;
	
	private Double productPrice;
	
	private Integer productCount; // 商品库存量
	
	private String imgAddr; // 商品图片地址
	
	private Integer enableStatus; // 1 代表商品上架   0代表商品下架了
	private Integer  commentNum;
	private Integer purchaseNum;
	
	private Shop shop;
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getShopCategoryName() {
		return shopCategoryName;
	}

	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

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

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", shopId=" + shopId + ", productName=" + productName
				+ ", productDesc=" + productDesc + ", shopCategoryName=" + shopCategoryName + ", productPrice="
				+ productPrice + ", productCount=" + productCount + ", imgAddr=" + imgAddr + ", enableStatus="
				+ enableStatus + ", commentNum=" + commentNum + ", purchaseNum=" + purchaseNum + "]";
	}
}
