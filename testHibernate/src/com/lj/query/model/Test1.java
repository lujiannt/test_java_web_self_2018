
package com.lj.query.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	private static final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
	
	public static Session getMySession() {
		return sessionFactory.getCurrentSession();
	}
	
	@AfterClass
	public static void closeSf() {
		sessionFactory.close();
	}
	
	/***************************----***************************/
	
	/**
	 * 级联插入
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test1() {
		Session session = getMySession();
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
	 * 将查询对象封装成dto（常用于报表）--HQL
	 * 将object转成object[]
	 * 
	 * @author lujian
	 * @create 2018年5月2日
	 */
	@Test
	public void test2() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		StringBuilder hqlStr = new StringBuilder("select em.employeeName,ec.cardName from EmployCard ec join ec.employee em ");
		Query query = session.createQuery(hqlStr.toString());
		List<Object> list = query.list();
		List<CardInfoDto> dtoList = new ArrayList<CardInfoDto>();
		
		//Object对象直接强转不可以转成自定义对象，需要转成数组,或其他方法
		for(Object o : list) {
			Object[] objArray = (Object[])o;
			CardInfoDto dto = new CardInfoDto();
			dto.setEmployeeName((String)objArray[0]);
			dto.setCardName((String)objArray[1]);
			dtoList.add(dto);
		}
		for(CardInfoDto dto : dtoList) {
			System.out.println(dto.toString());
		}
		
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 将查询对象封装成dto（常用于报表）--SQL
	 * 将object转成object[]
	 * 
	 * @author lujian
	 * @create 2018年5月2日
	 */
	@Test
	public void test3() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		StringBuilder sqlStr = new StringBuilder("select em.id as id,em.employeeName ,ca.cardName  from lj_employCard ca  left join lj_employee em on  em.id = ca.employeeId where 1=1 ");
		Query query = session.createSQLQuery(sqlStr.toString());
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
	
	/**
	 * 将查询对象封装成dto（常用于报表）--HQL
	 * 将查询出的对象直接封装成object[] ，就不用上面那样子再将object转成object[]
	 * 
	 * @author lujian
	 * @create 2018年5月2日
	 */
	@Test
	public void test4() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		StringBuilder hqlStr = new StringBuilder("select em.employeeName,ec.cardName from EmployCard ec join ec.employee em ");
		Query query = session.createQuery(hqlStr.toString());
		List<Object[]> list = query.list();
		List<CardInfoDto> dtoList = new ArrayList<CardInfoDto>();
		
		for(Object[] o : list) {
			CardInfoDto dto = new CardInfoDto();
			dto.setEmployeeName((String)o[0]);
			dto.setCardName((String)o[1]);
			dtoList.add(dto);
		}
		for(CardInfoDto dto : dtoList) {
			System.out.println(dto.toString());
		}
		
		tran.commit();
		sessionFactory.close();
	}
	
	/*-----------------测试查询--------------------*/
	@Test
	public void testHQL_01() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		Query q = session.createQuery("from Company");
		List<Company> companys = (List<Company>)q.list();
		for(Company c : companys) {
			System.out.println(c.getName());
		}
		
		tran.commit();
	}
	
	@Test
	public void testHQL_02() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		Query q = session.createQuery("from Employee c where c.employeeName > '高希3'");
		List<Employee> employees = (List<Employee>)q.list();
		for(Employee c : employees) {
			System.out.println(c.getEmployeeName());
		}
		
		tran.commit();
	}
	
	@Test
	public void testHQL_03() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		Query q = session.createQuery("from Employee c order by c.employeeName desc");
		List<Employee> employees = (List<Employee>)q.list();
		for(Employee c : employees) {
			System.out.println(c.getEmployeeName());
		}
		
		tran.commit();
	}
	
	@Test
	public void testHQL_04() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		Query q = session.createQuery("select distinct c from Employee c order by c.employeeName desc");
		List<Employee> employees = (List<Employee>)q.list();
		for(Employee c : employees) {
			System.out.println(c.getEmployeeName());
		}
		
		tran.commit();
	}
	
	@Test
	public void testHQL_05() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();

		Query q = session.createQuery("from Employee c where c.id > :min and c.id < :max")
			.setInteger("min", 2)
			.setInteger("max", 8);
		//q.setParameter("min", 2);
		//q.setParameter("max", 8);
		List<Employee> employees = (List<Employee>)q.list();
		for(Employee c : employees) {
			System.out.println(c.getId() + "-" + c.getEmployeeName());
		}
		
		tran.commit();
	}
	
	@Test
	public void testHQL_06() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		Query q = session.createQuery("from Employee c where c.id > ? and c.id < ?");
		q.setParameter(0, 2);
		q.setParameter(1, 8);
		List<Employee> employees = (List<Employee>)q.list();
		for(Employee c : employees) {
			System.out.println(c.getId() + "-" + c.getEmployeeName());
		}
		
		tran.commit();
	}
	
	/**
	 * 分页
	 * @author lujian
	 * @create 2018年5月3日
	 */
	@Test
	public void testHQL_07() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Employee c order by c.employeeName desc");
		q.setFirstResult(2);//从第几条开始
		q.setMaxResults(4);//每页多少个
		List<Employee> employees = (List<Employee>)q.list();
		for(Employee c : employees) {
			System.out.println(c.getId() + "-" + c.getEmployeeName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_08() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		Query q = session.createQuery("select c.id,  c.employeeName from Employee c order by c.employeeName desc");
		List<Object[]> categories = (List<Object[]>)q.list();
		for(Object[] o : categories) {
			System.out.println(o[0] + "-" + o[1]);
		}
		
		tran.commit();
	}
	
	//设定fetch type 为lazy后将不会有第二条sql语句
	@Test
	public void testHQL_09() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("from EmployCard t where t.employee.id = 1");
		List<EmployCard> topics = (List<EmployCard>)q.list();
		for(EmployCard t : topics) {
			System.out.println(t.getCardName());
			//System.out.println(t.getCategory().getName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_11() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("from EmployCard m where m.employee.company.id = 1");
		
		for(Object o : q.list()) {
			EmployCard m = (EmployCard)o;
			System.out.println(m.toString());
		}
		
		session.getTransaction().commit();
	}
	
	//动手测试left right join
	//为什么不能直接写Category名，而必须写t.category
	//因为有可能存在多个成员变量（同一个类），需要指明用哪一个成员变量的连接条件来做连接
	@Test
	public void testHQL_13() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("select t.cardName, c.employeeName from EmployCard t join t.employee c "); //join Category c
		for(Object o : q.list()) {
			Object[] m = (Object[])o;
			System.out.println(m[0] + "-" + m[1]);
		}
		
		session.getTransaction().commit();
	}
	
	//学习使用uniqueResult
	@Test
	public void testHQL_14() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("from EmployCard m where m = :ToSearch "); //不重要
		EmployCard m = new EmployCard();
		m.setId(1);
		q.setParameter("ToSearch", m);
		
		EmployCard eResult = (EmployCard)q.uniqueResult();
		System.out.println(eResult.getId()+"-"+eResult.getCardName());
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_15() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("select count(*) from EmployCard m");
		long count = (Long)q.uniqueResult();
		System.out.println(count);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_16() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("select max(m.id), min(m.id), avg(m.id), sum(m.id) from EmployCard m");
		Object[] o = (Object[])q.uniqueResult();
		System.out.println(o[0] + "-" + o[1] + "-" + o[2] + "-" + o[3]);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_17() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("from EmployCard m where m.id between 3 and 5");
		
		for(Object o : q.list()) {
			EmployCard m = (EmployCard)o;
			System.out.println(m.getId() + "-" + m.getCardName());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_18() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("from EmployCard m where m.id in (3,4, 5)");
		
		for(Object o : q.list()) {
			EmployCard m = (EmployCard)o;
			System.out.println(m.getId() + "-" + m.getCardName());
		}
		
		session.getTransaction().commit();
	}
	
	//is null 与 is not null
	@Test
	public void testHQL_19() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("from EmployCard m where m.cardName is  null");
		
		for(Object o : q.list()) {
			EmployCard m = (EmployCard)o;
			System.out.println(m.getId() + "-" + m.getCardName());
		}
		
		session.getTransaction().commit();
	}
}
