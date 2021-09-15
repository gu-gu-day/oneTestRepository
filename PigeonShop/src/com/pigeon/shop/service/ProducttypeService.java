package com.pigeon.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.ProducttypeDao;
import com.pigeon.shop.entity.Producttype;

@Transactional
public class ProducttypeService {
	private ProducttypeDao dao;

	public void setDao(ProducttypeDao dao) {
		this.dao = dao;
	}

	public List<Producttype> findAll() {
	
		return dao.findAll();
	}
	

}
