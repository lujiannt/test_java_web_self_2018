
package com.lj.trancation_lock.model;

import java.math.BigDecimal;

import org.hibernate.LockMode;
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
	
	
	/*-------------------------------------------------------------------------------*/
	//hibernate事务知识点:
	//	一.事务特性
	//		ACID:原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）、持久性（Durability）
	//
	//	二.事务并发引起的常见问题
	//		1.脏读（Dirty Reads） 
	//			一个事务中读取到另一个未提交事务的数据,一旦另一个事务回滚，就出错了
	//		2.不可重复读取（Non-repeatable Reads）
	//			一个事务读取对象后，另外一个事务对该对象更新，导致读取的不一样
	//		3.幻读（Phantom Reads） 
	//			是重复读的一种特殊情况，指插入和删除,一个事务重新查询，返回记录含有因其他提交的事务而产生的新记录。 
	//
	//	三.数据库的4中事务隔离机制
	//		1.read uncommitted-读未提交  
	//			（最低等级的事务隔离，仅仅保证了读取过程中不会读取到非法数据,不能解决上述三种）
	//		2.read committed-读已提交   
	//			（可以解决脏读） 一般用这个
	//		3.repeatable read-重复读    
	//			（对于读到的还未提交事务的对象加锁，保证其他事务无法修改，性能低）
	//		4.serializable-串行          
	//			（可以解决所有，事务按照顺序一个一个来，效率低）  
	//
	//			隔离解别				脏读	不可重复读	幻读
	//			Read Uncommitted	Y	  Y	    Y
	//			Read Committed		N	  Y	    Y
	//			Repeatable			N	  N	    Y
	//			Serializable		N	  N   	N
	//
	//	四.hibernate中的事务配置
	//		1.hibernate.cfg.xml中配置   
	//			hibernate.connection.isolation 
	//				值为  1,2,4,8（二进制：0001 0010  0100 1000）
	//			默认看数据库，mysql是repeatable read，oracle是read committed		
	//
	//	五.悲观锁和乐观锁
	//		1.悲观锁（效率低）
	//			1.读取时加参数lockMode.upgrade(已过时)或lockOptions.upgrade 
	//				如:session.load(User.class,1,lockMode.upgrade)
	//	        2.hibernate中读取，写入都有自己的锁并且会自己加，我们只要使用upgrade
	//          3.使用悲观锁后，发送sql就会多 for update用于告诉数据库锁定该数据
	//		2.乐观锁
	//			1.annotation中使用@version，进行版本记录与比较
	//			2.xml中使用<version name="" column=""><version/>	
	
	
	/**
	 * 插入数据
	 * 同一个session 存在一级缓存，只发一条sql
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testinsert() {
		Session session = getMySession();
		session.beginTransaction();
		
		Account account = new Account();
		account.setBlance(new BigDecimal("1000"));
		session.save(account);
		
		session.getTransaction().commit();
	}
	
	/**
	 * 测试悲观锁
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testlock_1() {
		Session session = getMySession();
		session.beginTransaction();
		
		Account account = (Account) session.get(Account.class, 1, LockMode.UPGRADE);
		
		session.getTransaction().commit();
	}
	
	/**
	 * 测试乐观锁
	 * @author lujian
	 * @create 2018年5月4日
	 */
	@Test
	public void testlock_2() {
		Session session = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		
		Transaction tran2 = session2.beginTransaction();
		Transaction tran1 = session.beginTransaction();
		Account a1 = (Account) session.load(Account.class, 1);
		System.out.println("第一次 a1 version :" + a1.getVersion());
		
		//System.out.println(tran1 == tran2);
		Account a2 = (Account) session2.load(Account.class, 1);
		System.out.println("第一次 a2 version :" + a2.getVersion());
		
		a1.setBlance(new BigDecimal("900"));
		a2.setBlance(new BigDecimal("1900"));
		
		tran1.commit();
		System.out.println("第二次 a1 version :" + a1.getVersion());
		System.out.println("第二次 a2 version :" + a2.getVersion());
		session.close();
		
		tran2.commit();
		session2.close();
	}
	
}
