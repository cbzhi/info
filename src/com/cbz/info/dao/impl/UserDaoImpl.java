package com.cbz.info.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cbz.info.bean.User;
import com.cbz.info.dao.UserDao;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User validate(String name, String password) {
		String hql = "from "+ entityClazz +" u where u.name=? and u.password=?";
		String[] values = {name,password};
		List<User> users = (List<User>) hibernateTemplate.find(hql, values);
		if(users.size()>0){
			return users.get(0);
		} else {
			return null ;
		}
	}

}
