$(document).ready(function(){

    $('.modalLink').modal({
        trigger: '.modalLink',          // id or class of link or button to trigger modal
        olay:'div.overlay',             // id or class of overlay
        modals:'div.modal',             // id or class of modal
        animationEffect: 'slideDown',   // overlay effect | slideDown or fadeIn | default=fadeIn
        animationSpeed: 400,            // speed of overlay in milliseconds | default=400
        moveModalSpeed: 'slow',         // speed of modal movement when window is resized | slow or fast | default=false
        background: 'a2d3cd',           // hexidecimal color code - DONT USE #
        opacity: 0.7,                   // opacity of modal |  0 - 1 | default = 0.8
        openOnLoad: false,              // open modal on page load | true or false | default=false
        docClose: true,                 // click document to close | true or false | default=true    
        closeByEscape: true,            // close modal by escape key | true or false | default=true
        moveOnScroll: true,             // move modal when window is scrolled | true or false | default=false
        resizeWindow: true,             // move modal when window is resized | true or false | default=false
        video: 'http://player.vimeo.com/video/2355334?color=eb5a3d',    // enter the url of the video
        videoClass:'video',             // class of video element(s)
        close:'.closeBtn'               // id or class of close button
    });
    var xhr = new XMLHttpRequest();
    var prog = document.querySelector("#prog");
    $(".leftchild").hover(function(){
        $(this).css("background-color","#c8c8c8");
   },function () {
   $(this).css("background-color","#00c6ff");
   });
   
    $(".leftchil").click(function () {
    // 定义请求发送的URL
    var uri = "Down";
    // 打开与服务器连接
    xhr.open("POST", uri, true);
    xhr.upload.onprogress = function(e){
        // 根据上传进度改变进度条的值
        prog.value = (e.loaded / e.total) * 100;
        // 上传完成，隐藏进度条
        if(e.loaded >= e.total)
            prog.style.display = "none";
    }
    // 指定处理服务器响应的回调函数
    xhr.onload = processResponse;
    var formData = new FormData(document.querySelector("#bookForm"));
    formData.append("append", "附加参数");
    // 发送表单数据
    xhr.send(formData);
    prog.style.display = "";
});
    // 定义处理服务器响应的回调函数
    function processResponse()
    {
    	if(xhr.status == 200)
    	{
    		if($("#show #showA").length==0){
    			document.querySelector("#show").innerHTML
    			= xhr.responseText;
    		}else{
    			var i=document.querySelector("#show").innerHTML
    			document.querySelector("#show").innerHTML=xhr.responseText+i;
    		}
    		
    	}
    }
    
    $(".leftchil").hover(function(){
        $(this).css("background","#c8c8c8");
   },function () {
   $(this).css("background","#00c6ff");
   });
    
});