package com.example.mall.service;

import org.apache.ibatis.annotations.Param;

import com.example.mall.entity.Admin;

public interface AdminService {
	
	/**
	 * 管理员登录
	 * @param name
	 * @param password
	 * @return
	 */
	public Admin loginAdmin(@Param("name") String name,@Param("password") String password);
}
