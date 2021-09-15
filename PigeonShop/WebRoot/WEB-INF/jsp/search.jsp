<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE">
<html>
  <head>

  </head>
  
  <body>
    <%@ include file="indexMenu.jsp" %>
		搜索商品:
		<form  name="search" action="${pageContext.request.contextPath}/product_search.action" method="post">
			<input type="text" id="search" name="search" maxlength="32" placeholder="输入要查找的商品名"/>
		    <input type="submit" class="submit" value="查找"/>
		</form>
		<hr>
		<ul style="display:block">
		<s:iterator var="s" value="searchList">	
			<li>
				<a href="${pageContext.request.contextPath}/product_findById.action?id=<s:property value="#s.id"/>"  target="_blank"><img src="${pageContext.request.contextPath}/upload/<s:property value="#s.picture"/>"  style="width:200px;height:150px;display:block;"/></a>
			</li>
		</s:iterator>
  </body>
</html>
