package com.example.mall.utils;

/**
 * 分页
 * @author xiaolinzi
 *
 */
public class Page {
	private int amount; // 总数量
	private final int pageNum = 5; // 每页展示的数量
	private int currentPage; // 当前页码
	private int start;
	private int allPage; // 总页数
	
	public Page() {}
	
	public Page(int amount,int currentPage) {
		this.amount = amount;
		this.currentPage = currentPage;
		if (amount % pageNum == 0) {
			this.allPage = this.amount / pageNum;
		}else {
			this.allPage = this.amount / pageNum + 1;
		}
		
		this.start = (this.currentPage - 1) * pageNum;
		
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getStart() {
		return start;
	}

	public int getAllPage() {
		return allPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	@Override
	public String toString() {
		return "Page [amount=" + amount + ", pageNum=" + pageNum + ", currentPage=" + currentPage + ", start=" + start
				+ ", allPage=" + allPage + "]";
	}
	
}
