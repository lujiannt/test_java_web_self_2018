package com.lj.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lj.ssm.dao.UserCustomMapper;
import com.lj.ssm.model.UserCustom;
import com.lj.ssm.model.UserVo;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserCustomMapper userCustomMapper;

	/**
	 * 根据姓名模糊查询user
	 * @param userName
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@Override
	public List<UserCustom> findUserByCondition(UserVo userVo) throws Exception {
		return userCustomMapper.findUserByCondition(userVo);
	}

}
