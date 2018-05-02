
package com.lj.query.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	/**
	 * 级联插入
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test1() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		Company company1 = new Company();
		company1.setName("无锡百纯");
		Company company2 = new Company();
		company2.setName("无锡拼起来");
		
		Employee em1 = new Employee();
		em1.setName("高希");
		em1.setCompany(company1);
		Employee em2 = new Employee();
		em2.setName("彩玉");
		em2.setCompany(company1);
		Employee em3 = new Employee();
		em3.setName("梁慧");
		em3.setCompany(company2);
		
		EmployCard card1 = new EmployCard();
		card1.setName("工资卡1");
		card1.setEmployee(em1);
		EmployCard card2 = new EmployCard();
		card2.setName("工社保卡");
		card2.setEmployee(em2);
		EmployCard card3 = new EmployCard();
		card3.setName("工医保卡");
		card3.setEmployee(em3);
		EmployCard card4 = new EmployCard();
		card4.setName("信用卡");
		card4.setEmployee(em1);
		EmployCard card5 = new EmployCard();
		card5.setName("工资卡2");
		card5.setEmployee(em1);
		
		session.save(card1);
		session.save(card2);
		session.save(card3);
		session.save(card4);
		session.save(card5);
		
		for(int i=0;i<10;i++) {
			Employee employee = new Employee();
			employee.setName("高希"+i);
			employee.setCompany(company1);
			
			EmployCard card = new EmployCard();
			card.setName("工资卡"+i);
			card.setEmployee(employee);
			session.save(card);
		}
		
		tran.commit();
		sessionFactory.close();
	}
	
}
