package com.lj.many2many.model;

import org.hibernate.SessionFactory;

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
	}
	
}
