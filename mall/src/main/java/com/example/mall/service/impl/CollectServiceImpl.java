package com.example.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.CollectDao;
import com.example.mall.entity.Collect;
import com.example.mall.service.CollectService;
@Service
public class CollectServiceImpl implements CollectService{
	@Autowired
	private CollectDao collectDao;
	
	@Override
	public void addCollect(Collect collect) {
		collectDao.addCollect(collect);
	}
	
	@Override
	public void deletCollect(int collectId) {
		collectDao.deletCollect(collectId);
	}
	
	@Override
	public List<Collect> queryCollectById(int id) {
		return collectDao.queryCollectById(id);
	}
}
