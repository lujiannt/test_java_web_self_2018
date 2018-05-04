
package com.lj.cache.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
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
	
}
