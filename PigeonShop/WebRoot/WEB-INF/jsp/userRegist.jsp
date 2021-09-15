<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
		<link href="${pageContext.request.contextPath}/css/LoginAndRegistStyle.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<script type="text/javascript">
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
				var repassword=document.getElementById("repassword").value;
				if(!(password==repassword)){
					alert("password  is  not same");
					return false;
				}
			}
			//ajax异步校验
			function checkUsername(){
			console.log("aaa");
			console.log(new Date());
				//获取值
				var username=document.getElementById("username").value;
				//创建异步交互对象
				var xhr=createXmlHttp();
				
				//设置监听
				xhr.onreadystatechange=function(){
					if(xhr.readyState==4){
						if(xhr.status==200){
							document.getElementById("span1").innerHTML=xhr.responseText;
						}
					}
				}
				//打开链接
				xhr.open("GET","${pageContext.request.contextPath}/user_findByUsername.action?time="+new Date().getTime()+"&username="+username,true);
				//发送
				xhr.send(null);
			}
			
			function createXmlHttp(){
				var xmlHttp;
				try{
					xmlHttp=new XMLHttpRequest();
				}
				catch(e){
					try{
						xmlHttp=new ActiveXObject("Msxm12.XMLHTTP");
					}
					catch(e){
						try{
							xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
						}
						catch(e){}
					}
					
					
					}
					return xmlHttp;
				}	
		</script>
  </head>
  
<body>
	<form id="userRegisterForm" action="${pageContext.request.contextPath}/user_regist.action"  method="post" novalidate="novalidate" onsubmit="return checkForm();">
		<div class="main">
			<div class="header" >
				<h1>欢迎</h1>
			</div>
			<p></p>
			
				<ul class="left-form">
					<h2>创建一个新账号~</h2>
					<li>
						
						<input type="text" id="username" name="username" maxlength="32" onblur="checkUsername()" placeholder="起一个好看的名字" required/>			
						<div class="clear"> </div>
						<span id="span1"></span>
					</li> 
					<li>
						<input type="password"  id="password" name="password" maxlength="32" placeholder="设一个可靠的密码" required/>
						
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="password"  id="repassword" name="repassword" maxlength="32" placeholder="重复一次密码" required/>
						
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" id="phone" name="phone" maxlength="32" placeholder="留下联系方式，要电话" required/>
						
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" id="email" name="email" maxlength="32" placeholder="再留一个，邮箱" required/>
						
						<div class="clear"> </div>
					</li> 
					<label class="checkbox"><input type="checkbox" name="checkbox" checked><i> </i>我未<a href="#"><b>阅读</b></a>且拒绝龟乌条款</label>
					<input type="submit" class="submit" value="这样就好" >
						
				</ul>
				<div class="clear"> </div>					
				<a href="${ pageContext.request.contextPath }/store_registPage.action">我要加盟！</a>
		</div>
	</form>	
	
</body>
</html>
