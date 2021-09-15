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
				var repassword=document.getElementById("repassword").value;
				if(!(password==repassword)){
					alert("password  is  not same");
					return false;
				}
			}
			//ajax异步校验
			function checkAccount(){
			console.log("aaa");
				//获取值
				var account=document.getElementById("account").value;
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
				xhr.open("GET","${pageContext.request.contextPath}/user_findByAccount.action?time="+new Date().getTime()+"&account="+account,true);
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
	<form id="storeRegisterForm" action="${pageContext.request.contextPath}/store_regist.action"  method="post" novalidate="novalidate" onsubmit="return checkForm();">
		<div class="main">
			<div class="header" >
				<h1>欢迎加入</h1>
			</div>
			<p></p>
			
				<ul class="left-form">
					<h2>创建一个新的商店账号~</h2>
					<li>
						<input type="text" id="account" name="account" placeholder="账号" onblur="checkAccount()" required/>
						
						<div class="clear"> </div>
						<span id="span1"></span>
					</li>
					<li>
						<input type="password" id="password" name="password" placeholder="enter password" required/>
						
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" id="name" name="name" placeholder="一个好听的店铺应当有一个好看的名字~" required/>
						
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" id="email" name="email" placeholder="留个邮箱吧" required/>
						
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text" id="phone" name="phone" placeholder="再留个电话" required/>
						
						<div class="clear"> </div>
					</li>  
					
					<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>同意条款</label>
					<input type="submit" onClick="myFunction()" value="决定">
						<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>					
				已有账号？<a href="${ pageContext.request.contextPath }/store_loginPage.action">去登录</a>
		</div>
	</form>	
</body>
</html>
