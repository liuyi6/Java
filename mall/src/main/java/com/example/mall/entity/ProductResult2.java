package com.example.mall.entity;

import java.io.Serializable;

public class ProductResult2 implements Serializable{
	private Object data;//数据
	private int num;//数据长度
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ProductResult2 [data=" + data + ", num=" + num + "]";
	}

	
	
	
}
