function loginexec(){
    var user = $("#userName")[0].value;
    var pass = $("#password")[0].value;
    if(user=='' || pass ==''){
        $("#note").find("span").html("账号密码不能为空");
        return;
    }

    $.ajax({
        url:'ajax/loginexec?'+$("form").serialize(),
        type:'post',
        success:function (data){
            if(data.code=="6000"){
                window.location.href="index";
            }else{
                $("#note").find("span").html("登录失败");
            }
        }
    });
}
$(document).ready(function() {

})

