package com.luis.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.luis.entity.User;
import com.luis.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test")
	public User querUserByName() {
		User user = userService.selectByName("wanger");
		System.out.println(user.toString());
		return user;
	}
	
	@RequestMapping("/list")
	public List<User> querUser() {
		List<User> list = userService.findAllUser(1, 2);
		//获取分页信息
		PageInfo<User> pageInfo = new PageInfo<>(list);
		System.out.println("total:" + pageInfo.getTotal());
		System.out.println("pages:" + pageInfo.getPages());
		System.out.println("pageSize:" + pageInfo.getPageSize());
		return list;
	}
}
