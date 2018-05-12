package com.lj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.lj.model.User;

/**
 * 如何使用mapper代理
 * @author lujian
 * @create 2018年5月9日
 * @version 1.0
 */
public interface UserAnnotationMapper {
	
	@Select("select * from mb_user where id = #{id}")
	User findUser_annotation(int id) throws Exception;
	
	@Insert("insert into mb_user(userName, age) values(#{userName}, #{age})")
	@SelectKey(statement="SELECT LAST_INSERT_ID()", before = false, keyProperty = "id", resultType=int.class)
	int addUser_annotation(User user) throws Exception;
}
