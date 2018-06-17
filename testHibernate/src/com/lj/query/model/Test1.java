
package com.lj.query.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	private static final SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
	private static EmployCard testcard = new EmployCard();
	
	static {
		testcard.setCardName("信用卡1");
		testcard.setCardNumber("abc11");
	}
	
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
			card.setLine(10000+i*3000);
			card.setCardNumber("abc"+i);
			card.setEmployee(employee);
			card.setCreatTime(new Date());
			session.save(card);
		}
		
		tran.commit();
		//session.close(); 这里使用的是getcurrentSession() 事务提交时会自动关闭session
		//sessionFactory.close(); 这里在afterClass中关闭了
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
		//session.close(); 这里使用的是getcurrentSession() 事务提交时会自动关闭session
		//sessionFactory.close(); 这里在afterClass中关闭了
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
		//session.close(); 这里使用的是getcurrentSession() 事务提交时会自动关闭session
		//sessionFactory.close(); 这里在afterClass中关闭了
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
		//session.close(); 这里使用的是getcurrentSession() 事务提交时会自动关闭session
		//sessionFactory.close(); 这里在afterClass中关闭了
	}
	
	/**
	 * 多条件查询-使用map和 setProperties
	 * @author lujian
	 * @create 2018年5月3日
	 */
	@Test
	public void test5() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		StringBuilder hqlStr = new StringBuilder("from EmployCard ec where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		//isNotEmpty(str)等价于 str != null && str.length > 0
		//isNotBlank(str)等价于 str != null && str.length > 0 && str.trim().length > 0
		
		if(StringUtils.isNotBlank(testcard.getCardName())) {
			hqlStr.append("and ec.cardName = :cardName ");
			params.put("cardName", testcard.getCardName());
		}
		if(StringUtils.isNotBlank(testcard.getCardNumber())) {
			hqlStr.append("and ec.cardNumber = :cardNumber ");
			params.put("cardNumber", testcard.getCardNumber());
		}
		if(testcard.getCreatTime()!=null) {
			hqlStr.append("and ec.creatTime = :creatTime ");
			params.put("creatTime", testcard.getCreatTime());
		}
		
		System.out.println(hqlStr.toString());
		Query query = session.createQuery(hqlStr.toString());
		query.setProperties(params);
		List<EmployCard> list = query.list();
		for(EmployCard c : list) {
			System.out.println(c);
		}
		
		tran.commit();
	}
	
	
	
	
	
	
	/*-----------------测试查询--------------------*/
	
	/**
	 * 普通hql
	 * @author lujian
	 * @create 2018年5月4日
	 */
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
	
	/**
	 * 使用sql 
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testHQL_01_2() {
		Session session = getMySession();
		Transaction tran = session.beginTransaction();
		
		Query q = session.createSQLQuery("select * from lj_company").addEntity(Company.class);
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
	
	//is empty and is not empty
	/**
	 * 查询一的一方中没有多的一方的情况--HQL语句is empty（如 查询没有商品的订单）
	 * @author lujian
	 * @create 2018年5月4日
	 * 用product和order举例子不用hql里 is empty可以用下述两种方法
	 * 方法1:not exists (和in ，not in的区别：效率，少量元素用in，其他用exists)
	 * SELECT *
		FROM
			lj_order o
		WHERE
			NOT EXISTS (
				SELECT
					*
				FROM
					lj_product p
				WHERE
					p.orderId = o.id
			)
	 * 		
	 *  方法2:left join
	 *  SELECT *
		FROM
			lj_order o
		left join
			lj_product lp
		on 
			o.id = lp.orderId
		where 
			lp.orderId is null			
	 */
	@Test
	public void testHQL_20() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("from Company t where t.employees is empty");
		
		for(Object o : q.list()) {
			Company t = (Company)o;
			System.out.println(t.getId() + "-" + t.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_21() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("from Company t where t.name like '%中%'");
		
		for(Object o : q.list()) {
			Company t = (Company)o;
			System.out.println(t.getId() + "-" + t.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_22() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("from Company t where t.name like '_中'");
		
		for(Object o : q.list()) {
			Company t = (Company)o;
			System.out.println(t.getId() + "-" + t.getName());
		}
		session.getTransaction().commit();
	}
	
	//不重要
	@Test
	public void testHQL_23() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("select lower(t.name)," +
											 "upper(t.name)," +
											 "trim(t.name)," +
											 "concat(t.name, '***')," +
											 "length(t.name)" +
											 " from Company t ");
		
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "-" + arr[1] + "-" + arr[2] + "-" + arr[3] + "-" + arr[4] + "-");
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_24() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query q = session.createQuery("select abs(t.id)," +
											 "sqrt(t.id)," +
											 "mod(t.id, 2)" +
											 " from Company t ");
		
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "-" + arr[1] + "-" + arr[2] );
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_25() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("select current_date, current_time, current_timestamp, t.id from Company t");
		
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2] + " | " + arr[3]);
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_26() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("from EmployCard t where t.creatTime < :date");
		q.setParameter("date", new Date());
		for(Object o : q.list()) {
			EmployCard t = (EmployCard)o;
			System.out.println(t.getCardName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_27() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("select t.cardName, count(*) from EmployCard t group by t.cardName") ;
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "|" + arr[1]);
		}
		session.getTransaction().commit();
	}
	
	/**
	 * having是对group by后的分组进行条件筛选，并且having后面要使用函数
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testHQL_28() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("select t.cardName, count(*) from EmployCard t group by t.cardName having count(*) > 1") ;
		for(Object o : q.list()) {
			Object[] arr = (Object[])o;
			System.out.println(arr[0] + "|" + arr[1]);
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testHQL_29() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("from EmployCard t where t.id < (select avg(t.id) from EmployCard t)") ;
		for(Object o : q.list()) {
			EmployCard t = (EmployCard)o;
			System.out.println(t.getCardName());
		}
		session.getTransaction().commit();
	}
	
	/**
	 * all指所有的，这里可以用max 或者min就行了，没必要用all
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testHQL_30() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("from EmployCard t where t.id < ALL (select t.id from EmployCard t where mod(t.id, 2)= 0) ") ;
		for(Object o : q.list()) {
			EmployCard t = (EmployCard)o;
			System.out.println(t.getCardName());
		}
		session.getTransaction().commit();
	}
	
	//用in 可以实现exists的功能
	//但是exists执行效率高
	/**
	 * not exists 和 test20一样的效果
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testHQL_31() {
		Session session = getMySession();
		session.beginTransaction();// t.id not in (1)
		Query q = session.createQuery("from Company t where not exists (select m.id from Employee m where m.company.id=t.id)") ;
		for(Object o : q.list()) {
			Company t = (Company)o;
			System.out.println(t.getName());
		}
		session.getTransaction().commit();
	}
	
	//update and delete
	//规范并没有说明是不是要更新persistent object，所以如果要使用，建议在单独的trasaction中执行
	@Test
	public void testHQL_32() {
		Session session = getMySession();
		session.beginTransaction();
		Query q = session.createQuery("update Company t set t.name = upper(t.name) where t.id = 4") ;
		
		q.executeUpdate();
		
		q = session.createQuery("from Company where id = 4");
		for(Object o : q.list()) {
			Company t = (Company)o;
			System.out.println(t.getName());
		}
		session.createQuery("update Company t set t.name = lower(t.name) where t.id = 4")
			.executeUpdate();
		
		session.getTransaction().commit();
	}
	
	/**
	 * QBC QBE  
	 * createCriteria默认发出的sql就是left join语句，不会产生1+n问题
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testQBC() {
		Session session = getMySession();
		session.beginTransaction();
		
		//criterion 标准/准则/约束
		Criteria c = session.createCriteria(Employee.class) //from Topic
					 .add(Restrictions.gt("id", 2)) //greater than = id > 2
					 .add(Restrictions.lt("id", 8)) //little than = id < 8
					 .add(Restrictions.like("employeeName", "%高%"))
					 .createCriteria("company")
					 .add(Restrictions.between("id", 1, 3)) //category.id >= 3 and category.id <=5
					 ;
		//DetachedCriterea
		for(Object o : c.list()) {
			Employee t = (Employee)o;
			System.out.println(t.toString());
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * QBE 
	 * 使用Example，可以用于多条件查询，然后直接传值tExample
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testQBE() {
		Session session = getMySession();
		session.beginTransaction();
		
		Employee tExample = new Employee();
		tExample.setEmployeeName("%高%");
		
		Example e = Example.create(tExample)
					.ignoreCase().enableLike();
		Criteria c = session.createCriteria(Employee.class)
					 .add(Restrictions.gt("id", 2))
					 .add(Restrictions.lt("id", 8))
					 .add(e)
					 ;
					 
		
		for(Object o : c.list()) {
			Employee t = (Employee)o;
			System.out.println(t.toString());
		}
		session.getTransaction().commit();
	}
	
	
	/**
	 * 测试1+N问题
	 * 方法1:
	 * 在many2one中设置 fetch=fetchType.lazy(many2one默认是eager),这样就会在使用时才会发出多条一方的语句
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test1_N_1() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query c = session.createQuery("from Employee");
		List<Employee> employees = c.list();
		for(Employee o : employees) {
			System.out.println(1);
			//System.out.println(o.getCompany().getName());
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * 测试1+N问题
	 * 方法2:
	 * 在一的一方设置batchsize，这样sql就会用in一次查询多条
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test1_N_2() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query c = session.createQuery("from Employee");
		List<Employee> employees = c.list();
		for(Employee o : employees) {
			System.out.println(1);
			//System.out.println(o.getCompany().getName());
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * 测试1+N问题
	 * 方法3:
	 * 使用fetch join  等同于使用  QBC
	 * 
	 * 拓展：
	 * 	     在xml中配置也是这样，在<many-to-one fetch="join" lazy="true"  inverse="true" cascade="all" />
	 * 	 	1.fetch="select" lazy="false" 就会产生1+N
	 *   	2.fetch="select" lazy="true" 就是方法1
	 *   	3.fetch="join" 不管lazy设置成什么 都没用，因为此时 是外连接查询,不是查完多方再单独查一方 
	 * 
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test1_N_3() {
		Session session = getMySession();
		session.beginTransaction();
		
		//fetch就是在代码这一层给你一个主动抓取得机会. 由多的一方抓取一的一方
		//可以在lazy="true"的情况下把fetch去掉，就会报异常. 如果lazy="false"就不需要fetch了
		Query c = session.createQuery("from Employee e left join fetch e.company c");
		List<Employee> employees = c.list();
		for(Employee o : employees) {
			System.out.println(1);
			System.out.println(o.getCompany().getName());
		}
		
		session.getTransaction().commit();
	}
	
	
	/**
	 * list查询
	 * 	list和iterator区别：
	 *  	1.list是查询所有属性数据，iterator是先只查询id，用到时再用该id再次查询
	 * 		2.list查询都是新的查询，iterator会先从缓存中找，如果没有再查询
	 *  
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testlist() {
		Session session = getMySession();
		session.beginTransaction();
		Query c = session.createQuery("from Employee");
		List<Employee> employees = c.list();
		for(Employee o : employees) {
			System.out.println(o.getCompany().getName());
		}
		
		session.getTransaction().commit();
	}
	
	/**
	 * iterator查询
	 * 	list和iterator区别：
	 *  	1.list是查询所有属性数据，iterator是先只查询id，用到时再用该id再次查询
	 * 		2.list查询都是新的查询，iterator会先从缓存中找，如果没有再查询
	 *  
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testiterator() {
		Session session = getMySession();
		session.beginTransaction();
		
		Query c = session.createQuery("from Employee");
		Iterator<Employee> employees = c.iterate();
		
		while(employees.hasNext()) {
			Employee em = employees.next();
			//System.out.println(em.toString());
		}
		
		session.getTransaction().commit();
	}
}
