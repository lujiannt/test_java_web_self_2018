package com.lj.one2one.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lj.util.SessionFactoryUtil;

public class Test {
	/**
	 * one2one 注解方式
	 * @author lujian
	 * @create 2018年4月23日
	 */
	@org.junit.Test
	public void test1() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		
		Wife wife = new Wife();
		wife.setName("单星星");
		
		Husband hus = new Husband();
		hus.setHusName("曹亮");
		hus.setWife(wife);
		
		session.save(wife);
		session.save(hus);
		
		transaction.commit();
		sessionFactory.close();
	}
	
	/**
	 * one2one xml
	 * @author lujian
	 * @create 2018年4月23日
	 */
	@org.junit.Test
	public void test2() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		
		Wife2 wife2 = new Wife2();
		wife2.setName("单星星");
		
		Husband2 hus = new Husband2();
		hus.setHusName("曹亮");
		hus.setWife2(wife2);
		
		session.save(wife2);
		session.save(hus);
		
		transaction.commit();
		sessionFactory.close();
	}
}
