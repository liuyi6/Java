package com.example.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.CommentDao;
import com.example.mall.entity.Comment;
import com.example.mall.service.CommentService;
@Service
public class CommmentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public void addComment(Comment comment) {
		commentDao.addComment(comment);
	}

}
