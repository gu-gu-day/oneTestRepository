package com.pigeon.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.Producttype;

public class ProducttypeDao extends HibernateDaoSupport{

	public List<Producttype> findAll() {
		String hql="from Producttype";
		List<Producttype> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
