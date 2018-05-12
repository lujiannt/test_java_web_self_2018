package com.lj.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
	
	/**
	 * 测试简单mapper编程_resultMap_简单使用(当查询字段和model字段不一致时--)
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test4() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.getUsersByResulstMap("周涛");
		System.out.println(list.size());
		
		sqlSession.close();
	}
	
	/**
	 * 测试简单mapper编程_resultMap_具体使用one2one
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test6() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Order> list = orderMapper.getOrdersByResulstMapOne2One();
		System.out.println(list.size());
		System.out.println(list.toString());
		
		sqlSession.close();
	}
	
	/**
	 * 测试简单mapper编程_resultMap_具体使用one2many
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test7() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Order> list = orderMapper.getOrdersByResulstMapOne2Many();
		for(Order o : list) {
			System.out.println(o.toString());
			for(OrderProduct op : o.getOrderProducts()) {
				System.out.println(op.toString());
			}
			System.out.println("------------------------------");
		}
		
		sqlSession.close();
	}
	
	/**
	 * 测试简单mapper编程_resultMap_具体使用_多层嵌套(这里只是为了显示嵌套，而user和product正好逻辑上是多对多,所以方法名叫many2many)
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test8() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<User> list = orderMapper.getOrdersByResulstMapMany2Many();
		for(User u : list) {
			System.out.println(u.toString());
			
			for(Order o : u.getOrders()) {
				System.out.println(o.toString());
				
				for(OrderProduct op : o.getOrderProducts()) {
					System.out.println(op.toString());
				}
			}
			System.out.println("------------------------------");
		}
		
		sqlSession.close();
	}
	
	/**
	 * 测试简单mapper编程_sql代码块
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test5() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(3);
		ids.add(8);
		ids.add(13);
		User user = new User();
		user.setUserName("周涛");
		UserVo userVo = new UserVo();
		userVo.setUser(user);
		userVo.setIds(ids);
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<UserVo> list = userMapper.getUsersByComplex(userVo);
		System.out.println(list.size());
		
		sqlSession.close();
	}
	
	/**
	 * 测试延迟加载
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test9() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = orderMapper.getOrdersLazy();
//		for(Order o : list) {
//			System.out.println(o.toString());
//		}
		
		sqlSession.close();
	}
	
	/**
	 * 测试一级缓存
	 * 知识点:
	 * 	1.和hibernate一样事session级别的,自动存在
	 * 	2.每次更新 插入 删除提交事务后，会自动清除一级缓存，为了确保缓存中是最新的
	 * 	3.扩展：在开发中 事务一般由service层控制，一个service是一个事务(即一个SqlSession)，所以一级缓存在实际开发中只在一个service中有用
	 * 
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test10() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		Order order = orderMapper.getOrder(1);
		
//		order.setOrderNo("22No");
//		orderMapper.updateOrder(order);
//		sqlSession.commit();
		
		OrderMapper orderMapper1 = sqlSession.getMapper(OrderMapper.class);
		Order order1 = orderMapper1.getOrder(1);
		
		sqlSession.close();
	}

	/**
	 * 测试二级缓存
	 * 一.步骤:
	 * 	1.在sqlMapConfig.xml中设置开启二级缓存总开关
	 *  	<setting name="cacheEnabled" value="true"/>
	 *  2.在mapper.xml设置开启该namespace下的二级缓存
	 *  	<cache></cache>
	 *  3.对应pojo类要实现序列化,在这里是order类
	 *  	因为二级缓存存储可能多样化如硬盘或其他服务器，所以要实现序列化以便于反序列化取出二级缓存
	 *  
	 * 二.知识点扩展:
	 * 	1.sqlSession必须close，否则不会写入到二级缓存
	 * 	2.mapper.xml中useCache="true"的作用
	 * 		useCache默认="true",意思是当打开二级缓存时，该条select语句使用二级缓存
	 * 	3.mapper.xml中flushCache="true"的作用
	 * 		flushCache默认="true",即更新时会刷新（清空）该mapper的二级缓存
	 *  4.控制台输出的命中率信息  DEBUG [main] - Cache Hit Ratio [com.lj.mybatis.mapper.OrderMapper]: 0.5
	 *  
	 * 三.整合ehcache:
	 * 	1.本质:mybatis本身的缓存机制并不是多么优秀，第三方的更专业优秀效率安全等都更好（比如对缓存数据的优化如数据压缩等）。
	 * 		    但是mybatis提供了cache接口让用户自己实现或引用第三方(核心)，并且mybatis自己有默认实现的cache类
	 * 	2.整合步骤:
	 * 		1.引入ehcache相关jar包
	 * 			ehcache-core-2.6.5.jar 和mybatis-ehcache-1.0.2.jar
	 * 		2.配置ehcache.xml
	 * 		3.在对应mapper中的cache标签中使用type 
	 * 			<cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
	 * 
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月9日
	 */
	@Test
	public void test11() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		OrderMapper orderMapper = sqlSession1.getMapper(OrderMapper.class);
		Order order = orderMapper.getOrder(1);
		sqlSession1.close();
		
//		OrderMapper orderMapper2 = sqlSession3.getMapper(OrderMapper.class);
//		Order order2 = orderMapper2.getOrder(1);
//		order2.setOrderNo("22No");
//		orderMapper2.updateOrder(order);
//		sqlSession3.commit();
//		sqlSession3.close();
		
		OrderMapper orderMapper1 = sqlSession2.getMapper(OrderMapper.class);
		Order order1 = orderMapper1.getOrder(1);
		sqlSession2.close();
	}
}
