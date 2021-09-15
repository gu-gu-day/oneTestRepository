<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE>
<html>
  <head>
  </head>
  
  <body>
   <%@ include file="storeMenu.jsp" %>
   <h2>添加新商品</h2>
   <hr>
    <form id="addProductForm" action="${pageContext.request.contextPath}/product_addProduct.action"  method="post" enctype="multipart/form-data">
    <input type="hidden" id="store" name="store" value=<s:property value="#session.Store.id"/>/>
    <ul>
    	<li><input type="text" id="name" name="name" placeholder="商品名称" required/></li>
    	<li>
    		<select id="productClass" name="productClass.className">
    			<s:iterator var="c" value="classList">
    				<option value="<s:property value="#c.id"/>"><s:property value="#c.className"/></option>
    			</s:iterator>
    		</select>
    		<select id="productType" name="productType.typeName">
    			<s:iterator var="t" value="typeList">
    				<option value="<s:property value="#t.id"/>"><s:property value="#t.typeName"/></option>
    			</s:iterator>
    		</select>
    	</li>
    	<li><input type="text" id="remainingNumber" name="remainingNumber" placeholder="库存量" required/></li>
    	<li><input type="text" id="price" name="price" placeholder="价格" required/></li>
    	<li><textarea id="introduction" name="introduction" placeholder="介绍此商品吧~" rows="5" cols="30"></textarea></li>
    	<li><input type="file" id="pic" name="pic"/></li>
    </ul>
    <input type="submit" class="submit" value="添加此商品">	
    </form>
  </body>
</html>
