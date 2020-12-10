var xmlHttp;
//创建XMLHttpRequest对象
function createXmlHttp() {
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}


var usepassword_correct = false;
var password_correct = false;
var password1_correct = false;


$(document).ready(function() { 
	
	
	 
    $("#usepassword").blur(function() {
	   if($(this).val() == "")
		   {
		   $("#usepasswordError").text("原密码输入不能为空");
		   }else{
			   $("#usepasswordError").text("");
	            userName_correct = true;
		        var  data = {usepassword: $("#usepassword").val()}
		        $.ajax({
                type: "post",
	             url: "Checkusepassword.do",
	             data: data, //将表单内容序列化成一个URL 编码字符串
	             dataType: "json",
	             success: function(response) {
	                 if (response.code == 0) {
	                 	 $("#usepasswordError").css("color", "green");
	                      $("#usepasswordError").text("原密码输入正确");
	                 }else{
	                 	 $("#usepasswordError").css("color", "#c00202");
	                      $("#usepasswordError").text("原密码输入不正确");
	                 }
	             }
	         });  
           } 	        
	 });
	
    //密码输入框离开事件：
    $("#password").blur(function() {
        var password_min_length = 3
        if ($("#password").val().length >= password_min_length) {
            $("#passwordError").css("color", "green");
            $("#passwordError").text("密码设置成功");
            password_correct = true;
        } else {
            $("#passwordError").css("color", "#c00202");
            $("#passwordError").text("密码长度至少为3");
        }
    });

    //确认密码离开事件
    $("#password1").blur(function() {
        var password_min_length = 3;
        if ($("#password").val() == $("#password1").val() && $("#password").val().length >= password_min_length) {
            $("#password1Error").css("color", "green");
            $("#password1Error").text("密码设置成功");
            password1_correct = true;
        } else {
            $("#password1Error").css("color", "#c00202");
            $("#password1Error").text("密码不一致或长度不够");
        }
    });

    
    $("#btLogin").click(function(e) {    
             var  data = {password: $("#password").val()};
            $.ajax({
                type: "post",
                url: "updatepassword.do",
                data: data, //将表单内容序列化成一个URL 编码字符串
                dataType: "json",
                success: function(response) {
                    if (response.code == 0) {
                        alert("密码更改成功，将自动跳转到登录页面");
                        window.location.href = "login.html";
                    }
                }
            });   
    });    
});