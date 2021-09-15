<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE>
<html>
  <head>

  </head>
  
  <body>
   <%@ include file="indexMenu.jsp" %>
   <s:iterator var="o" value="userOrder">
   <ul>
	  	<li>单号:<s:property value="#o.id"/></li>
	  	<li>买家:<s:property value="#o.user.username"/></li>
	  	<li>卖家:<s:property value="#o.store.name"/></li>
	  	<li>产品:<s:property value="#o.product.name"/></li>
	  	<li>数量:<s:property value="#o.buyNumber"/></li>
	  	<li>金额:<s:property value="#o.moneyAmount"/></li>
	  	<li>订单状态:<s:property value="#o.state"/></li>
	  	<s:if test="#o.state=='pending'">
	  		<a href="${ pageContext.request.contextPath }/orderform_confirm.action"><b>付款</b></a>
	  		<a href="#">取消</a>
	  	</s:if>
	  	<s:if test="#o.state=='confirm'">
	  		正在等待商家发货，稍后~
	  	</s:if>
	  	<s:if test="#o.state=='finish'">
	  		<a href="${ pageContext.request.contextPath }/orderform_complain.action"><b>投诉</b></a>
	  		
	  	</s:if>
	  	<s:if test="#o.state=='canceled'">
	  		这个订单被取消了)
	  	</s:if>
	  	<s:if  test="#o.state=='complain'">
	  		投诉请求待处理中，请稍稍稍稍稍候~
	  	</s:if>
	 </ul>	
	 <hr>
	</s:iterator>
  </body>
</html>
