package com.pigeon.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Producttype;
import com.pigeon.shop.service.ProductService;
import com.pigeon.shop.service.ProducttypeService;

public class ProducttypeAction extends ActionSupport implements ModelDriven<Producttype>{
	private Producttype producttype=new Producttype(); 
	public Producttype getModel() {
		// TODO Auto-generated method stub
		return producttype;
	}
	
	private ProducttypeService producttypeService;
	public void setProducttypeService(ProducttypeService producttypeService) {
		this.producttypeService = producttypeService;
	}

}
