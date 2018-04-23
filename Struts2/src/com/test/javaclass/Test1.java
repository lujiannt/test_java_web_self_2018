package com.test.javaclass;

import java.util.ArrayList;
import java.util.List;

import com.lj.test.user.User;

public class Test1 {

	public static void main(String[] args) {
		User user = new User();
		List<Object> list = new ArrayList<Object>();
		list.add(user);
		
		
		user.setUsername("zs");
		User user1 = (User) list.get(0);
		System.out.println(user1.getUsername());
		
		user =new User();
		user.setUsername("sa");
		System.out.println(user1.getUsername());
	}

}
