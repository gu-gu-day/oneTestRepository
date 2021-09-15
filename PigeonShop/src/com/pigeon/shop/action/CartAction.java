package com.pigeon.shop.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.entity.Cart;
import com.pigeon.shop.service.CartService;
import com.pigeon.shop.service.ProductService;

public class CartAction extends ActionSupport implements ModelDriven<Cart>{
	private Cart cart=new Cart();

	public Cart getModel() {
		// TODO Auto-generated method stub
		return cart;
	}
	
	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String addCart(){
		//应当判断是否存在,未执行
		cartService.addCart(cart);
		
		return "addCart";
	}
	
	public String findByUser(){
		List<Cart> list=cartService.findByUser();
		ActionContext.getContext().getValueStack().set("Cart", list);
		return "cart";
	}
	
	public String findById(){
		cart=cartService.findById(cart);
		ServletActionContext.getRequest().getSession().setAttribute("CartDetail", cart);
		return "cartDetail";
	}
	
	public String removeById(){
		cartService.removeById(cart);
		return "cart";
	}
	
	
}
