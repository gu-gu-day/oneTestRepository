<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>鸽子商城,快乐摸鱼每一天~</title>

</head>

<body>

<%@ include file="indexMenu.jsp" %>
搜索商品:
<form name="searchForm" action="${pageContext.request.contextPath}/product_search.action" method="post">
	<input type="text" id="search" name="search" maxlength="32" placeholder="输入要查找的商品名"/>
    <input type="submit" class="submit" value="查找"/>
</form>
<hr/>
<h2>热门商品</h2><hr>
<ul style="display:block">
<s:iterator var="p" value="hotList">	
	<li>
		<a href="${pageContext.request.contextPath}/product_findById.action?id=<s:property value="#p.id"/>"  target="_blank"><img src="${pageContext.request.contextPath}/upload/<s:property value="#p.picture"/>"  style="width:200px;height:150px;display:block;"/></a>
	</li>
</s:iterator>
</ul>
<h2>最新商品</h2><hr>
<ul style="display:block">
<s:iterator var="p" value="newList">
	<li>
		<a href="${pageContext.request.contextPath}/product_findById.action?id=<s:property value="#p.id"/>" target="_blank"><img src="${pageContext.request.contextPath}/upload/<s:property value="#p.picture"/>"  style="width:200px;height:150px;display:block;"/></a>
	</li>
</s:iterator>
</ul>
</body>

</html>
