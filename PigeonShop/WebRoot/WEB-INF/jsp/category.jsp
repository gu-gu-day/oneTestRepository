<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
  <head>
    

  </head>
  
  <body>
  <h2>商品分类</h2>
  		
  
    <s:iterator var="c" value="classList">
    
  	<ul>
  		<li>编号：<s:property value="#c.id"/></li>
  		<li>名称：<s:property value="#c.className"/></li>
  		<li>备注：<s:property value="#c.remark"/></li>
  		
  	</ul>
  		<a href="${ pageContext.request.contextPath }/productclass_delete.action?id=<s:property value="#c.id"/>">修改此分类</a>|
  		<a href="${ pageContext.request.contextPath }/productclass_delete.action.action?id=<s:property value="#c.id"/>"><b>删除此分类</b></a>
	  <hr>
	</s:iterator>
	<hr>
	
	 <h2>商品分种</h2>
  		
  
    <s:iterator var="t" value="typeList">
   
  	<ul>
  		<li>编号：<s:property value="#t.id"/></li>
  		<li>名称：<s:property value="#t.typeName"/></li>
  		<li>所属种：<s:property value="#t.productclass.className"/></li>
  		<li>备注：<s:property value="#t.remark"/></li>
  	</ul>	
  		<a href="${ pageContext.request.contextPath }/producttype_delete.action?id=<s:property value="#t.id"/>">修改此分种</a>|
  		<a href="${ pageContext.request.contextPath }/producttype_delete.action.action?id=<s:property value="#t.id"/>"><b>删除此分种</b></a>
	  <hr>
	</s:iterator>
	添加商品分类
	<form name="addclass" action="${pageContext.request.contextPath}/productclass_add.action" method="post">
			<input type="text" id="className" name="className" maxlength="32" placeholder="要添加的分类名称"/>
		    <input type="submit" class="submit" value="添加此分类"/>
	</form>
	添加商品分种
	<form  name="addtype" action="${pageContext.request.contextPath}/producttype_add.action" method="post">
			<input type="text" id="typeName" name="typeName" maxlength="32" placeholder="要添加的分种名称"/>
			<select id="productClass" name="productClass.className">
    			<s:iterator var="c" value="classList">
    				<option value="<s:property value="#c.id"/>"><s:property value="#c.className"/></option>
    			</s:iterator>
    		</select>
		    <input type="submit" class="submit" value="添加此分种"/>
	</form>
  </body>
</html>
