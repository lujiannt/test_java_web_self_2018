package com.lj.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lj.model.User;

public class DaoTest {
	protected ApplicationContext applicationContext;
	
	/**
	 * 获取spring容器
	 * @author lujian
	 * @create 2018年5月12日
	 */
	@Before
	public void set_up() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	/**
	 * 测试spring_mybatis整合
	 * @author lujian
	 * @throws Exception 
	 * @create 2018年5月12日
	 */
	@Test
	public void test1() throws Exception {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = userDao.getUserById(1);
		System.out.println(user.toString());
	}
	
}
