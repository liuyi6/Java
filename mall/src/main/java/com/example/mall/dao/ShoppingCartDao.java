package com.example.mall.dao;

import java.util.List;

import com.example.mall.entity.ShoppingCart;

public interface ShoppingCartDao {
	public void addShoppingCart(ShoppingCart shoppingCart);
	public void deleteShoppingCart(int cartId);
	public ShoppingCart updataAmount(int cartId);
	public List<ShoppingCart> queryShoppingCartsById(int id);
}
