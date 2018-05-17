package com.lj.one2many.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
	
	/**
	 * one2many 测试inverse
	 * 如果在set中设置inverse为false，就会发出两条insert，一条update
	 * 加入设置为true了，就会交给product2一方管理，只会发出两条insert
	 * @author lujian
	 * @create 2018年4月23日
	 */
	@org.junit.Test
	public void test2() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		
		Order2 order = new Order2();
		order.setName("订单22");
		Product2 product = new Product2();
		product.setName("商品2");
		order.getProducts().add(product);
		session.save(order);
		
		tran.commit();
		session.close();
		sessionFactory.close();
	}
	
}
