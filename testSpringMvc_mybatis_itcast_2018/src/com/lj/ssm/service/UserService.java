package com.lj.ssm.service;

import java.util.List;

import com.lj.ssm.model.UserCustom;
import com.lj.ssm.model.UserVo;

public interface UserService {
	
	/**
	 * 根据姓名模糊查询user
	 * @param userVo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	List<UserCustom> findUserByCondition(UserVo userVo) throws Exception;
}
