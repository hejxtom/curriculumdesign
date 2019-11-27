<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 

<script src="js/jquery.min.js"></script>
<script src="js/jquery-3.1.1.js"></script>

</head>
<body>	
<div class="message warning">
  <div class="inset">
	  <div class="login-head">
		<h1>Register Form</h1>
		 <div class="alert-close"> </div> 			
	   </div>
		<form action="UserRegisterServlet" method="post">
			<li>
				<input type="text" id="user" name="username"/><a href="#" class=" icon user"></a>
			</li>
				<div class="clear"> </div>
			<li>
				<input type="password" id="pws" name="password"> <a href="#" class="icon lock"></a>
			</li>
			<div class="submit">
				<button class="btn" onclick="return LoginFunction()">Sign in</button>
				<h4><a href="index.html" class="regic">登录？</a></h4>	
			</div>	
		 </form>
	</div>					
</div>
	<div class="clear"> </div>
<!--- footer --->
<div class="footer">
	<p>AtMangXing</p>
</div>
<script>
var LoginFunction=function(){
    if(document.getElementById("user").value=="" || document.getElementById("pws").value==""){
        alert("您没有输入密码或者用户名！");
        return false;
    }

}
</script>
</body>
</html>