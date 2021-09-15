package com.pigeon.shop.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.Cart;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.User;

public class CartDao extends HibernateDaoSupport{

	public List<Cart> findByUser() {
		String hql="from Cart where user=?";
		
		List<Cart> list=this.getHibernateTemplate().find(hql,(User)ServletActionContext.getRequest().getSession().getAttribute("User"));
		System.out.println(list.size());
		return list;
	}

	public Cart findById(Cart cart) {
		String hql="from Cart where user=?";
		List<Cart> list=this.getHibernateTemplate().find(hql,cart.getUser());
		return list.get(0);
	}

	public void removeById(Cart cart) {
		this.getHibernateTemplate().delete(cart);	
	}

	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(cart);
	}

}
