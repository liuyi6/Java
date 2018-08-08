package com.example.mall.entity;

import java.util.Date;

/**
 * 
 * @author luis
 *订单评论表
 */
public class Comment {
	private int commentId;
	private String content;
	private Date createTime;
	private Date lastEditTime;
	
	private Customer customer;
	private Orders orders;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", content=" + content + ", createTime=" + createTime
				+ ", lastEditTime=" + lastEditTime + ", customer=" + customer + ", orders=" + orders + "]";
	}
}
