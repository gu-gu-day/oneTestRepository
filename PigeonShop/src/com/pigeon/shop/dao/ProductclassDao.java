package com.pigeon.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.Productclass;

public class ProductclassDao extends HibernateDaoSupport{
	public List<Productclass> findAll() {
		String hql="from Productclass";
		List<Productclass> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
