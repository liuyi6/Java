package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.ProductDao;
import com.example.mall.entity.Product;
import com.example.mall.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product queryProductById(int id) {
		return productDao.queryProductById(id);
	}

	@Override
	public List<Product> productSerach(String str) {
		return productDao.productSerach(str);
	}

	@Override
	public Product queryProductByProductId(int id) {
		return productDao.queryProductByProductId(id);
	}

}
