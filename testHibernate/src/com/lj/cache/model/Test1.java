
package com.lj.cache.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	private static final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
	
	
	public static Session getMySession() {
		return sessionFactory.getCurrentSession();
	}
	
	@AfterClass
	public static void closeSf() {
		sessionFactory.close();
	}
	
	
	/*-------------------------------------------------------------------------------*/
	//缓存知识点:
	//
	//	一.设置二级缓存 （1.很少改动的 2.经常使用的  3.没那么重要的允许偶尔并发的  4.数量有限    的数据可以用在二级缓存）
	//		1.cache.use_second_level_cache  开启二级缓存
	//		2.cache.provider_class   选择二级缓存提供者，没有hibernate自己的（有个仅供学习的）
	//		3.配置ehcache.xml
	//		4.需要二级缓存的类的注解  ：@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	//
	//	二.load  iterator 默认读取二级缓存
	//
	//	三.list默认写入二级缓存，但不读取
	//
	//	四.query要使用二级缓存 需要打开查询缓存，需要查询语句一样  ---
	//		1.cache.use_query_cache  开启query缓存
	//		2.使用setCacheable
	//
	//	五.缓存算法
	//		1.lru: least recently used 最近很少使用的就去掉
	//		1.lfu: least frequently used 使用频率很少的就去掉
	//		1.fifo: first in  first out 先进先出
	
	/**
	 * 测试一级缓存
	 * 同一个session 存在一级缓存，只发一条sql
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testCache_1() {
		Session session = getMySession();
		session.beginTransaction();
		
		Dog dog1 = (Dog) session.load(Dog.class, 1);
		System.out.println(dog1.getName());	
		Dog dog2 = (Dog) session.load(Dog.class, 1);
		System.out.println(dog2.getName());	
		
		session.getTransaction().commit();
	}
	
	
	/**
	 * 测试二级缓存
	 * 未设置二级缓存:会发出两条sql；设置后只会发出一条
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testCache_2() {
		Session session = getMySession();
		session.beginTransaction();
		
		Dog dog1 = (Dog) session.load(Dog.class, 1);
		System.out.println(dog1.getName());	
		session.getTransaction().commit();
		
		//对getcurrentSession得到的session 使用时需要开启事务
		Session session1 = getMySession();
		session1.beginTransaction();
		Dog dog2 = (Dog) session1.load(Dog.class, 1);
		System.out.println(dog2.getName());	
		session1.getTransaction().commit();
	}
	
	/**
	 * 测试query缓存
	 * 需要setCacheable(true)
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testCache_3() {
		Session session = getMySession();
		session.beginTransaction();
		Query query = session.createQuery("from Dog").setCacheable(true);
		query.list();
		Query query1 = session.createQuery("from Dog").setCacheable(true);
		query1.list();
		session.getTransaction().commit();
		
		Session session1 = getMySession();
		session1.beginTransaction();
		Query query2 = session1.createQuery("from Dog").setCacheable(true);
		query2.list();
		session1.getTransaction().commit();
	}
	
}
