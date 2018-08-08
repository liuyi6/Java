package com.example.mall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.Customer;

/**
 * 管理员管理用户的接口
 * @author xiaolinzi
 *
 */
public interface CustomerAdminService {
	
	/**
	 * 根据用户ID删除用户
	 * @param userId
	 */
	void deleteCustomerById(Integer userId);
	
	/**
	 * 根据用户id，将用户移除黑名单
	 * @param userId
	 */
	void removeUserBlackList(Integer userId);
	
	/**
	 * 查询用户列表
	 * @return
	 */
	List<Customer> queryAccountList();
	
	/**
	 * 根据用户id来查询用户
	 * @param userId
	 * @return
	 */
	Customer queryAccountById(Integer userId);
	
	/**
	 * 根据名字搜索用户
	 * @param name
	 * @return
	 */
	List<Customer> queryAccountByName(String userName);
	
	/**
	 * 分页查询
	 * @param start
	 * @param offset
	 * @return
	 */
	List<Customer> queryAccountByPage(@Param("start") Integer start,@Param("offset") Integer offset);
	
	/**
	 * 根据用户id，将用户加入黑名单
	 * @param id
	 */
	void addUserBlackList(Integer userId);
	
	/**
	 * 查询所有黑名单
	 * @return
	 */
	List<Customer> queryBlackList();
}
