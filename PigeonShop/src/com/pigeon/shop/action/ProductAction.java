package com.pigeon.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.entity.Product;
import com.pigeon.shop.entity.Productclass;
import com.pigeon.shop.entity.Producttype;
import com.pigeon.shop.service.ProductService;
import com.pigeon.shop.service.ProductclassService;
import com.pigeon.shop.service.ProducttypeService;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product=new Product();
	public Product getModel() {
		return product;
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
	
	private File pic;
	private String picFileName;
	private String picContentType;
	
	
	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public String findByClass(){
		return "findByClass";
	}
	
	public String findByType(){
		return "findByType";
	}
	
	
	public String findById(){
		product=productService.findById(product.getId());
		return "findById";
	}
	
	private String search;
	
	public String getSearch() {
		
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String addProduct() throws IOException{
		//product.setDate(new Date());
		product.setState("checking");
		if(pic!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
			File diskFile=new File(realPath+"//"+picFileName);
			FileUtils.copyFile(pic, diskFile);
			product.setPicture("upload/"+picFileName);
		}
		productService.addProduct(product);
		return "addProduct";
	}
	
	public String updateById(){
		product=productService.findById(product.getId());
		
		List<Productclass> classList=productclassService.findAll();
		ActionContext.getContext().getValueStack().set("classList", classList);
		
		List<Producttype> typeList=producttypeService.findAll();
		ActionContext.getContext().getValueStack().set("typeList", typeList);
		
		
		productService.update(product);
		return "update";
	}
	
	public String search(){
		System.out.println(search);
		List<Product> list=productService.search(search);
		ActionContext.getContext().getValueStack().set("searchList", list);
		return "search";
	}
	//ÉóºË
	public String checking(){
		productService.checking(product.getId());
		return "checking";
	}
	//Õý³£
	public String selling(){
		productService.selling(product.getId());
		return "selling";
	}
	//ÏÂ¼Ü
	public String cancled(){
		productService.cancled(product.getId());
		return "cancled";
	}
}
