package com.example.mall.service;

import java.util.List;

import com.example.mall.entity.Collect;

public interface CollectService {
	public void addCollect(Collect collect);
	public void deletCollect(int collectId);
	public List<Collect> queryCollectById(int id);
}
