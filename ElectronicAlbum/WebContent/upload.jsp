<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/uploadstyle.css">
<script src="js/jquery.min.js"></script>
<script src="js/jquery-3.1.1.js"></script>
</head>
  <%
  String name=(String)request.getAttribute("name");
  HttpSession tsn = request.getSession(true);
  tsn.setAttribute("name", name);
  %>
<body>
<div class="header">
<center>欢迎<%=name%>登陆页面~</center>
<a href="index.html" class="retrun">注销</a>
</div>
<div class="left">
    <div class="load">本次添加记录</div>
  <div id="show"></div>
</div>
<div class="center">
     <section class="centerUp">
        <a class="modalLink" href="#modal1">Updload</a>
    </section>
    <button id="showBtna" class="showBtn">获取所有照片</button>
    <div class="overlay"></div>
    <div id="modal1" class="modal">
    <p class="closeBtn">选择文件</p>
     <form id="bookForm">
     <input type="hidden" name="name" value="<%=name%>">
       上传图片名：<input type="file" name="cover" accept="image/*"/><p>
    <button type="button" class="leftchil">提交</button>
    </form>
<progress id="prog" value="0" min="0" max="100" style="display:none"></progress>
    </div>
    <div class="downimg"></div>
</div>
<script>
alert("登录成功！");
</script>
 <script src="jquery-3.1.1.js"></script>
 <script src="jquery.min.js"></script>
    <script type='text/javascript' src="js/jquery.modal.js"></script>
    <script type='text/javascript' src="js/site.js"></script>
    <script src="js/updolad.js"></script>
    <script src="js/down.js"></script>
</body>
</html>