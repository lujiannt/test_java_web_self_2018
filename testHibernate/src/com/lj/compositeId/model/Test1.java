
package com.lj.compositeId.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lj.util.SessionFactoryUtil;

public class Test1 {
	/**
	 * 测试联合主键-annotation
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test1() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		TeacherPk tpk = new TeacherPk();
		tpk.setId(5);
		tpk.setName("tpk2啊");
		
		Teacher teacher = new Teacher();
		teacher.setBirth(new Date());
		teacher.setZc(Zhicheng.B);
		teacher.setTeacherPk(tpk);

		session.save(teacher);
		tran.commit();
		sessionFactory.close();
	}
	
	/**
	 * 测试联合主键-xml
	 * @author lujian
	 * @create 2018年4月24日
	 */
	@Test
	public void test2() {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		
		StudentPk spk = new StudentPk();
		spk.setId(1);
		spk.setName("tpk2啊");
		
		Student student = new Student();
		student.setBirth(new Date());
		student.setZc(Zhicheng.C);
		student.setIsgood(true);
		student.setStudentPk(spk);

		session.save(student);
		tran.commit();
		sessionFactory.close();
	}
}
