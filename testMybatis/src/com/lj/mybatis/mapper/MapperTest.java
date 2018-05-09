package com.lj.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lj.mybatis.model.*;

public class MapperTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void buildFactory() throws IOException {
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	
	
	/**
	 * 测试简单mapper编程_1
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(3);
		System.out.println(user.toString());
		
		sqlSession.close();
	}
	
	/**
	 * 测试简单mapper编程_2
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test2() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.getUsersByName("涛");
		System.out.println(list.toString());
		
		sqlSession.close();
	}
	
	/**
	 * 测试简单mapper编程_包装类
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test3() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUserName("周涛");
		UserVo userVo = new UserVo();
		userVo.setUser(user);
		List<UserVo> list = userMapper.getUsersByComplex(userVo);
		System.out.println(list.toString());
		
		sqlSession.close();
	}
}
