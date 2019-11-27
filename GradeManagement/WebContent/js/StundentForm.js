$(function(){
    $(".delete").click(function(){
        var  content=$(":checkbox:checked").val();
        var flag=confirm("确定要删除"+content+"信息");
        window.location.reload(true);
        return flag;
        
    });
    
    $("#formBtn").hover(function(){
        $(this).css({"color":"#523854"});
    },function () {
        $(this).css({"color":"#FFF"});
    });
    
    var $items=$(":checkbox[class=items]");
    $(".update").click(function () {
//        alert("0");
        $items.each(function(){
            if($(this).is(":checked")){
//                alert(this.value);
                $(".hid").val(this.value);
            }
        });
        if($(".hid").val()==0){
        	alert("未选择任何信息，请选择！");
        	return false;
        	
        }
    })
      .hover(function () {
        $(this).css({"color":"#523854"});
      },function () {
       $(this).css({"color":"#FFFFFF"});
        });
    $(".delete").click(function () {
//        alert("0");
        $items.each(function(){
            if($(this).is(":checked")){
//                alert(this.value);
                $(".hid1").val(this.value);
            }
        });
        if($(".hid1").val()==0){
        	alert("未选择任何信息，请选择！");
        	return false;
        }
    })
    .hover(function () {
        $(this).css({"color":"#523854"});
      },function () {
       $(this).css({"color":"#FFFFFF"});
        });
    
});