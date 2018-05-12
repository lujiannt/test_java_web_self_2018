package com.lj.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lj.model.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User getUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		
		User user = sqlSession.selectOne("getUserById", 1);
		return user;
	}

}
