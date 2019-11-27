<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>登录注册</title>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	<link href="${APP_PATH }/static/assets/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="${APP_PATH }/static/assets/css/font-awesome.css">
	<link href="${APP_PATH }/static/assets/css/style.css" rel="stylesheet">
	<script src="${APP_PATH }/static/assets/js/jquery.min.js"></script>
	<script src="${APP_PATH }/static/assets/js/bootstrap.js"></script>
</head>
<body>

<div class="temp-popup-form-wrapper">
	<nav class="navbar navbar-inverse temp-custom-navigation">
		<div class="container-fluid">
			<div class="navbar-header temp-custom-logo-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">学生信息管理系统</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right temp-custom-list-items">
					<li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#RegistrationModal">注册表单</a></li>
					<li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#LogInModal">登录表单</a></li>
				</ul>
			</div>
		</div>
	</nav>

</div>
<!--注册-->
<div class="modal fade" id="RegistrationModal" role="dialog">
	<div class="temp-custom-modal-wrap">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content temp-custom-modal-content">
				<button type="button" class="close temp-custom-close-button" data-dismiss="modal">&times;</button>
				<div class="modal-body temp-custom-modal-body">
					<div class="temp-login-form-wrapper">
						<div class="row custom-row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 temp-form-column-wrap-image">
								<div class="temp-reg-column-wrap-image">
									<div class="temp-form-inner-wrapper">
										<h2>注册</h2>
										<p>如果用户没有帐户，则通过填写给定的表单创建帐户。</p>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="temp-form-column-wrap">
					<form id="empAddModal">
						<div class="row">

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
                                     <span class="temp-span-wrap temp-span-input-label-wrap">
                                        <input class="temp_input_field" type="text" name="stuId" id="stuId_add_input">
                                       <label class="temp_input_label">
                                          <span class="temp_input_label-content">学号</span>
                                       </label>
                                   </span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
                                     <span class="temp-span-wrap temp-span-input-label-wrap">
                                        <input class="temp_input_field" type="text" name="age" id="age_add_input">
                                       <label class="temp_input_label">
                                          <span class="temp_input_label-content">年龄</span>
                                       </label>
                                   </span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
                                     <span class="temp-span-wrap temp-span-input-label-wrap">
                                        <input class="temp_input_field" type="text" name="phone" id="phone_add_input">
                                       <label class="temp_input_label">
                                          <span class="temp_input_label-content">手机</span>
                                       </label>
                                   </span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
                                     <span class="temp-span-wrap temp-span-input-label-wrap">
                                        <input class="temp_input_field" type="text" name="stuName" id="stuName_add_input">
                                       <label class="temp_input_label">
                                          <span class="temp_input_label-content">姓名</span>
                                       </label>
                                   </span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
                                     <span class="temp-span-wrap temp-span-input-label-wrap">
                                        <input class="temp_input_field" type="text" name="stuUser" id="stuUser_add_input">
                                       <label class="temp_input_label">
                                          <span class="temp_input_label-content">用户名</span>
                                       </label>
                                   </span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							   <div class="form-group">
                                 <span class="temp-span-wrap temp-span-input-label-wrap">
                                <input class="temp_input_field" type="password"  name="stuPass">
                                <label class="temp_input_label">
                                <span class="temp_input_label-content">密码</span>
                                 </label>
                                </span>
							   </div>
							</div>

							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label class="col-md-4 control-label">性别</label>
									<div class="col-md-6 col-md-offset-1">
										<label class="radio-inline">
											<input type="radio" name="sex" id="sex1_add_input" value="M" checked="checked"> 男
										</label>
										<label class="radio-inline">
											<input type="radio" name="sex" id="sex2_add_input" value="F"> 女
										</label>
								     </div>
							     </div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label class="col-md-4 control-label">班级</label>
									<div class="col-md-7 col-md-offset-1">
										<select class="form-control" name="classId">
										</select>
									</div>
								</div>
							</div>
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<div class="temp-login-button-wrap">
													<button class="btn btn-info temp-form-button" type="button" id="emp_save_btn">提交注册</button>
												</div>
											</div>

						              </div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--登录-->
<div class="modal fade" id="LogInModal" role="dialog">
	<div class="temp-custom-modal-wrap">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content temp-custom-modal-content">
				<button type="button" class="close temp-custom-close-button" data-dismiss="modal">&times;</button>
				<div class="modal-body temp-custom-modal-body">
					<div class="temp-login-form-wrapper">
						<div class="row custom-row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 temp-form-column-wrap-image">
								<div class="temp-login-column-wrap-image">
									<div class="temp-form-inner-wrapper">
										<h2>登录</h2>
										<p>如果你有帐户，然后登录。否则，首先创建您的帐户。</p>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="temp-form-column-wrap">
									<h2>登录</h2>
									<form action="loginaction" method="post">
					<div class="form-group">
                      <span class="temp-span-wrap temp-span-input-label-wrap">
                        <input class="temp_input_field" type="text" name="username">
                        <label class="temp_input_label">
                          <span class="temp_input_label-content">用户名</span>
                        </label>
                      </span>
					</div>
					<div class="form-group">
                      <span class="temp-span-wrap temp-span-input-label-wrap">
                        <input class="temp_input_field" type="password"  name="password">
                        <label class="temp_input_label">
                          <span class="temp_input_label-content">密码</span>
                        </label>
                      </span>
					</div>
							<div class="temp-login-button-wrap">
								<button class="btn btn-info temp-form-button" type="submit">提交登录</button>
							</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$("#RegistrationModal").click(function () {
		getDepts("#empAddModal select");
	});
	function getDepts(ele){
		//清空之前下拉列表的值
		$(ele).empty();
		$.ajax({
			url:"${APP_PATH}/clas",
			type:"GET",
			success:function(result){

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

		//2、发送ajax请求保存
		$.ajax({
			url:"${APP_PATH}/stu",
			type:"POST",
			data:$("#empAddModal").serialize(),
			success:function(result){
				//alert(result.msg);
				if(result.code == 100){
					//员工保存成功；
					//1、关闭模态框
					// $("#empAddModal").modal('hide');

					//2、来到最后一页，显示刚才保存的数据
					//发送ajax请求显示最后一页数据即可
					window.location.href='scuessController';
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
</script>


</body>
</html>