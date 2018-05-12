package com.lj.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lj.model.User;

public class MapperTest {
	protected ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	/**
	 * 普通mapper测试 
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月12日
	 */
	@Test
	public void test1() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(2);
		System.out.println(user.toString());
	}
	
	/**
	 * mapper_annotation测试_查询
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月12日
	 */
	@Test
	public void test2() throws Exception {
		UserAnnotationMapper userMapper = (UserAnnotationMapper) applicationContext.getBean("userAnnotationMapper");
		User user = userMapper.findUser_annotation(1);
		System.out.println(user.toString());
	}
	
	/**
	 * mapper_annotation测试_插入
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月12日
	 */
	@Test
	public void test3() throws Exception {
		UserAnnotationMapper userMapper = (UserAnnotationMapper) applicationContext.getBean("userAnnotationMapper");
		User user = new User();
		user.setUserName("蔡依林");
		user.setAge(40);
		userMapper.addUser_annotation(user);
		System.out.println(user.toString());
	}
}
