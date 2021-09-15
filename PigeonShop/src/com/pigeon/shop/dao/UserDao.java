package com.pigeon.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.User;

public class UserDao extends HibernateDaoSupport{
	
	public User findByUsername(String username){
		System.out.println("dao start");
		System.out.println(username);
		String hql="from User where username=?";
		List<User> list=this.getHibernateTemplate().find(hql,username);
		if(list!=null&&list.size()>0){
			System.out.println("找到了");
			return list.get(0);
		}
		System.out.println("dao finish");
		return null;
	}
	//注册用户存入数据库
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}
	public User login(User user) {
		System.out.println("dao");
		System.out.println(user.getUsername());
		String hql="from User where username=? and password=?";
		List<User> list=this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
