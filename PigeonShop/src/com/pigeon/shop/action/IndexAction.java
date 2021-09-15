package com.pigeon.shop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Productclass;
import com.pigeon.shop.entity.Producttype;
import com.pigeon.shop.service.ProductService;
import com.pigeon.shop.service.ProductclassService;
import com.pigeon.shop.service.ProducttypeService;

public class IndexAction extends ActionSupport{
	
	private ProductService productService;
	
	private ProductclassService productclassService;
	
	private ProducttypeService producttypeService;
	
	
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setProductclassService(ProductclassService productclassService) {
		this.productclassService = productclassService;
	}

	public void setProducttypeService(ProducttypeService producttypeService) {
		this.producttypeService = producttypeService;
	}

	public String execute(){
		
		//查找分类
		List<Productclass> classList=productclassService.findAll();
		//存储分类
		ActionContext.getContext().getSession().put("classList", classList);
		//查找分种
		List<Producttype> typeList=producttypeService.findAll();
		//存储分种
		
		ActionContext.getContext().getSession().put("typeList", typeList);
		/**/
		//定向查找(热门
		List<Product> hotList=productService.findHot();
		//保存至值栈
		ActionContext.getContext().getValueStack().set("hotList", hotList);
		
		//定向查找(按时间
		List<Product> newList=productService.findNew();
		ActionContext.getContext().getValueStack().set("newList", newList);
		
		return "index";
	}
}
