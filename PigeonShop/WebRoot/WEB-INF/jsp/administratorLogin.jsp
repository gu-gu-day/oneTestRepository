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
	<form id="storeLoginForm" action="${ pageContext.request.contextPath }/administrator_login.action" method="post">
		<div class="main">
			<div class="header" >
				<h1>欢迎，管理员</h1>
			</div>
			<p></p>
			
				<ul class="right-form">
					<h3>登录:</h3>
					<div>
						<li><input type="text" id="account" name="account" placeholder="账号，这里" required/></li>
						<li><input type="password"  id="password" name="password" placeholder="密码，这里" required/></li>
						
						<input type="submit" class="submit" value="登录" ><br>
						<strong><s:actionerror/></strong>
					</div>
					<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>					
				<a href="${ pageContext.request.contextPath }/index.action">回主页</a>
				
		</div>
	</form>
</body>
</html>
