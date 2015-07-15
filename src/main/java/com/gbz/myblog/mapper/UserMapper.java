package com.gbz.myblog.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gbz.myblog.bean.User;

@Repository
public interface UserMapper {
	
	public User getUserById(Long Id);
	
	public List<User> getUserByName(String name);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void delUser(Long Id);
}
