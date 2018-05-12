package com.lj.dao;

import com.lj.model.User;

public interface UserDao {
	User getUserById(int id) throws Exception;
}
