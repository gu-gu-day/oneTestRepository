package com.pigeon.shop.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.Cart;
import com.pigeon.shop.entity.Orderform;

public class OrderformDao extends HibernateDaoSupport{

	public List<Orderform> findByUser() {
		String hql="from Orderform where buyer=?";
		
		List<Orderform> list=this.getHibernateTemplate().find(hql,ServletActionContext.getRequest().getSession().getAttribute("User"));
		
		return list;
	}
	
	public List<Orderform> findByStore() {
		String hql="from Orderform where seller=?";
		
		List<Orderform> list=this.getHibernateTemplate().find(hql,ServletActionContext.getRequest().getSession().getAttribute("Store"));
		
		return list;
	}

	public void pending(Integer id) {
		String hql="update Orderform o set o.state=? where id=?";
		this.getHibernateTemplate().find(hql,"pending",id);
		
	}

	public void confirm(Integer id) {
		String hql="update Orderform o set o.state=? where id=?";
		this.getHibernateTemplate().find(hql,"confirm",id);

	}

	public void finish(Integer id) {
		String hql="update Orderform o set o.state=? where id=?";
		this.getHibernateTemplate().find(hql,"finish",id);
		
	}

	public void cancled(Integer id) {
		String hql="update Orderform o set o.state=? where id=?";
		this.getHibernateTemplate().find(hql,"cancled",id);
	
	}

	public void complain(Integer id) {
		String hql="update Orderform o set o.state=? where id=?";
		this.getHibernateTemplate().find(hql,"complain",id);

	}


}
