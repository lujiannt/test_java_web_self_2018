package com.lj.base.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lj.mybatis.model.User;

public class TestMybatis {
	public static final SqlSessionFactory sqlSessionFactory = buildFactory();
	
	public static SqlSessionFactory buildFactory() {
		InputStream is;
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			
			is = Resources.getResourceAsStream("SqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	/*------------------------------------------------------------------------------------*/
	
	/**
	 * 入门 -根据id获取user
	 * 使用简单参数传递参数   注:简单参数时，xml中占位符中的变量名可以不一致
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test1() throws IOException {
		//1.读取config文件，创建SqlSessionFactory
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		//2.获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//3.具体操作
		User user = sqlSession.selectOne("user.getUserById1", 1);
		System.out.println(user.toString());

		//4.关闭sqlSession
		sqlSession.close();
	}
	
	/**
	 * 入门 -根据id获取user
	 * 使用map传递参数
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test2() throws IOException {
		//1.读取config文件，创建SqlSessionFactory
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		//2.获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//3.具体操作
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		
		User user = sqlSession.selectOne("getUserById2", map);
		System.out.println(user.toString());
		
		//4.关闭sqlSession
		sqlSession.close();
	}
	
	/**
	 * 查询返回list-使用#{}占位符
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test3() throws IOException {
		SqlSession sqlSession = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "%张%");
		List<User> userList = sqlSession.selectList("getUserByName1", map);
		if(userList.size() > 0) {
			for(User user : userList) {
				System.out.println(user.toString());
			}
		}
		
		sqlSession.close();
	}
	
	/**
	 * 查询返回list-使用${}拼接
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test4() throws IOException {
		SqlSession sqlSession = getSqlSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "张");
		List<User> userList = sqlSession.selectList("getUserByName2", map);
		if(userList.size() > 0) {
			for(User user : userList) {
				System.out.println(user.toString());
			}
		}
		
		sqlSession.close();
	}
	
	/**
	 * 测试插入1
	 * SELECT @@IDENTITY AS id  +  不设置order=AFTER
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test5() throws IOException {
		SqlSession sqlSession = getSqlSession();
		
		User user = new User();
		user.setUserName("周涛");
		user.setAge(25);
		//这里insert城后返回值是1，不是新增的id
		int id = sqlSession.insert("insertUser", user);
		System.out.println(id+"         "+user.getId());
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 测试插入2
	 * SELECT LAST_INSERT_ID()  +  不设置order=AFTER
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test6() throws IOException {
		SqlSession sqlSession = getSqlSession();
		
		User user = new User();
		user.setUserName("周涛");
		user.setAge(25);
		int id = sqlSession.insert("insertUser1", user);
		System.out.println(id+"         "+user.getId());
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 测试删除
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test7() throws IOException {
		SqlSession sqlSession = getSqlSession();
		
		sqlSession.delete("delettUserById", 14);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 测试更新1
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test8() throws IOException {
		SqlSession sqlSession = getSqlSession();
		
		User user = new User();
		user.setId(12);
		user.setUserName("周涛1");
		sqlSession.update("updateUser1", user);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 测试更新2 -- 会报错
	 * 
	 * 测试 <dynamic prepend="SET">
		    <isNotNull prepend="," property="userName">
		       userName  = #{userName}
		    </isNotNull>
		    <isNotNull prepend="," property="age">
		       age  = #{age}
		    </isNotNull>
		</dynamic>
	 * @author lujian
	 * @throws IOException 
	 * @create 2018年5月7日
	 */
	@Test
	public void test9() throws IOException {
		SqlSession sqlSession = getSqlSession();
		
		User user = new User();
		user.setId(12);
		user.setUserName("周涛1");
		user.setAge(10);
		sqlSession.update("updateUser2", user);
		
		sqlSession.commit();
		sqlSession.close();
	}
}
