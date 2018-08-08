package com.example.mall.service;

import java.util.List;

import com.example.mall.entity.ShoppingCart;

public interface ShoppingCartService {
	public void addShoppingCart(ShoppingCart shoppingCart);
	public void deleteShoppingCart(int cartId);
	public ShoppingCart updataAmount(int cartId);
	public List<ShoppingCart> queryShoppingCartsById(int id);
}
