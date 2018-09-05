package com.luis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.luis.entity.User;
import com.luis.entity.UserExample;
import com.luis.entity.UserExample.Criteria;
import com.luis.mapper.UserMapper;
import com.luis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User selectByName(String name) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<User> users = userMapper.selectByExample(example);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
	/**
	 * pageNum 开始页数
	 * pageSize 每页显示的数据条数
	 */
	@Override
	public List<User> findAllUser(int pageNum, int pageSize) {
		//将参数传给方法实现分页
        PageHelper.startPage(pageNum, pageSize);
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
        return list;
	}
}
