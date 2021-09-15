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
			var username=document.getElementById("username").value;
			if(username==null||username==''){
				alert("username is null");
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
	<form id="userLoginForm" action="${ pageContext.request.contextPath }/user_login.action" method="post">
		<div class="main">
			<div class="header" >
				<h1>欢迎</h1>
			</div>
			<p></p>
			
				<ul class="right-form">
					<h3>登录:</h3>
					<div>
						<li><input type="text" id="username" name="username" placeholder="填用户名" /></li>
						<li><input type="password"  id="password" name="password" placeholder="填密码" required/></li>
						<a href="#">召回密码!</a>
						<input type="submit" class="submit" value="我进来啦" ><br>
						还没有账号？去<a href="${ pageContext.request.contextPath }/user_registPage.action"><b>注册</b></a>
						<strong><s:actionerror/></strong>
					</div>
					<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>					
				<a href="${ pageContext.request.contextPath }/store_loginPage.action">企业登录</a>
		</div>
	</form>	
</body>
</html>