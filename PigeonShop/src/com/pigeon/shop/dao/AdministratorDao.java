package com.pigeon.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.Administrator;
import com.pigeon.shop.entity.User;

public class AdministratorDao extends HibernateDaoSupport{
	
	public Administrator findByAccount(String account){
		System.out.println("dao start");
		System.out.println(account);
		String hql="from Administrator where account=?";
		List<Administrator> list=this.getHibernateTemplate().find(hql,account);
		if(list!=null&&list.size()>0){
			System.out.println("找到了");
			return list.get(0);
		}
		System.out.println("dao finish");
		return null;
	}
	//注册用户存入数据库
	public void save(Administrator ad) {
		this.getHibernateTemplate().save(ad);
		
	}
	public Administrator login(Administrator ad) {
		System.out.println("dao");
		
		String hql="from Administrator where account=? and password=?";
		List<Administrator> list=this.getHibernateTemplate().find(hql,ad.getAccount(),ad.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
