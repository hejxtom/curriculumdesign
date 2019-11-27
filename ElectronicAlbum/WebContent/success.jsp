<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
<link rel="stylesheet" href="css/es.css">
<script src="js/jquery.min.js"></script>
</head>
<body>
<h1>注册成功!</h1>
<p>即将在3秒，跳转至登录页面：<span></span><p>
    <script>
	    alert("注册成功");
	    var i=0;
		setInterval(function(){
	    $("span").html(i);
		i++;
		    },1000);
	    setTimeout(function(){
			location.href="index.html";
		},4000);
	   </script>
</body>
</html>