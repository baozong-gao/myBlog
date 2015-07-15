package com.gbz.myblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gbz.myblog.bean.User;

@Repository
public interface UserMapper {
	
	public User getUserById(Long Id);
	
	public List<User> getUserByName(String name);
	
	public User getUserByNameAndPass(@Param("name") String name,@Param("password") String pass);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void delUser(Long Id);
}
