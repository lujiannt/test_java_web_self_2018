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
	
	/**
	 * 根据id查询UserCustom
	 * @param id
	 * @return
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@Override
	public UserCustom findUserById(int id) throws Exception {
		return userCustomMapper.findUserById(id);
	}
	
	/**
	 * 修改user
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@Override
	public void updateUser(int id, UserCustom userCustom) throws Exception {
		if(id!=0) {
			userCustom.setId(id);
		}
		userCustomMapper.updateUser(userCustom);
	}
	
	/**
	 * 批量删除user_数组
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@Override
	public void deleteUserForBatch(int[] ids) throws Exception {
		userCustomMapper.deleteUserForBatchLogic(ids);
	}
	
	/**
	 * 批量删除user_list
	 * @throws Exception
	 * @author lujian
	 * @create 2018年5月16日
	 */
	@Override
	public void deleteUserForBatch1(UserVo userVo) throws Exception {
		userCustomMapper.deleteUserForBatchLogic1(userVo);
	}

}
