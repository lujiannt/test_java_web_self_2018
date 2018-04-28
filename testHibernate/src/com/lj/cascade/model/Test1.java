
package com.lj.cascade.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	/**
	 * 测试级联保存many2one单向的情况-多的一方-annotation
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
	 * 测试级联读取many2one单向的情况-多的一方-annotation
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
		
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 测试级联保存one2many单向的情况-一的一方-annotation
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test3() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		BiCardLj cardLj = new BiCardLj();
		cardLj.setName("bitest1");
		
		BiUserLj userLj = new BiUserLj();
		userLj.setName("bi3啊");
		userLj.getCards().add(cardLj);
		
		session.save(userLj);
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 测试级联读取one2many单向的情况-一的一方-annotation
	 * 在一的一方时，需要设置fetchtype.eager，才会读取级联对象,
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test4() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		BiUserLj cardLj = (BiUserLj) session.get(BiUserLj.class, 2);
		System.out.println(cardLj.getCards().size());
		
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 测试级联保存one2many双向的情况-一的一方-annotation
	 * 双向时需要在card中也设置user
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test5() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		CardLj card1 = new CardLj();
		card1.setName("card1");
		CardLj card2 = new CardLj();
		card2.setName("card2");
		
		UserLj user = new UserLj();
		user.setName("user啊");
		user.getCards().add(card1);
		user.getCards().add(card2);
		
		//双向时需要在card中也设置user,否组存储到数据库对应外键中为空
		card1.setUserlj(user);
		card2.setUserlj(user);
		
		session.save(user);
		tran.commit();
		sessionFactory.close();
	}
}
