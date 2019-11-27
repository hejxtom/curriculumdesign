<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>习题管理</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
        pageContext.setAttribute("stuId", session.getAttribute("stuId"));
        pageContext.setAttribute("classId", session.getAttribute("classId"));
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
<script type="text/javascript">
    function uploadFile(obj) {
        $('#filename').attr("value", obj.files[0].name);
        // $('#filepath').attr("value", obj.files[0].name);
        $('#filesuffix').attr("value", obj.files[0].type.split('/')[1]);
        $('#filetime').attr("value", new Date(obj.files[0].lastModified));
         if($('#filename').attr("value") !=null){
             $('#edit_update_input').attr("value","T");
         }

    }
</script>

<body>

<!-- 员工修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">提交</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addform" enctype="multipart/form-data" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">stusId</label>
                        <div class="col-sm-10">
                            <input type="text" name="stusId" class="form-control" id="stusId_update_input" placeholder="stusId">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">wordId</label>
                        <div class="col-sm-10">
                            <input type="text" name="wordId" class="form-control" id="wordId_update_input" placeholder="wordId">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">wordName</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="wordName_update_input" placeholder="wordName">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Test</label>
                        <div class="col-sm-2">
                            <input type="file" id="file"  onchange="uploadFile(this)" />
                        </div>
                        <br><br>
                        <label class="col-sm-2 control-label">文件名:</label>
                        <div class="col-sm-2">
                             <input type="text" id="filename" name="test"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">wordName</label>
                        <div class="col-sm-10">
                            <input type="text" name="edit" class="form-control" id="edit_update_input" placeholder="edit">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">保存</button>
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
        <div class="col-md-3 col-md-offset-9 text">
            <a href="studenteditController"><span class="glyphicon glyphicon-edit db-btn-sml"></span></a>
            <a href="stueditController"><span class="glyphicon glyphicon-book db-btn-sml"></span></a>
            <a href="stuController"><span class="glyphicon glyphicon-user db-btn-sml"></span></a>
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
                    <th>作业号</th>
                    <th>作业名</th>
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
        editTd();

    });

    function to_page(){
        $.ajax({
            url:"${APP_PATH}/byclassId/"+${classId},
            type:"GET",
            success:function(result){
                //清空table表格
                $("#emps_table tbody").empty();
                var emps = result.extend.byclassId;
                $.each(emps,function(index,item){
                    var wordIdTd = $("<td></td>").append(item.wordId);
                    var wordNameTd = $("<td></td>").append(item.wordName);
                    var editTd = $("<td></td>").addClass("editTdVal")

                    var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                        .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("答题");
                    //为编辑按钮添加一个自定义的属性，来表示当前员工id
                    editBtn.attr("edit-id",item.wordId);

                    var btnTd = $("<td></td>").append(editBtn)
                    //append方法执行完成以后还是返回原来的元素
                    $("<tr></tr>")
                        .append(wordIdTd)
                        .append(wordNameTd)
                        .append(btnTd)
                        .appendTo("#emps_table tbody");
                });
            }
        });
    }




    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
    //jquery新版没有live，使用on进行替代
    $(document).on("click",".edit_btn",function(){
        //alert("edit");
       $("#edit_update_static").text("");
       $("filename").attr("vaule","");
        getEmp($(this).attr("edit-id"));
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
        //3、把员工的id传递给模态框的更新按钮
        $("#empUpdateModal").modal({
            backdrop:"static"
        });
    });

    function getEmp(id){
        $.ajax({
            url:"${APP_PATH}/wor/"+id,
            type:"GET",
            success:function(result){
                //console.log(result);
                var empData = result.extend.wor;
                $('#wordId_update_input').attr("value",empData.wordId);
                $('#wordName_update_input').attr("value",empData.wordName);
                $('#stusId_update_input').attr("value",${stuId});

            }
        });
    }


    //点击保存
    $("#emp_update_btn").click(function(){
        //2、发送ajax请求保存
        $.ajax({
            url:"${APP_PATH}/insert",
            type:"POST",
            data:$("#empUpdateModal form").serialize(),
            success:function(result){
                if(result.code == 100) {
                    $("#empUpdateModal").modal('hide');
                }
            }
        });
    });

</script>
</body>
</html>
