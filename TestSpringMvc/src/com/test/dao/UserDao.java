package com.test.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.test.model.User;

//标识
@Component
public class UserDao {
	private static Map<String, User> userMap = null;
	private static int index = 3;
	
	//静态代码块在程序第一次执行时加载，且只执行这一次，然后存到内存中特定区域，相较于每次都new进容器比较节省资源
	static {
		userMap = new HashMap<String, User>();
		
		userMap.put("1", new User(1, "1号同学", 12));
		userMap.put("2", new User(2, "2号同学", 13));
		userMap.put("3", new User(3, "3号同学", 14));
	}
	
	
	public Collection<User> getUsers() {
		return userMap.values();
	}


	public void saveUser(User user) {
		int userId = index+1;
		user.setUserId(userId);
		userMap.put(""+userId, user);
		index++;
	}


	public void deleteUser(int userId) {
		userMap.remove(""+userId);
		index--;
	}
	
}
