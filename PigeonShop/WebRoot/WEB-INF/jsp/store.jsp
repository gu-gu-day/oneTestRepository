<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>你店</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>

<body>

<%@ include file="storeMenu.jsp" %>
<h2>本店商品</h2><hr>
<ul style="display:block">
<s:iterator var="p" value="storeList">	
	<li>
		<img src="${pageContext.request.contextPath}/upload/<s:property value="#p.picture"/>"  style="width:200px;height:150px;display:block;"/>
		<a href="${pageContext.request.contextPath}/product_updateById.action?id=<s:property value="#p.id"/>"  target="_blank">管理</a>
	</li>
</s:iterator>
</ul>
</body>

</html>
