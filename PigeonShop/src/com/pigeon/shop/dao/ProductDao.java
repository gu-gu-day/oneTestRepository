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
	//��װ����������Ʒ
	public List<Product> findHot() {
		//����������ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//�����װcriteria.add(Restrictions.eq("isHot",1));
		//criteria.add(Restrictions.eq("producttype",3));//�ᵼ��500����boolean����eq�����int����eq,��һ���������
		Producttype type=new Producttype();
		//����Ҫ���ҵ�id
		type.setId(3);
		criteria.add(Restrictions.eq("producttype",type));
		//�������,û�������ֶΣ���id����
		criteria.addOrder(Order.desc("id"));
		//ִ�в�ѯ
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 3);
		return list;
	}

	public List<Product> findNew() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("id"));
		//ִ�в�ѯ
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
