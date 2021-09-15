package com.pigeon.shop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pigeon.shop.service.UserService;
import com.pigeon.shop.entity.Cart;
import com.pigeon.shop.entity.User;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动使用对象
	private User user=new User();
	public User getModel(){
		return user;
	}
	
	//注入UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String registPage(){
		return "registPage";
	}
	
	public String loginPage(){
		return "loginPage";
	}
	
	public String cartPage(){
		return "cartPage";
	}
	
	public String orderformPage(){
		return "orderformPage";
	}
	
	public String userInformationPage(){
		return "personalInformationPage";
	}
	
	public String findByUsername() throws IOException{
		System.out.println("action start");
		System.out.println(user.getUsername());
		//调用service
		User existUsername =userService.findByUsername(user.getUsername());
		//获得response对象,向页面输出
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		if(existUsername!=null){
			response.getWriter().println("<font color='red'>这个名字被占用了/font>");
		}
		else{
			response.getWriter().println("<font color='green'>可以使用!</font>");
		}
		System.out.println("action finish");
		return NONE;
		
	}
	
	public String regist(){
		userService.save(user);
		return "regist";
	}
	
	public String login(){
		User existUser=userService.login(user);
		System.out.println(user.getUsername());
		if(existUser==null){
			this.addActionError("失败了呢，请检查用户名与密码~");
			return "loginFailed";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("User", existUser);
			return "loginSuccess";
		}
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
}
