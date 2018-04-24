package com.lj.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryUtil {
	private static final SessionFactory sessionFactory = buildMySessionFactory();

	private static SessionFactory buildMySessionFactory() {
		return new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
