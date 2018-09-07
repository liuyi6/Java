package com.luis.service;

import java.util.List;

import com.luis.entity.User;

public interface UserService {
	User selectByName(String name);
	List<User> findAllUser(int pageNum, int pageSize);
}
