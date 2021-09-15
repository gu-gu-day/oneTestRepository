<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>

<!DOCTYPE>
<html>
  <head>
	<script>
		function cart(){
			document.getElementById("cartForm").submit();
		}
	</script>
  </head>
  
  <body>
  <%@ include file="indexMenu.jsp" %>
  	<img src="${pageContext.request.contextPath}/upload/<s:property value="model.picture"/>" style="width:200px;height:150px;display:block;">
  	<ul>
  		<li>编号：<s:property value="model.id"/></li>
  		<li>名称：<s:property value="model.name"/></li>
  		<li>价格：<s:property value="model.price"/></li>
  		<li>库存：<s:property value="model.remainingNumber"/></li>
  		<li>种：<s:property value="model.productclass.className"/></li>
  		<li>类：<s:property value="model.producttype.typeName"/></li>
  		<li>介绍：<s:property value="model.introduction"/></li>
  		<li>卖家：<s:property value="model.store.name"/></li>
  	</ul>
  	<a href="${ pageContext.request.contextPath }/orderform_createOrder.action"><b>买这个!</b></a><hr>
  	
  	<form  id="cartForm" action="${pageContext.request.contextPath}/cart_addCart.action " method="post" >
  	 <input type="hidden" id="user" name="user" value=<s:property value="#session.User.username"/>/><br>
  	 <input type="hidden" id="product" name="product" value="model.id"/>
  	 <input type="hidden" id="price" name="price" value="model.price"/>
  	购买数量:<input type="text" id="buyNumber" name="buyNumber" value="1"/><br>
    <input id="addCart" class="addCart" value="加入购物车！" type="button" onclick="cart()">
    </form>
  </body>
</html>
