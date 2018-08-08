package com.example.mall.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.Orders;

/**
 * 销售记录查询
 * @author xiaolinzi
 *
 */
public interface OrderDetailAdminDao {
	
	/**
	 * 根据订单id搜索订单
	 * @param id
	 * @return
	 */
	List<Orders> queryOrderDetailById(String id);
	
	/**
	 * 根据时间来查询销售记录
	 * @param start 
	 * @param end
	 * @return
	 */
	List<Orders> getOrderProduct(@Param("start") Date start,@Param("end") Date end);
}
