package com.example.mall.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.mall.entity.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TestAccountInfoDao {
	
	@Autowired
	private CustomerAdminDao accountInfoDao;
	
	@Test
	public void testQueryAccountList() {
		List<Customer> accountInfos = accountInfoDao.queryAccountList();
		assertEquals(1, accountInfos.size());
	}
	
	@Test
	public void testQueryAccountById() {
		Integer userId = 2;
		Customer accountInfo = accountInfoDao.queryAccountById(userId);
		assertNotNull(accountInfo);
	}
	
	@Test
	public void testQueryAccountByName() {
		String userName = "xiao";
		List<Customer> accounts = accountInfoDao.queryAccountByName(userName);
		assertEquals(1,accounts.size());
	}
	
	@Test
	public void testAddUserBlackList() {
		Integer userId = 3;
		accountInfoDao.addUserBlackList(userId);
		Customer accountInfo = accountInfoDao.queryAccountById(userId);
		System.out.println(accountInfo);
	}
	
	@Test
	public void testQueryBlackList() {
		List<Customer> accountInfos = accountInfoDao.queryBlackList();
		assertEquals(1, accountInfos.size());
	}
}
