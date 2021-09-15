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
	//ģ������ʹ�ö���
	private Store store=new Store();
	public Store getModel(){
		return store;
	}
	
	//ע��UserService
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
		//����service
		Store existAccount =storeService.findByAccount(store.getAccount());
		//���response����,��ҳ�����
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		if(existAccount!=null){
			response.getWriter().println("<font color='red'>����˺ű�ʹ����</font>");
		}
		else{
			response.getWriter().println("<font color='green'>����˺ſ���ʹ��</font>");
		}
		System.out.println("action finish");
		return NONE;
		
	}
	public String regist(){
		storeService.save(store);
		return "reg";
	}
	public String login(){
		//�����û���Ϣ
		Store existStore=storeService.login(store);
		System.out.println(store.getAccount());
		if(existStore==null){
			this.addActionError("��Ϣδ�ҵ��������˺�������");
			return "loginFailed";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("Store", existStore);
			//�������(����
			List<Product> storeList=productService.findByStore(existStore);
			//������ֵջ
			ActionContext.getContext().getValueStack().set("storeList", storeList);
			return "loginSuccess";
		}
	}
	
	public String store(){
		List<Product> storeList=productService.findByStore((Store)ServletActionContext.getRequest().getSession().getAttribute("Store"));
		//������ֵջ
		ActionContext.getContext().getValueStack().set("storeList", storeList);
		return "store";
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	
}



