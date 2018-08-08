package com.example.mall.dao;

import java.util.List;

import com.example.mall.entity.Collect;

public interface CollectDao {
	public void addCollect(Collect collect);
	public void deletCollect(int collectId);
	public List<Collect> queryCollectById(int id);
}
