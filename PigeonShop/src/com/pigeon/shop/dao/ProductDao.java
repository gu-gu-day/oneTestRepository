package com.pigeon.shop.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Producttype;
import com.pigeon.shop.entity.Store;

public class ProductDao extends HibernateDaoSupport{
	//假装查找热门商品
	public List<Product> findHot() {
		//离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查鸟假装criteria.add(Restrictions.eq("isHot",1));
		//criteria.add(Restrictions.eq("producttype",3));//会导致500错误，boolean可以eq而外键int不可eq,需一个外键对象
		Producttype type=new Producttype();
		//设置要查找的id
		type.setId(3);
		criteria.add(Restrictions.eq("producttype",type));
		//倒序输出,没有日期字段，用id代替
		criteria.addOrder(Order.desc("id"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 3);
		return list;
	}

	public List<Product> findNew() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("id"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 3);
		return list;
	}

	public Product findById(Integer id) {
		return this.getHibernateTemplate().get(Product.class, id);
	}

	public List<Product> findByStore(Store store) {
		String hql="from Product where belongstore=?";
		List<Product> list=this.getHibernateTemplate().find(hql,store.getId());
		System.out.println(list.size());
		return list;
	}

	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

	public void addProduct(Product product) {
		
		this.getHibernateTemplate().save(product);
	}

	public void checking(Integer id) {
		String hql="update Product p set p.state=? where id=?";
		this.getHibernateTemplate().find(hql,"checking",id);
	}

	public void selling(Integer id) {
		String hql="update Product p set p.state=? where id=?";
		this.getHibernateTemplate().find(hql,"selling",id);
	}

	public void cancled(Integer id) {
		String hql="update Product p set p.state=? where id=?";
		this.getHibernateTemplate().find(hql,"cancled",id);
	}

	public List<Product> search(String search) {
		String hql="from Product where 1=1 and name like ?";
		
		List<Product> list=this.getHibernateTemplate().find(hql,"%"+search+"%");
		System.out.println(list.size());
		return list;
	}

	public List<Product> findAll() {
		
		List<Product> list=this.getHibernateTemplate().find("from Product");
		return list;
	}
	
	public List<Product> findUncheck() {
		
		List<Product> list=this.getHibernateTemplate().find("from Product where state='checking'");
		return list;
	}

}
