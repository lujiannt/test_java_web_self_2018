package com.lj.mapper;

import com.lj.model.User;

/**
 * 如何使用mapper代理
 * @author lujian
 * @create 2018年5月9日
 * @version 1.0
 */
public interface UserMapper {
	//相当于节省了写dao层实现，mybatis会自动生成执行
	//1.userMapper.xml中namespace要对应该mapper全名
	//2.方法名和userMapper.xml中的id要一致
	//3.方法返回值要一致
	//4.方法参数要一致
	
	
	User findUserById(int id) throws Exception;
}
