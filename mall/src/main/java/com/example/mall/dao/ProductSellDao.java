package com.example.mall.dao;

import java.util.Date;
import java.util.List;

import com.example.mall.entity.Shop;
import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.OrdersDetail;
import com.example.mall.entity.Product;
import com.example.mall.entity.SellOrder;

/**
 * 增加商品
 * 
 * @author Evan
 *
 */
public interface ProductSellDao {

	public void addProduct(Product pro);// 添加商品

	public List<Product> showProduct(int shopId);// 进入店铺展示所有商品

	public List<Product> pageProduct(@Param("shopId") int shopId, @Param("num") int num);

	public void updateProduct(Product pro);

	public void deleteProduct(Integer pro);// 删除商品

	public void save(Shop shop);

	public Shop findByAccount(String userName);

	public Shop findByShopName(String shopName);

	public String findShopId(String account);

	public Shop login(String account);

	public Product findByProductId(String productId);

	public String findByShopId(String shopId);
	
	public List<SellOrder> selectOrders(Date start, Date end, Integer shopId);
	public OrdersDetail selecctCustomer(String detailId);
}
