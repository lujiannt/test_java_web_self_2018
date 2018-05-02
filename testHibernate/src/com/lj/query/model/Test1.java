
package com.lj.query.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
		em1.setEmployeeName("高希");
		em1.setCompany(company1);
		Employee em2 = new Employee();
		em2.setEmployeeName("彩玉");
		em2.setCompany(company1);
		Employee em3 = new Employee();
		em3.setEmployeeName("梁慧");
		em3.setCompany(company2);
		
		EmployCard card1 = new EmployCard();
		card1.setCardName("工资卡1");
		card1.setEmployee(em1);
		EmployCard card2 = new EmployCard();
		card2.setCardName("工社保卡");
		card2.setEmployee(em2);
		EmployCard card3 = new EmployCard();
		card3.setCardName("工医保卡");
		card3.setEmployee(em3);
		EmployCard card4 = new EmployCard();
		card4.setCardName("信用卡");
		card4.setEmployee(em1);
		EmployCard card5 = new EmployCard();
		card5.setCardName("工资卡2");
		card5.setEmployee(em1);
		
		session.save(card1);
		session.save(card2);
		session.save(card3);
		session.save(card4);
		session.save(card5);
		
		for(int i=0;i<10;i++) {
			Employee employee = new Employee();
			employee.setEmployeeName("高希"+i);
			employee.setCompany(company1);
			
			EmployCard card = new EmployCard();
			card.setCardName("工资卡"+i);
			card.setEmployee(employee);
			session.save(card);
		}
		
		tran.commit();
		sessionFactory.close();
	}
	
	
	/**
	 * 将查询对象封装成dto（常用于报表）--SQL
	 * @author lujian
	 * @create 2018年5月2日
	 */
	@Test
	public void test2() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		StringBuilder hqlStr = new StringBuilder("select em.id as id,em.employeeName as employeeName,ca.cardName as  cardName from lj_employee em left join lj_employCard ca on  em.id = ca.employeeId where 1=1 ");
		Query query = session.createSQLQuery(hqlStr.toString());
		List<Object> list = query.list();
		List<CardInfoDto> dtoList = new ArrayList<CardInfoDto>();
		
		//Object对象直接强转不可以转成自定义对象，需要转成数组,或其他方法
		for(Object o : list) {
			Object[] objArray = (Object[])o;
			CardInfoDto dto = new CardInfoDto();
			dto.setId((int)objArray[0]);
			dto.setEmployeeName((String)objArray[1]);
			dto.setCardName((String)objArray[2]);
			dtoList.add(dto);
		}
		for(CardInfoDto dto : dtoList) {
			System.out.println(dto.toString());
		}
		
		tran.commit();
		sessionFactory.close();
	}
}
