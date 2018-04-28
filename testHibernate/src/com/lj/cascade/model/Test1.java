
package com.lj.cascade.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	/**
	 * 测试级联保存-annotation
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test1() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		UserLj userLj = new UserLj();
		userLj.setName("tpk2啊");
		
		CardLj cardLj = new CardLj();
		cardLj.setName("asd");
		cardLj.setUserlj(userLj);

		session.save(cardLj);
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 测试级联读取-annotation
	 * 在多的一方时，不需要设置，自动会读取级联对象
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test2() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		CardLj cardLj = (CardLj) session.get(CardLj.class, 2);
		//System.out.println(cardLj.getUserlj().getName());
		
		tran.commit();
		sessionFactory.close();
	}
}
