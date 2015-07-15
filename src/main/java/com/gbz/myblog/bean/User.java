package com.gbz.myblog.bean;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -7056899513938627495L;
	private Long Id;
	private String userName;
	private String password;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
