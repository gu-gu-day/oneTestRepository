package com.pigeon.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pigeon.shop.dao.CartDao;
import com.pigeon.shop.entity.Cart;
import com.pigeon.shop.entity.Product;

@Transactional
public class CartService {
	private CartDao dao;

	public void setDao(CartDao dao) {
		this.dao = dao;
	}
	
	public Cart findById(Cart cart) {
		return dao.findById(cart);
	}

	public List<Cart> findByUser() {
		return dao.findByUser();
	}

	public void removeById(Cart cart) {
		dao.removeById(cart);
	}

	public void addCart(Cart cart) {
		
		dao.addCart(cart);
	}
}
