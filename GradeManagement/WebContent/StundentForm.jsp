<%@page import="com.atmangxing.mvcapp.domain.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/sty_css.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>StundentForm</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/StundentForm.js"></script>
</head>
<body>
<div class="header">学生信息管理</div>
<div id="retrun"><a href="index.html">退出系统</a></div>
<div id="Query">
<form action="query.do" method="post">
  <table>
   <tr>
     <td>Number:</td>
     <td><input type="text" name="number"/></td>
   </tr>
   <tr>
     <td>Name:</td>
     <td><input type="text" name="name"/></td>
   </tr>
   <tr>
     <td>Sex:</td>
     <td><input type="text" name="sex"/></td>
   </tr>
   <tr>
     <td>Age:</td>
     <td><input type="text" name="age"/></td>
   </tr>
   <tr>
     <td>Grade:</td>
     <td><input type="text" name="grade"/></td>
   </tr>
    </table> 
   <input type="submit" value="Query" id="formBtn"/>
   <a href="newCustomer.jsp" id="add">AddStudent</a>
</form>
</div>
<form action="edit.do">
<input type="hidden" class="hid" name="number">
<button class="update">Update</button>
</form>
<form action="delete.do">
<input type="hidden" class="hid1" name="number">
<button class="delete">Delete</button>
</form>
<br/><br/>
<hr>
<%
  List<Student> students=(List<Student>)request.getAttribute("students");
   if(students !=null&&students.size()>0){
	  %>
   <div id="show">
   <br>
   <table border="1" cellpadding="10" cellspacing="0">
	 <tr>
	   <th>Number</th>
	  <th>Name</th>
	  <th>Sex</th>
	  <th>Age</th>
	  <th>Grade</th>
	 <!--   <th>UPDATE/DELETA</th>-->
	 <th width="10%">  </th>
	 </tr>
  
   <%
     for( Student student:students){
    	 %>
    	 <tr>
         <td><%=student.getNumber() %></td>
         <td><%=student.getName() %></td>
    	 <td><%=student.getSex() %></td>
    	 <td><%=student.getAge() %></td>
    	 <td><%=student.getGrade() %></td>
    	<!--   <td>
    	 <a href="edit.do?number=<%=student.getNumber()%>">UPDATE</a>
    	 <a href="delete.do?number=<%=student.getNumber()%>" class="delete">DELETE</a>
    	 </td>-->
    	 <td><input type="checkbox" name="items" class="items" value="<%=student.getNumber()%>"/></td>
    	 </tr>
    	 <%
        } 
      %> 
  </table>
	<%
 }
%>
</div>
</body>
</html>