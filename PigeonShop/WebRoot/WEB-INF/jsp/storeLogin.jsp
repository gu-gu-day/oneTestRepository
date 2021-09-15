<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
		<link href="${pageContext.request.contextPath}/css/LoginAndRegistStyle.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<script>
		function checkForm(){
			var account=document.getElementById("account").value;
			if(account==null||account==''){
				alert("account is null");
				return false;
			}
			var password=document.getElementById("password").value;
			if(password==null||password==''){
				alert("password name is null");
				return false;
			}
		}
		</script>
</head>
  
<body>
	<form id="storeLoginForm" action="${ pageContext.request.contextPath }/store_login.action" method="post">
		<div class="main">
			<div class="header" >
				<h1>欢迎</h1>
			</div>
			<p></p>
			
				<ul class="right-form">
					<h3>登录:</h3>
					<div>
						<li><input type="text" id="account" name="account" placeholder="于此填账号" required/></li>
						<li><input type="password"  id="password" name="password" placeholder="于此填写密码" required/></li>
						<a href="#">密码忘了?</a>
						<input type="submit" class="submit" value="飞回鹿上" ><br>
						还没有账号？去<a href="${ pageContext.request.contextPath }/user_registPage.action"><b>注册</b></a>
						<strong><s:actionerror/></strong>
					</div>
					<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>					
				<a href="${ pageContext.request.contextPath }/user_loginPage.action">普通用户登录</a>|
				<a href="${ pageContext.request.contextPath }/administrator_loginPage.action">管理员</a>登录
				
		</div>
	</form>
</body>
</html>
