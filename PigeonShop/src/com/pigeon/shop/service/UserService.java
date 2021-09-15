package com.pigeon.shop.service;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.UserDao;
import com.pigeon.shop.entity.User;

@Transactional
public class UserService {
	//注入userdao
	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	public User findByUsername(String username){
		System.out.println("service");
		System.out.println(username);
		return dao.findByUsername(username);
	}
	//注册业务
	public void save(User user) {
		//将数据存入数据库
		//ad.setState(0);//0未激活 1已激活  用户状态
		//String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//ad.setCode(code);//设置激活码
		dao.save(user);
	}

	public User login(User user) {
		System.out.println("service"+user.getUsername());
		return dao.login(user);
	}
	
}
