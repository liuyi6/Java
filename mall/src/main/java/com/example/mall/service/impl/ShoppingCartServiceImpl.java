package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.ShoppingCartDao;
import com.example.mall.entity.ShoppingCart;
import com.example.mall.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Override
	public void addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartDao.addShoppingCart(shoppingCart);
	}

	@Override
	public void deleteShoppingCart(int cartId) {
		shoppingCartDao.deleteShoppingCart(cartId);
	}

	@Override
	public ShoppingCart updataAmount(int cartId) {
		return shoppingCartDao.updataAmount(cartId);
	}

	@Override
	public List<ShoppingCart> queryShoppingCartsById(int id) {
		// TODO Auto-generated method stub
		return shoppingCartDao.queryShoppingCartsById(id);
	}
	
}
