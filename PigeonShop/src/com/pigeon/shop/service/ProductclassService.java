package com.pigeon.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.ProductclassDao;
import com.pigeon.shop.entity.Productclass;

@Transactional
public class ProductclassService {
	private ProductclassDao dao;

	public void setDao(ProductclassDao dao) {
		this.dao = dao;
	}

	public List<Productclass> findAll() {
		
		return dao.findAll();
	}
	

}
