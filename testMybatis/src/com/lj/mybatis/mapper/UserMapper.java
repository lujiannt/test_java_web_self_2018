package com.lj.mybatis.mapper;

import java.util.List;

import com.lj.mybatis.model.User;
import com.lj.mybatis.model.UserVo;

/**
 * 如何使用mapper代理
 * @author lujian
 * @create 2018年5月9日
 * @version 1.0
 */
public interface UserMapper {
	//相当于节省了写dao层实现，mybatis会自动生成执行
	//mapper代理开发规范:
	//1.userMapper.xml中namespace要对应该mapper全名
	//2.方法名和userMapper.xml中的id要一致
	//3.方法返回值要一致
	//4.方法参数要一致
	
	
	User getUserById(int id) throws Exception;
	
	/**
	 * 测试mapper编程 返回list
	 * mybatis会自动区分调用selectList和SelectOne
	 * @param userName
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<User> getUsersByName(String userName) throws Exception;
	
	
	/**
	 * 测试包装对象
	 * @param userVo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<UserVo> getUsersByComplex(UserVo userVo) throws Exception;
	
	/**
	 * 测试resultMap (当表列名与model类属性名不一致时使用)
	 * @param userVo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	List<User> getUsersByResulstMap(String userName) throws Exception;
}
