<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
  <head>
    

  </head>
  
  <body>
    <%@ include file="storeMenu.jsp" %>
    <s:iterator var="o" value="storeOrder">
    <ul>
	  	<li>单号:<s:property value="#o.id"/></li>
	  	<li>买家:<s:property value="#o.user.username"/></li>
	  	<li>卖家:<s:property value="#o.store.name"/></li>
	  	<li>产品:<s:property value="#o.product.name"/></li>
	  	<li>数量:<s:property value="#o.buyNumber"/></li>
	  	<li>金额:<s:property value="#o.moneyAmount"/></li>
	  	<li>订单状态:<s:property value="#o.state"/></li>
	  	<s:if test="#o.state=='pending'">
	  		正在等待对方付款，请稍候~
	  	</s:if>
	  	<s:if test="#o.state=='confirm'">
	  		<a href="${ pageContext.request.contextPath }/orderform_finish.action"><b>发货</b></a>
	  		<a href="${ pageContext.request.contextPath }/orderform_cancled.action"><b>取消此订单</b></a>
	  	</s:if>
	  	<s:if test="#o.state=='finish'">
	  		此订单已完成~
	  	</s:if>
	  	<s:if test="#o.state=='complain'">
	  		这个订单被投诉了，<a href="#">去处理！</a>		
	  	</s:if>
	  	<s:if test="#o.state=='canceled'">
	  		此订单已被取消(		
	  	</s:if>
	  </ul>
	  <hr>
	</s:iterator>
  </body>
</html>
