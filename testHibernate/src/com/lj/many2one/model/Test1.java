package com.lj.many2one.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	/**
	 * 多对一  annotation
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test1() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User user = new User();
		user.setName("曹亮");
		
		Group group = new Group();
		group.setName("想组");

		session.save(user);
		session.save(group);
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 多对一  xml
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test2() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		User2 user = new User2();
		user.setName("曹亮");
		
		Group2 group = new Group2();
		group.setName("想组");

		session.save(user);
		session.save(group);
		tran.commit();
		sessionFactory.close();
	}
}
