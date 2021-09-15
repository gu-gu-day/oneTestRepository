package com.pigeon.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Productclass;
import com.pigeon.shop.entity.Producttype;
import com.pigeon.shop.entity.Store;
import com.pigeon.shop.entity.User;

import com.pigeon.shop.service.ProductService;
import com.pigeon.shop.service.ProductclassService;
import com.pigeon.shop.service.ProducttypeService;
import com.pigeon.shop.service.StoreService;

public class StoreAction extends ActionSupport implements ModelDriven<Store>{
	//模型驱动使用对象
	private Store store=new Store();
	public Store getModel(){
		return store;
	}
	
	//注入UserService
	private StoreService storeService;
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	private ProductService productService;
	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	private ProductclassService productclassService;
	private ProducttypeService producttypeService;
	

	public void setProductclassService(ProductclassService productclassService) {
		this.productclassService = productclassService;
	}

	public void setProducttypeService(ProducttypeService producttypeService) {
		this.producttypeService = producttypeService;
	}
	
	public String loginPage(){
		return "loginPage";
	}
	
	public String registPage(){
		return "registPage";
	}
	
	public String addProductPage(){
		List<Productclass> classList=productclassService.findAll();
		ActionContext.getContext().getValueStack().set("classList", classList);
		
		List<Producttype> typeList=producttypeService.findAll();
		ActionContext.getContext().getValueStack().set("typeList", typeList);
		return "addProductPage";
	}
	
	public String orderformPage(){
		return "orderformPage";
	}
	
	public String findByAccount() throws IOException{
		System.out.println("action start");
		System.out.println(store.getAccount());
		//调用service
		Store existAccount =storeService.findByAccount(store.getAccount());
		//获得response对象,向页面输出
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		if(existAccount!=null){
			response.getWriter().println("<font color='red'>这个账号被使用了</font>");
		}
		else{
			response.getWriter().println("<font color='green'>这个账号可以使用</font>");
		}
		System.out.println("action finish");
		return NONE;
		
	}
	public String regist(){
		storeService.save(store);
		return "reg";
	}
	public String login(){
		//查找用户信息
		Store existStore=storeService.login(store);
		System.out.println(store.getAccount());
		if(existStore==null){
			this.addActionError("信息未找到，请检查账号与密码");
			return "loginFailed";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("Store", existStore);
			//定向查找(本店
			List<Product> storeList=productService.findByStore(existStore);
			//保存至值栈
			ActionContext.getContext().getValueStack().set("storeList", storeList);
			return "loginSuccess";
		}
	}
	
	public String store(){
		List<Product> storeList=productService.findByStore((Store)ServletActionContext.getRequest().getSession().getAttribute("Store"));
		//保存至值栈
		ActionContext.getContext().getValueStack().set("storeList", storeList);
		return "store";
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	
}



