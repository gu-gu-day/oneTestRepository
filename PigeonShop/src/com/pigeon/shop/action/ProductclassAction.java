package com.pigeon.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Productclass;
import com.pigeon.shop.service.ProductService;
import com.pigeon.shop.service.ProductclassService;

public class ProductclassAction extends ActionSupport implements ModelDriven<Productclass>{
	private Productclass productclass=new Productclass();
	public Productclass getModel() {
		// TODO Auto-generated method stub
		return productclass;
	}
	
	private ProductclassService productclassService;
	public void setProductclassService(ProductclassService productclassService) {
		this.productclassService = productclassService;
	}

}
