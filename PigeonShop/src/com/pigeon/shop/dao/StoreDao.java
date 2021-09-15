package com.pigeon.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.Store;
import com.pigeon.shop.entity.User;

public class StoreDao extends HibernateDaoSupport{
	
	public Store findByAccount(String account){
		System.out.println("dao start");
		System.out.println(account);
		String hql="from Store where account=?";
		List<Store> list=this.getHibernateTemplate().find(hql,account);
		if(list!=null&&list.size()>0){
			System.out.println("找到了");
			return list.get(0);
		}
		System.out.println("dao finish");
		return null;
	}
	//注册用户存入数据库
	public void save(Store store) {
		this.getHibernateTemplate().save(store);
		
	}
	public Store login(Store store) {
		String hql="from Store where account=? and password=?";
		List<Store> list=this.getHibernateTemplate().find(hql,store.getAccount(),store.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
