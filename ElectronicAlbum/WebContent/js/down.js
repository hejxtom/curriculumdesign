var xhr = new XMLHttpRequest();
var prog = document.querySelector("#progl");
$("#showBtna").click(function () {
    // 定义请求发送的URL
    var uri = "Upload";
    // 打开与服务器连接
    xhr.open("POST", uri,false);
    xhr.upload.onprogress = function(e){
        // 根据上传进度改变进度条的值
        prog.value = (e.loaded / e.total) * 100;
        // 上传完成，隐藏进度条
        if(e.loaded >= e.total)
            prog.style.display = "none";
    }
    // 指定处理服务器响应的回调函数
    xhr.onload = processResponse;
    var formData = new FormData(document.querySelector("#downform"));
    // 发送表单数据
    xhr.send(formData);
    prog.style.display = "";
});
function processResponse()
{
    if(xhr.status == 200){
    	if(xhr.responseText==null&&xhr.responseText==""){
    		alert("您还没有上传，请先上传...");
    	
    	}else{
    		document.querySelector(".downimg").innerHTML= xhr.responseText;
    		}
    	}
        
    }

