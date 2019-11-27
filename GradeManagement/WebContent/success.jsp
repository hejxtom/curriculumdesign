<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/sty_css.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Success</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
</head>
<body>
 <%
  String Register=(String)request.getAttribute("Register");
 if(Register !=null){
	 %>
	 <center>正在跳转至登陆页面:<span></span>....</center>
	 <script type="text/javascript">
	 alert("<%=Register%>");
	 var i=0;
		setInterval(function(){
	    $("span").html(i);
		i++;
		    },1000);
	    setTimeout(function(){
			location.href="index.html";
		},4000);
	 </script>
	 <%
 }else{
	 %>
	 <div id="suhead">添加成功！</div>
	 <div id="add"><a href="newCustomer.jsp">《《 继续添加</a></div>
	 <div id="resform"><a href="StundentForm.jsp">不了,返回查看 》》</a></div>
	 <script type="text/javascript">
	 alert("操作成功");
	 </script>
	 <%
 }
 %>
 
</body>
</html>