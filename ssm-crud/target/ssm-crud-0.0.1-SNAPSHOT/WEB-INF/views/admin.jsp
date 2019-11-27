<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心</title>
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
            /*border: #2aabd2 solid 1px;*/
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
                <h4 class="modal-title">修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">sysUser</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="sysUser_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">sysPass</label>
                        <div class="col-sm-10">
                            <input type="text" name="sysPass" class="form-control" id="sysPass_update_input" placeholder="sysPass">
                            <span class="help-block"></span>
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
<!-- 搭建显示页面 -->
<div class="container stu">
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
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
    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    $(function(){
        //去首页
        to_page();
    });

    function to_page(){
        $.ajax({
            url:"${APP_PATH}/admins",
            type:"GET",
            success:function(result){
                build_emps_table(result);
            }
        });
    }
    function build_emps_table(result){
        //清空table表格
        $("#emps_table tbody").empty();
        var emps = result.extend.admin;
        $.each(emps,function(index,item){
            var  sysUserTd= $("<td></td>").append(item.sysUser);
            var  sysPassTd= $("<td></td>").append(item.sysPass);
            var  wordNameTd= $("<td></td>").append(item.word.wordName);
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            //为编辑按钮添加一个自定义的属性，来表示当前员工id
            editBtn.attr("edit-id",item.sysId);
            var btnTd = $("<td></td>").append(editBtn);
            //var delBtn =
            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>")
                .append(sysUserTd)
                .append(sysPassTd)
                .append(btnTd)
                .appendTo("#emps_table tbody");
        });
    }
     //更新
    $(document).on("click",".edit_btn",function(){

        getEmp($(this).attr("edit-id"));
        //3、把员工的id传递给模态框的更新按钮
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#empUpdateModal").modal({
            backdrop:"static"
        });
    });

    function getEmp(sysId){
        $.ajax({
            url:"${APP_PATH}/admin/"+sysId,
            type:"GET",
            success:function(result){
                //console.log(result);
                var empData = result.extend.sys;
                $("#sysUser_update_static").text(empData.sysUser);
                $("#sysPass_update_input").val(empData.sysPass);
            }
        });
    }

    //点击更新，更新员工信息
    $("#emp_update_btn").click(function(){
        //发送ajax请求保存更新的员工数据
        $.ajax({
            url:"${APP_PATH}/admin/"+$(this).attr("edit-id"),
            type:"PUT",
            data:$("#empUpdateModal form").serialize(),
            success:function(result){
                to_page();
                //alert(result.msg);
                //1、关闭对话框
                $("#empUpdateModal").modal("hide");
            }
        });
    });
</script>
</body>
</html>
