package com.cbz.info.dao;

import com.cbz.info.bean.User;

public interface UserDao {
	
	public User validate(String name,String password);
	
	

}
