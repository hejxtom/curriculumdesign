<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/Erro_css.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<title>404</title>
</head>
<body>
<%
  String LoginErro=(String)request.getAttribute("LoginErro");
  String RegisterErro=(String)request.getAttribute("RegisterErro");
  String message=(String)request.getAttribute("message");
  if(LoginErro !=null){
	  %>
	  <center>由于您的密码或用户名错误，我们建议您先注册</center>
	  <p>即将在3秒，跳转至注册页面：<span></span><p>
	  <script type="text/javascript">
       alert("<%=LoginErro%>");
	   var i=0;
		setInterval(function(){
	    $("span").html(i);
		i++;
		    },1000);
	    setTimeout(function(){
			location.href="register.jsp";
		},4000);
	  </script>
	  <%
  }
%>
<%
if(RegisterErro !=null){
	  %>
	  <center>由于您的用户名被他人占用，我们建议您重新填写</center>
	  <p>即将在3秒，跳转至注册页面：<span></span><p>
	  <script type="text/javascript">
	  alert("<%=RegisterErro%>");
	  var i=0;
		setInterval(function(){
	    $("span").html(i);
		i++;
		    },1000);
	    setTimeout(function(){
			location.href="register.jsp";
		},4000);
	  </script>
	  <%
}
%>
<%
if(message !=null){
	  %>
	 <center>由于您的用户名被他人占用，我们建议您重新填写</center>
	  <p>即将在3秒，跳转至添加页面：<span></span><p>
	  <script type="text/javascript">
	  alert("<%=message%>");
	  var i=0;
		setInterval(function(){
	    $("span").html(i);
		i++;
		    },1000);
	    setTimeout(function(){
			location.href="newCustomer.jsp";
		},4000);
	  </script>
	  <%
}
%>
</body>
</html>