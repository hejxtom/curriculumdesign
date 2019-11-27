
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	
	var LoginFunction=function(){
	    if(document.getElementById("user").value=="" || document.getElementById("pws").value==""){
	        alert("您没有输入密码或者用户名！");
	        return false;
	    }else{
	    }
	}