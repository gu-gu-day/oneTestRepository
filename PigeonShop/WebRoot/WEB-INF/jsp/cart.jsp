<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE>
<html>
  <head>

  </head>
  
  <body>
  <%@ include file="indexMenu.jsp" %>
  <h1>购物车</h1><hr>
    <s:iterator var="c" value="Cart">   
	  	<input type="hidden" id="id" name="id" value=<s:property value="#c.id"/>/>
	  	<input type="hidden" id="user" name="user" value=<s:property value="#c.user.username"/>/>
	   <ul>
	  	<li>商品:<s:property value="#c.product.name"/></li>
	  	<li>购买数量:<s:property value="#c.buyNumber"/></li>
	  	<li>价格:<s:property value="#c.price"/></li>
	  </ul>
	  	<a href="${ pageContext.request.contextPath }/orderform_createOrder.action"><b>购买</b></a>
	  	<a href="${ pageContext.request.contextPath }/cart_removeById.action"><b>移除</b></a>
	</s:iterator>

  </body>
</html>









