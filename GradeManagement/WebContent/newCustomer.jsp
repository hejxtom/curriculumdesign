<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/sty_css.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>New Customer</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/StundentForm.js"></script>
</head>
<body>
<div class="header">学生信息管理</div>
<div class="ShangJi"><a href="StundentForm.jsp">返回</a></div>
<div id="retrun"><a href="index.html">退出系统</a></div>
<%
  Object msg=request.getAttribute("message");
if(msg !=null){
	out.print("<center style='color: red'><h3>");
	out.print(msg);
	out.print("</h3></center>");
	out.print("<br>");
}
%>
<div id="Query">
<form action="addStudent.do" method="post">
  <table>
   <tr>
     <td>Number:</td>
     <td><input type="text" name="number" 
    value="<%= request.getParameter("number")==null?"":request.getParameter("number")%>"/>
    </td>
   </tr>
   <tr>
     <td>Name:</td>
     <td><input type="text" name="name" 
    value="<%= request.getParameter("name")==null?"":request.getParameter("name")%>"/>
    </td>
   </tr>
   <tr>
     <td>Sex:</td>
     <td><input type="text" name="sex" 
    value="<%= request.getParameter("sex")==null?"":request.getParameter("sex")%>"/>
    </td>
   </tr>
   <tr>
     <td>Age:</td>
     <td><input type="text" name="age" 
    value="<%= request.getParameter("age")==null?"":request.getParameter("age")%>"/>
    </td>
   </tr>
   <tr>
     <td>Grade:</td>
     <td><input type="text" name="grade" 
    value="<%= request.getParameter("grade")==null?"":request.getParameter("grade")%>"/>
    </td>
   </tr>
   <tr>
   <td colspan="2"><input type="submit" value="Submit" id="formBtna"/></td>
   </tr>
  </table> 
</form>
</div>
</body>
</html>