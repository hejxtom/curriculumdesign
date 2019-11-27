<%@page import="com.atmangxing.mvcapp.domain.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/sty_css.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Updatecustomer</title>
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
 String number=null;
 String name=null;
 String sex=null;
 String age=null;
 String grade=null;
 String oldName=null;
 
 Student student =(Student)request.getAttribute("student");
  if(student !=null){
	  number=student.getNumber();
	  oldName=student.getName();
	  name=student.getName();
	  sex=student.getSex();
	  age=student.getAge();
	  grade=student.getGrade();
  }else{
	  number=request.getParameter("number");
	  name=request.getParameter("oldName");
	  oldName=request.getParameter("oldName");
	  sex=request.getParameter("sex");
	  age=request.getParameter("age");
	  grade=request.getParameter("grade");
  }
%>
<div id="Query">
<form action="update.do" method="post">
<input type="hidden" name="number" value="<%=number%>"/>
<input type="hidden" name="oldName" value="<%=oldName%>"/>
  <table>
   <!--<tr>
     <td>Number:</td>
     <td><input type="text" name="number" 
    value="<%=number%>"/>
    </td>
   </tr>  -->
   <tr>
     <td>Name:</td>
     <td><input type="text" name="name" 
    value="<%=name%>"/>
    </td>
   </tr>
   <tr>
     <td>Sex:</td>
     <td><input type="text" name="sex" 
    value="<%=sex%>"/>
    </td>
   </tr>
   <tr>
     <td>Age:</td>
     <td><input type="text" name="age" 
    value="<%=age%>"/>
    </td>
   </tr>
   <tr>
     <td>Grade:</td>
     <td><input type="text" name="grade" 
    value="<%=grade%>"/>
    </td>
   </tr>
   <tr>
   <td colspan="2"><input type="submit" value="Submit" id="formBtnae"/></td>
   </tr>
  </table> 
</form>
</div>
</body>
</html>