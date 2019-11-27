<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
<script type="text/javascript"
	src="${APP_PATH }/static/assets/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/assets/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/assets/js/bootstrap.min.js"></script>
	<style>
         .nav-text{
			 position: absolute;
			 margin-left: 40px;
			 margin-top: 5px;
		 }
		.nav-stu{
			width: 99%;
			height: 80px;
		}
		 .db-btn-sml{
			 font-size: 20px;
			 margin-right: 50px;
		 }
		 .text{
			 margin-top: 38px;
			 height: 30px;
			 text-align: right;
		 }
		.stu{
			margin-top: 20px;
		}

	</style>
</head>
<body>
<!-- 员工修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">学生修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">stuId</label>
				<div class="col-sm-10">
					<p class="form-control-static" id="stuId_update_static"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">stuName</label>
				<div class="col-sm-10">
					<input type="text" name="stuName" class="form-control" id="stuName_update_input" placeholder="stuName">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">sex</label>
				<div class="col-sm-10">
					<label class="radio-inline">
						<input type="radio" name="sex" id="sex1_update_input" value="M" checked="checked"> 男
					</label>
					<label class="radio-inline">
						<input type="radio" name="sex" id="sex2_update_input" value="F"> 女
					</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">age</label>
				<div class="col-sm-10">
					<input type="text" name="age" class="form-control" id="age_update_input" placeholder="age">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">phone</label>
				<div class="col-sm-10">
					<input type="text" name="phone" class="form-control" id="phone_update_input" placeholder="phone">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">stuUser</label>
				<div class="col-sm-10">
					<input type="text" name="stuUser" class="form-control" id="stuUser_update_input" placeholder="stuUser">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">stuPass</label>
				<div class="col-sm-10">
					<input type="text" name="stuPass" class="form-control" id="stuPass_update_input" placeholder="stuPass">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">classId</label>
				<div class="col-sm-4">
					<!-- 班级提交班级id即可 -->
					<select class="form-control" name="classId">
					</select>
				</div>
			</div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>



<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">学生添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">stuId</label>
		    <div class="col-sm-10">
		      <input type="text" name="stuId" class="form-control" id="stuId_add_input" placeholder="stuId">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">stuName</label>
		    <div class="col-sm-10">
		      <input type="text" name="stuName" class="form-control" id="stuName_add_input" placeholder="stuName">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">sex</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="sex" id="sex1_add_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" id="sex2_add_input" value="F"> 女
				</label>
		    </div>
		  </div>
			<div class="form-group">
				<label class="col-sm-2 control-label">age</label>
				<div class="col-sm-10">
					<input type="text" name="age" class="form-control" id="age_add_input" placeholder="age">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">phone</label>
				<div class="col-sm-10">
					<input type="text" name="phone" class="form-control" id="phone_add_input" placeholder="phone">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">stuUser</label>
				<div class="col-sm-10">
					<input type="text" name="stuUser" class="form-control" id="stuUser_add_input" placeholder="stuUser">
					<span class="help-block"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">stuPass</label>
				<div class="col-sm-10">
					<input type="text" name="stuPass" class="form-control" id="stuPass_add_input" placeholder="stuPass">
					<span class="help-block"></span>
				</div>
			</div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">classId</label>
		    <div class="col-sm-4">
		    	<!-- 班级提交班级id即可 -->
		      <select class="form-control" name="classId">
		      </select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>


<!-- 标题 -->
<div class="nav-stu">
	<div class="row">
		<div class="col-md-2 nav-text">
			<h3>学生信息管理系统</h3>
		</div>
		<div class="col-md-4 col-md-offset-8 text">
			<a href="wordController"><span class="glyphicon glyphicon-book db-btn-sml"></span></a>
			<a href="studentController"><span class="glyphicon glyphicon-education db-btn-sml"></span></a>
			<a href="adminController"><span class="glyphicon glyphicon-user db-btn-sml"></span></a>
			<a href="loginController" ><span class="glyphicon glyphicon-off db-btn-sml"></span></a>
		</div>
	</div>
</div>
<!-- 模糊查询 -->
<div  id="find_empAddModal" tabindex="-1">
				<form>
					<div class="form-group">
						<label class="col-sm-2 control-label">stuId</label>
						<div class="col-sm-10">
							<input type="text" name="stuId" class="form-control" id="stuId_find" placeholder="stuId">
							<span class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
					   <label class="col-sm-2 control-label">stuName</label>
					   <div class="col-sm-10">
						<input type="text" name="stuName" class="form-control" id="stuName_find" placeholder="stuName">
						<span class="help-block"></span>
					   </div>
				    </div>
					<div class="form-group">
						<label class="col-sm-2 control-label">classId</label>
						<div class="col-sm-4">
							<!-- 班级提交班级id即可 -->
							<select class="form-control" name="classId">
							</select>
						</div>
					</div>
				</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="find_emp_save_btn">查询</button>
			</div>
</div>
	<!-- 搭建显示页面 -->
<div class="container stu">
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th>学号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>联系方式</th>
							<th>班级</th>
							<th>用户名</th>
							<th>密码</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>

		<!-- 显示分页信息 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
				
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
	
		var totalRecord,currentPage;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		$(function(){
			//去首页
			to_page(1);
		});
		
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/stus",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					//console.log(result);
					//1、解析并显示学生数据
					build_emps_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);

					getDepts("#find_empAddModal select")
				}
			});
		}
		
		function build_emps_table(result){
			//清空table表格
			$("#emps_table tbody").empty();
			var emps = result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				var stuIdTd = $("<td></td>").append(item.stuId);
				var stuNameTd = $("<td></td>").append(item.stuName);
				var sexTd = $("<td></td>").append(item.sex=='M'?"男":"女");
				var ageTd = $("<td></td>").append(item.age);
				var phoneTd = $("<td></td>").append(item.phone);
				var stuUserTd = $("<td></td>").append(item.stuUser);
				var stuPassTd = $("<td></td>").append(item.stuPass);
				var classNameTd = $("<td></td>").append(item.aClass.className);


				/**
				<button class="">
									<span class="" aria-hidden="true"></span>
									编辑
								</button>
				*/
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性，来表示当前员工id
				editBtn.attr("edit-id",item.id);
				var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的员工id
				delBtn.attr("del-id",item.id);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

				//var delBtn = 
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(checkBoxTd)
					.append(stuIdTd)
					.append(stuNameTd)
					.append(sexTd)
					.append(ageTd)
					.append(phoneTd)
					.append(classNameTd)
					.append(stuUserTd)
					.append(stuPassTd)
					.append(btnTd)
					.appendTo("#emps_table tbody");
			});
		}
		//解析显示分页信息
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
					result.extend.pageInfo.pages+"页,总"+
					result.extend.pageInfo.total+"条记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(result){
			//page_nav_area
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页的事件
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum -1);
				});
			}
			
			
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum +1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			
			
			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
			
			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		
		//清空表单样式及内容
		function reset_form(ele){
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		
		//点击新增按钮弹出模态框。
		$("#emp_add_modal_btn").click(function(){
			//清除表单数据（表单完整重置（表单的数据，表单的样式））
			reset_form("#empAddModal form");
			//s$("")[0].reset();
			//发送ajax请求，查出部门信息，显示在下拉列表中
			getDepts("#empAddModal select");
			//弹出模态框
			$("#empAddModal").modal({
				backdrop:"static"
			});
		});
		
		//查出所有的部门信息并显示在下拉列表中
		function getDepts(ele){
			//清空之前下拉列表的值
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/clas",
				type:"GET",
				success:function(result){
					//{"code":100,"msg":"处理成功！",
						//"extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
					//console.log(result);
					//显示部门信息在下拉列表中
					//$("#empAddModal select").append("")
					$.each(result.extend.clas,function(){
						var optionEle = $("<option></option>").append(this.className).attr("value",this.classId);
						optionEle.appendTo(ele);
					});
				}
			});
			
		}
		
		//校验表单数据
		function validate_add_form(){
			//1、拿到要校验的数据，使用正则表达式
			//校验学号
			var stuId = $("#stuId_add_input").val();
			var regstuId = /(^2017\d{6}$)/;
			if(!regstuId.test(stuId)){
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#stuId_add_input", "error", "学号必须是2017开头的十位数");
				return false;
			}else{
				show_validate_msg("#stuId_add_input", "success", "");
			};
			
			//2、校验姓名
			var stuName = $("#stuName_add_input").val();
			var regstuName = /[^a-zA-Z0-9\_\u4e00-\u9fa5]/;
			if(regstuName.test(stuName)|| stuName==null){
				//alert("邮箱格式不正确");
				//应该清空这个元素之前的样式
				show_validate_msg("#stuName_add_input", "error", "姓名中有非法字符");
				/* $("#email_add_input").parent().addClass("has-error");
				$("#email_add_input").next("span").text("邮箱格式不正确"); */
				return false;
			}else{
				show_validate_msg("#stuName_add_input", "success", "");
			}

			//校验电话号码
			var phone =$("#phone_add_input").val();
			var regphone =/^[1][3,4,5,7,8][0-9]{9}$/;
			if(!regphone.test(phone)){
				show_validate_msg("#phone_add_input", "error", "请输入正确的手机号码");
				return false;
			}else{
				show_validate_msg("#phone_add_input", "success", "");
			}

			//校验用户名
			var stuUser =$("#stuUser_add_input").val();
			var regstuUser =/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regstuUser.test(stuUser)){
				show_validate_msg("#stuUser_add_input", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			}else{
				show_validate_msg("#stuUser_add_input", "success", "");
			}

			return true;
		}
		
		//显示校验结果的提示信息
		function show_validate_msg(ele,status,msg){
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success"==status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error" == status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//校验学号是否可用
		$("#stuId_add_input").change(function(){
			//发送ajax请求校验用户名是否可用
			var stuid = this.value;
			$.ajax({
				url:"${APP_PATH}/checkid",
				data:"stuid="+stuid,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#stuId_add_input","success","学号可用");
						$("#emp_save_btn").attr("ajax-v","success");
					}else{
						show_validate_msg("#stuId_add_input","error",result.extend.va_id);
						$("#emp_save_btn").attr("ajax-v","error");
					}
				}
			});
		});

		//校验用户名是否可用
		$("#stuUser_add_input").change(function(){
			//发送ajax请求校验用户名是否可用
			var empName = this.value;
			$.ajax({
				url:"${APP_PATH}/checkuser",
				data:"empName="+empName,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#stuUser_add_input","success","用户名可用");
						$("#emp_save_btn").attr("ajax-va","success");
					}else{
						show_validate_msg("#stuUser_add_input","error",result.extend.va_msg);
						$("#emp_save_btn").attr("ajax-va","error");
					}
				}
			});
		});
		
		//点击保存，保存员工。
		$("#emp_save_btn").click(function(){
			//1、模态框中填写的表单数据提交给服务器进行保存
			//1、先对要提交给服务器的数据进行校验
			if(!validate_add_form()){
				return false;
			};
			//1、判断之前的ajax用户名校验是否成功。如果成功。
			//
			if($(this).attr("ajax-va")=="error" || $(this).attr("ajax-v")=="error"){
				return false;
			}
			
			//2、发送ajax请求保存员工
			$.ajax({
				url:"${APP_PATH}/stu",
				type:"POST",
				data:$("#empAddModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					if(result.code == 100){
						//员工保存成功；
						//1、关闭模态框
						$("#empAddModal").modal('hide');
						
						//2、来到最后一页，显示刚才保存的数据
						//发送ajax请求显示最后一页数据即可
						to_page(totalRecord);
					}else{
						//显示失败信息
						//console.log(result);
						//有哪个字段的错误信息就显示哪个字段的；
						if(undefined != result.extend.errorFields.stuId){
							//显示邮箱错误信息
							show_validate_msg("#stuId_add_input", "error", result.extend.errorFields.stuId);
						}
						if(undefined != result.extend.errorFields.stuName){
							//显示员工名字的错误信息
							show_validate_msg("#stuName_add_input", "error", result.extend.errorFields.stuName);
						}
						if(undefined != result.extend.errorFields.phone){
							//显示员工名字的错误信息
							show_validate_msg("#phone_add_input", "error", result.extend.errorFields.phone);
						}
						if(undefined != result.extend.errorFields.stuUser){
							//显示员工名字的错误信息
							show_validate_msg("#stuUser_add_input", "error", result.extend.errorFields.stuUser);
						}

					}
				}
			});
		});
		//更新
		//1、我们是按钮创建之前就绑定了click，所以绑定不上。
		//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
		//jquery新版没有live，使用on进行替代
		$(document).on("click",".edit_btn",function(){
			//alert("edit");
			
			
			//1、查出部门信息，并显示部门列表
			getDepts("#empUpdateModal select");
			//2、查出员工信息，显示员工信息
			getEmp($(this).attr("edit-id"));
			
			//3、把员工的id传递给模态框的更新按钮
			$("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
		});
		
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/stu/"+id,
				type:"GET",
				success:function(result){
					//console.log(result);
					var empData = result.extend.stu;
					$("#stuId_update_static").text(empData.stuId);
					$("#stuName_update_input").val(empData.stuName);
					$("#empUpdateModal input[name=sex]").val([empData.sex]);
					$("#age_update_input").val(empData.age);
					$("#phone_update_input").val(empData.phone);
					$("#stuUser_update_input").val(empData.stuUser);
					$("#stuPass_update_input").val(empData.stuPass);
					$("#empUpdateModal select").val([empData.classId]);
				}
			});
		}

		//校验信息
		function validate_update_form(){
			//2、校验姓名
			var stuName = $("#stuName_update_input").val();
			var regstuName = /[^a-zA-Z0-9\_\u4e00-\u9fa5]/;
			if(regstuName.test(stuName)|| stuName==null){
				show_validate_msg("#stuName_update_input", "error", "姓名中有非法字符");
				return false;
			}else{
				show_validate_msg("#stuName_update_input", "success", "");
			}

			//校验电话号码
			var phone =$("#phone_update_input").val();
			var regphone =/^[1][3,4,5,7,8][0-9]{9}$/;
			if(!regphone.test(phone)){
				show_validate_msg("#phone_update_input", "error", "请输入正确的手机号码");
				return false;
			}else{
				show_validate_msg("#phone_update_input", "success", "");
			}

			//校验用户名
			var stuUser =$("#stuUser_update_input").val();
			var regstuUser =/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regstuUser.test(stuUser)){
				show_validate_msg("#stuUser_update_input", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			}else{
				show_validate_msg("#stuUser_update_input", "success", "");
			}
             return true;
		}

		//校验用户名是否可用
		$("#stuUser_update_input").change(function(){
			//发送ajax请求校验用户名是否可用
			var empName = this.value;
			$.ajax({
				url:"${APP_PATH}/checkuser",
				data:"empName="+empName,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#stuUser_update_input","success","用户名可用");
						$("#emp_update_btn").attr("ajax-va","success");
					}else{
						show_validate_msg("#stuUser_update_input","error",result.extend.va_msg);
						$("#emp_update_btn").attr("ajax-va","error");
					}
				}
			});
		});

		//点击更新，更新员工信息
		$("#emp_update_btn").click(function(){

			if(!validate_update_form()){
				return false;
			};
			//1、判断之前的ajax用户名校验是否成功。如果成功。
			//
			if($(this).attr("ajax-va")=="error"){
				return false;
			}

			//2、发送ajax请求保存更新的员工数据
			$.ajax({
				url:"${APP_PATH}/stu/"+$(this).attr("edit-id"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					//1、关闭对话框
					$("#empUpdateModal").modal("hide");
					//2、回到本页面
					to_page(currentPage);
				}
			});
		});
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//1、弹出是否确认删除对话框
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			var empId = $(this).attr("del-id");
			//alert($(this).parents("tr").find("td:eq(1)").text());
			if(confirm("确认删除【"+empName+"】吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/stu/"+empId,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页
						to_page(currentPage);
					}
				});
			}
		});
		
		//完成全选/全不选功能
		$("#check_all").click(function(){
			//attr获取checked是undefined;
			//我们这些dom原生的属性；attr获取自定义属性的值；
			//prop修改和读取dom原生属性的值
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		
		//check_item
		$(document).on("click",".check_item",function(){
			//判断当前选择中的元素是否5个
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		
		//点击全部删除，就批量删除
		$("#emp_delete_all_btn").click(function(){
			//
			var empNames = "";
			var del_idstr = "";
			$.each($(".check_item:checked"),function(){
				//this
				empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				//组装员工id字符串
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//去除empNames多余的,
			empNames = empNames.substring(0, empNames.length-1);
			//去除删除的id多余的-
			del_idstr = del_idstr.substring(0, del_idstr.length-1);
			if(confirm("确认删除【"+empNames+"】吗？")){
				//发送ajax请求删除
				$.ajax({
					url:"${APP_PATH}/stu/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到当前页面
						to_page(currentPage);
					}
				});
			}
		});

		$(document).on("click","#find_emp_save_btn",function(){
			find_to();
		});

		function find_to() {
			$.ajax({
				url:"${APP_PATH}/find",
				type:"POST",
				data:$("#find_empAddModal form").serialize(),
				success:function(result){
					$("#emps_table tbody").empty();
					//回到当前页面
					find_emps_table(result);
				}
			});
		}

		function find_emps_table(result){
			//清空table表格
			$("#emps_table tbody").empty();
			var emps = result.extend.find;
			$.each(emps,function(index,item){
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				var stuIdTd = $("<td></td>").append(item.stuId);
				var stuNameTd = $("<td></td>").append(item.stuName);
				var sexTd = $("<td></td>").append(item.sex=='M'?"男":"女");
				var ageTd = $("<td></td>").append(item.age);
				var phoneTd = $("<td></td>").append(item.phone);
				var stuUserTd = $("<td></td>").append(item.stuUser);
				var stuPassTd = $("<td></td>").append(item.stuPass);
				var classNameTd = $("<td></td>").append(item.aClass.className);


				/**
				 <button class="">
				 <span class="" aria-hidden="true"></span>
				 编辑
				 </button>
				 */
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//为编辑按钮添加一个自定义的属性，来表示当前员工id
				editBtn.attr("edit-id",item.id);
				var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的员工id
				delBtn.attr("del-id",item.id);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

				//var delBtn =
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(checkBoxTd)
						.append(stuIdTd)
						.append(stuNameTd)
						.append(sexTd)
						.append(ageTd)
						.append(phoneTd)
						.append(classNameTd)
						.append(stuUserTd)
						.append(stuPassTd)
						.append(btnTd)
						.appendTo("#emps_table tbody");
			});
		}

	</script>
</body>
</html>