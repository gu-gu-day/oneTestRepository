<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE>
<html>
  <head>

  </head>
  
  <body>
    尊敬的管理员:<s:property value="#session.Ad.account"/>，欢迎<hr>
    			 <a href="${ pageContext.request.contextPath }/index.action"><b>看看首页</b></a>|
                 <a href="${ pageContext.request.contextPath }/administrator_showProductPage.action"><b>浏览商品</b></a>|
                 <a href="${ pageContext.request.contextPath }/administrator_checkProductPage.action"><b>审核商品</b></a>|
                 <a href="${ pageContext.request.contextPath }/administrator_categoryPage.action"><b>分类管理</b></a>|
                 <a href="${ pageContext.request.contextPath }/administrator_logout.action"><b>退出</b></a>
  </body>
</html>
