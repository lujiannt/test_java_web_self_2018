package com.lj.mybatis.mapper;

import java.util.List;

import com.lj.mybatis.model.User;

public interface UserMapper {
	//相当于节省了写dao层实现，mybatis会自动生成执行
	//1.userMapper.xml中namespace要对应该mapper全名
	//2.方法名和userMapper.xml中的id要一致
	//3.方法返回值要一致
	//4.方法参数要一致
	User getUserById(int id) throws Exception;
	
	//测试mapper编程 返回list
	//mybatis会自动区分调用selectList和SelectOne
	List<User> getUsersByName(String userName) throws Exception;
}
