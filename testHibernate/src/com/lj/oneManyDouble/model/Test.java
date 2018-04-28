package com.lj.oneManyDouble.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lj.many2one.model.Group;
import com.lj.many2one.model.User;
import com.lj.util.SessionFactoryUtil;

public class Test {
	/**
	 * one2many annotation
	 * @author lujian
	 * @create 2018年4月23日
	 */
	@org.junit.Test
	public void test1() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		tran.commit();
		sessionFactory.close();
	}
	
}
