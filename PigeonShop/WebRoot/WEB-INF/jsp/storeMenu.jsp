<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	<s:if test="#session.Store!=null">		
		<div>欢迎~:<s:property value="#session.Store.name"/></div>
                            <ul>
                                <li class="highlight"><a href="${ pageContext.request.contextPath }/store_store.action"><b>店铺首页</b></a></li>
                                <li><a href="${ pageContext.request.contextPath }/store_addProductPage.action"><b>新品上架</b></a></li>
                                <li><a href="${ pageContext.request.contextPath }/orderform_findByStore.action"><b>订单管理</b></a></li>
                                <li><a href="#"><b>本铺信息</b></a></li>
                                <li><a href="${ pageContext.request.contextPath }/store_logout.action"><b>退出登录</b></a></li>
                            </ul>
		</s:if>
	<s:else>
		咕咕咕，出错了，请尝试重新<a href="${ pageContext.request.contextPath }/store_loginPage.action"><b>登录</b></a>~
		</s:else>	
</div>