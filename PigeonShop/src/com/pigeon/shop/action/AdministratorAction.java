package com.pigeon.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.entity.Administrator;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Productclass;
import com.pigeon.shop.entity.Producttype;
import com.pigeon.shop.entity.User;
import com.pigeon.shop.service.AdministratorService;
import com.pigeon.shop.service.ProductService;
import com.pigeon.shop.service.ProductclassService;
import com.pigeon.shop.service.ProducttypeService;

public class AdministratorAction extends ActionSupport implements ModelDriven<Administrator>{
	//ģ������ʹ�ö���
	private Administrator ad=new Administrator();
	public Administrator getModel(){
		return ad;
	}
	
	//ע��UserService
	private AdministratorService administratorService;
	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
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
	
	public String showProductPage(){
		List<Product> list=productService.findAll();
		ActionContext.getContext().getValueStack().set("allProduct", list);
		return "showProductPage";
	}
	
	
	public String checkProductPage(){
		List<Product> list=productService.findUncheck();
		ActionContext.getContext().getValueStack().set("uncheckProduct", list);
		return "checkProductPage";
	}
	
	public String categoryPage(){
		List<Productclass> classList=productclassService.findAll();
		List<Producttype> typeList=producttypeService.findAll();
		ActionContext.getContext().getValueStack().set("classList", classList);
		ActionContext.getContext().getValueStack().set("typeList", typeList);
		return "categoryPage";
	}
	
	public String findByAccount() throws IOException{
		System.out.println("action start");
		System.out.println(ad.getAccount());
		//����service
		Administrator existAccount =administratorService.findByAccount(ad.getAccount());
		//���response����,��ҳ�����
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		if(existAccount!=null){
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		}
		else{
			response.getWriter().println("<font color='green'>�û�������ʹ��Ӵ</font>");
		}
		System.out.println("action finish");
		return NONE;
		
	}
	public String regist(){
		administratorService.save(ad);
		return "reg";
	}
	public String login(){
		Administrator existAd=administratorService.login(ad);
		System.out.println(ad.getAccount());
		if(existAd==null){
			this.addActionError("ʧ�����أ������û���������~");
			return "loginFailed";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("Ad", existAd);
			return "loginSuccess";
		}
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
}
