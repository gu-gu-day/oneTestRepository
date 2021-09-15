<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   

  </head>
  
  <body>
 	<form id="updateProductForm" action="${pageContext.request.contextPath}/product_updateProduct.action"  method="post" enctype="multipart/form-data">
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
    <input type="submit" class="submit" value="更新该商品">	
    </form>
  </body>
</html>
