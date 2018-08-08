package com.example.mall.service;

import java.util.List;

import com.example.mall.entity.Product;

public interface ProductService {
	public Product queryProductById(int id);
	public List<Product> productSerach(String str);
	public Product queryProductByProductId(int id);
}
