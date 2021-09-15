package com.pigeon.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.OrderformDao;
import com.pigeon.shop.entity.Orderform;

@Transactional
public class OrderformService {
	private OrderformDao dao;

	public void setDao(OrderformDao dao) {
		this.dao = dao;
	}

	public List<Orderform> findByUser() {
		
		return dao.findByUser();
	}
	
	public List<Orderform> findByStore() {
		
		return dao.findByStore();
	}

	public void pending(Integer id) {
		
		dao.pending(id);
	}
	
	public void confirm(Integer id) {
		
		dao.confirm(id);
	}
	public void finish(Integer id) {
		
		dao.finish(id);
	}
	public void cancled(Integer id) {
		
		dao.cancled(id);
	}
	public void complain(Integer id) {
		
		dao.complain(id);
	}
	

}
