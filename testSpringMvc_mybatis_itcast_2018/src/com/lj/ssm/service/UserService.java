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
	void updateUser(int id, UserCustom userCustom) throws Exception;
	
	/**
	 * 批量删除user_数组
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	void deleteUserForBatch(int[] ids) throws Exception;
	
	/**
	 * 批量删除user_list
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	void deleteUserForBatch1(UserVo userVo) throws Exception;
}
