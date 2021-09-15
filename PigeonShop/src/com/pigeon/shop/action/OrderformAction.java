package com.pigeon.shop.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.entity.Cart;
import com.pigeon.shop.entity.Orderform;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Producttype;
import com.pigeon.shop.entity.Store;
import com.pigeon.shop.entity.User;
import com.pigeon.shop.service.OrderformService;
import com.pigeon.shop.service.ProductService;
import com.pigeon.shop.service.StoreService;

public class OrderformAction extends ActionSupport implements ModelDriven<Orderform>{
	private Orderform orderform=new Orderform();
	public Orderform getModel() {
		// TODO Auto-generated method stub
		return orderform;
	}
	
	private OrderformService orderformService;
	public void setOrderformService(OrderformService orderformService) {
		this.orderformService = orderformService;
	}
	
	private StoreService storeService;
	private ProductService productService;
	
	
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String createOrder(){
		orderform.setState("pending");
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("User");
		Store store=storeService.findByAccount("storeC");
		Product product=productService.findById(25);
		orderform.setUser(user);
		orderform.setMoneyAmount((double) 188);
		orderform.setBuyNumber(1);
		orderform.setStore(store);
		orderform.setProduct(product);
		return "createOrder";
	}
	
	public String findByUser(){
		List<Orderform> list=orderformService.findByUser();
		ActionContext.getContext().getValueStack().set("userOrder", list);
		return "userOrder";
	}
	
	public String findByStore(){
		List<Orderform> list=orderformService.findByStore();
		ActionContext.getContext().getValueStack().set("storeOrder", list);
		return "storeOrder";
	}
	
	//设置订单状态
	//待付款
	public String pending(){
		orderformService.pending(orderform.getId());
		return "pending";
	}
	//待发货
	public String confirm(){
		orderformService.confirm(orderform.getId());
		return "confirm";
	}
	//已完成
	public String finish(){
		orderformService.finish(orderform.getId());
		return "finish";
	}
	//被取消
	public String canceled(){
		orderformService.cancled(orderform.getId());
		return "canceled";
	}
	//投诉中
	public String complain(){
		orderformService.complain(orderform.getId());
		return "complain";
	}
}
