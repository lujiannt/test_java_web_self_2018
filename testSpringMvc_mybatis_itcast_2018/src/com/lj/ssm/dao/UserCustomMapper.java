package com.lj.ssm.dao;

import java.util.List;

import com.lj.ssm.model.UserCustom;
import com.lj.ssm.model.UserVo;

public interface UserCustomMapper {
	
	/**
	 * 根据条件查询User 
	 * @param userVo
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	List<UserCustom> findUserByCondition(UserVo userVo) throws Exception;
}
