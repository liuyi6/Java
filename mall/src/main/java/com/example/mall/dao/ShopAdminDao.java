package com.example.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.Shop;

public interface ShopAdminDao {
	
	/**
	 * 根据商铺id将此商铺从黑名单中移除
	 * @param shopId
	 */
	void removeShopBlacklist(Integer shopId);
	
	/**
	 * 查询所有店主
	 * @return
	 */
	List<Shop> queryShopList();
	
	/**
	 * 查询所有黑名单的商家
	 * @return
	 */
	List<Shop> queryShopBlackList();
	
	/**
	 * 查询所有申请审核的店家
	 * @return
	 */
	List<Shop> queryApplyShop();
	
	/**
	 * 批准店家请求
	 * @param shopId
	 */
	void approveShopRequest(Integer shopId);
	
	/**
	 * 更新商家的类型
	 * @param userId
	 */
	void updateShopAccount(Integer userId);
	
	/**
	 * 拒绝店家请求
	 * @param shopId
	 */
	void refuseShopRequest(Integer shopId);
	
	/**
	 * 根据店主的名字进行模糊查询
	 * @param userName
	 * @return
	 */
	List<Shop> queryShopByUserName(String userName);
	
	/**
	 * 根据店铺的名字进行模糊查询
	 * @param shopName
	 * @return
	 */
	List<Shop> queryShopByShopName(String shopName);
	
	/**
	 * 正常店家的分页查询
	 * @param start
	 * @param offset
	 * @return
	 */
	List<Shop> queryShopByPage(@Param("start") Integer start,@Param("offset") Integer offset);
	
	/**
	 * 待审核店家的分页查询
	 * @param start
	 * @param offset
	 * @return
	 */
	List<Shop> queryApplyShopByPage(@Param("start") Integer start,@Param("offset") Integer offset);
	
	/**
	 * 根据商家id将店铺加入黑名单
	 * @param shopId
	 */
	void addShopBlackList(Integer shopId);
	
	/**
	 * 根据商家的id号删除商家
	 * @param shopId
	 */
	void deleteShop(Integer shopId);
}
