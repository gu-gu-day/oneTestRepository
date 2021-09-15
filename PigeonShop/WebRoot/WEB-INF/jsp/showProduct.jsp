<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE>
<html>
  <head>
   
  </head>
  
  <body>
    
    <s:iterator var="p" value="allProduct">
    <img src="${pageContext.request.contextPath}/upload/<s:property value="#p.picture"/>" style="width:200px;height:150px;display:block;">
  	<ul>
  		<li>编号：<s:property value="#p.id"/></li>
  		<li>名称：<s:property value="#p.name"/></li>
  		<li>价格：<s:property value="#p.price"/></li>
  		<li>库存：<s:property value="#p.remainingNumber"/></li>
  		<li>种：<s:property value="#p.productclass.className"/></li>
  		<li>类：<s:property value="#p.producttype.typeName"/></li>
  		<li>介绍：<s:property value="#p.introduction"/></li>
  		<li>卖家：<s:property value="#p.store.name"/></li>
  		<li>状态：<s:property value="#p.state"/></li>
  	</ul>
  		<s:if test="#p.state=='checking'">
	  		<a href="${ pageContext.request.contextPath }/product_selling.action"><b>通过审核</b></a>
	  	</s:if>
	  	<s:if test="#p.state=='selling'">
	  		<a href="${ pageContext.request.contextPath }/orderform_canceled.action"><b>下架此商品</b></a>
	  	</s:if>
	  	<s:if test="#p.state=='canceled'">
	  		商品已下架
	  	</s:if>
	  <hr>
	</s:iterator>
  </body>
</html>