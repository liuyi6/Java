package com.example.mall.dao;

import java.util.List;

import com.example.mall.entity.Product;

public interface ProductDao {
	public Product queryProductById(int id);
	public List<Product> productSerach(String str);
	public Product queryProductByProductId(int id);
}
