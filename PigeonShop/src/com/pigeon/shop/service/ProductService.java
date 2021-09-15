package com.pigeon.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.ProductDao;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Store;

@Transactional
public class ProductService {
	private ProductDao dao;

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	public List<Product> findHot() {
		return dao.findHot();
	}

	public List<Product> findNew() {
		
		return dao.findNew();
	}

	public Product findById(Integer id) {
		
		return dao.findById(id);
	}

	public List<Product> findByStore(Store store) {
		
		return dao.findByStore(store);
	}

	public void update(Product product) {
		
		dao.update(product);
	}

	public void addProduct(Product product) {
		
		dao.addProduct(product);
	}

	public void checking(Integer id) {
		
		dao.checking(id);
	}

	public void selling(Integer id) {
		// TODO Auto-generated method stub
		dao.selling(id);
	}

	public void cancled(Integer id) {
		// TODO Auto-generated method stub
		dao.cancled(id);
	}

	public List<Product> search(String search) {
		return dao.search(search);		
	}

	public List<Product> findAll() {
		return dao.findAll();
	}

	public List<Product> findUncheck() {
		return dao.findUncheck();
	}
	

}
