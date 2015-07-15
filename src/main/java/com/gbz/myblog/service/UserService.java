package com.gbz.myblog.service;

import java.util.List;

import com.gbz.myblog.bean.User;


public interface UserService {

	public User getUserById(Long Id);

	public User getUserByNameAndPass(String name, String pass);

	public List<User> getUserByName(String name);

	public void addUser(User user);

	public void updateUser(User user);

	public void delUser(Long Id);
}
