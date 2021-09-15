<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	<s:if test="#session.User!=null">
		
		<div>欢迎光临~<s:property value="#session.User.username"/></div>
		
                           
                 <a href="${ pageContext.request.contextPath }/index.action"><b>首页</b></a>|
                 <a href="${ pageContext.request.contextPath }/cart_findByUser.action"><b>购物车</b></a>|
                 <a href="${ pageContext.request.contextPath }/orderform_findByUser.action"><b>查看订单</b></a>|
                 <a href="#"><b>账号信息</b></a>|
                 <a href="${ pageContext.request.contextPath }/user_logout.action"><b>退出登录</b></a>
                          
		</s:if>
	<s:else>
		请先<a href="${ pageContext.request.contextPath }/user_loginPage.action"><b>登录</b></a>!没有账号？去<a href="${ pageContext.request.contextPath }/user_registPage.action"><b>注册</b></a>~
		</s:else>	
</div>