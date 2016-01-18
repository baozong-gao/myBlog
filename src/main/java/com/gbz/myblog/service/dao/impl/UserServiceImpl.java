package com.gbz.myblog.service.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbz.myblog.bean.User;
import com.gbz.myblog.mapper.UserMapper;
import com.gbz.myblog.service.dao.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(Long Id) {

		return userMapper.getUserById(Id);
	}

	@Override
	public List<User> getUserByName(String name) {

		return userMapper.getUserByName(name);
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void delUser(Long Id) {
		userMapper.delUser(Id);
	}

	@Override
	public User getUserByNameAndPass(String name, String pass) {
		if(name == null || pass == null){
			logger.error("获取user数据失败，user：{}，pass：{}", name , pass );
			return null;
		}
		
		return userMapper.getUserByNameAndPass(name, pass);
	}

}
