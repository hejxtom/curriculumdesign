<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ERRO</title>
<link rel="stylesheet" href="css/es.css">
<script src="js/jquery.min.js"></script>
</head>
<body>
<%
  String IndexErro =(String)request.getAttribute("IndexErro");
  String message =(String)request.getAttribute("message");
  if(IndexErro !=null){
	%> 
	<font><h3>由于您的密码或者用户名不存在，建议您先注册.....</h3></font>
	<p>即将在3秒，跳转至注册页面：<span></span><p>
   <script>
    alert("您的用户名或者密码错误!");
	var i=0;
	setInterval(function(){
    $("span").html(i);
	i++;
	    },1000);
    setTimeout(function(){
		location.href="register.html";
	},4000);
    
   </script>
	<% 
  }
  if(message !=null){
	  %>
	  <p>即将在3秒，跳转至注册页面：<span></span><p>
	  <script>
	    alert("<%=message%>");
	    var i=0;
		setInterval(function(){
	    $("span").html(i);
		i++;
		    },1000);
	    setTimeout(function(){
			location.href="register.html";
		},4000);
	   </script>
	   <%
  }
%>

</body>
</html>