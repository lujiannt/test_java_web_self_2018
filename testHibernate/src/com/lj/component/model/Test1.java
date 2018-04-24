package com.lj.component.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	/**
	 * 测试组件-annotation
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test1() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person person = new Person();
		person.setName("曹亮");
		
		Tedian td = new Tedian();
		td.setWeight(120);
		td.setHobby("吃香");
		person.setTedian(td);
		
		session.save(person);
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 测试组件-xml
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test2() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Person2 person = new Person2();
		person.setName("曹亮");
		
		Tedian td = new Tedian();
		td.setWeight(120);
		td.setHobby("吃香");
		person.setTedian(td);
		
		session.save(person);
		tran.commit();
		sessionFactory.close();
	}
}
