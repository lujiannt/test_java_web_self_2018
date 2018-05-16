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
	
	/**
	 * 根据id查询UserCustom
	 * @param id
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	UserCustom findUserById(int id) throws Exception;
	
	/**
	 * 修改user
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	void updateUser(UserCustom userCustom) throws Exception;
	
	/**
	 * 批量逻辑删除user
	 * @param ids
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	void deleteUserForBatchLogic(int[] ids) throws Exception;
}
