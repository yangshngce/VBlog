$(function(){
    console.log("hello");
    $("#bt").click(function(){
        var data={username:"yuyy_test",
            password:"1234567"
        };
        var type="get";
        var url="http://localhost:8080/VBlog_war/usr";
        console.log(data);
        $("#bt").myAjaxGet(url,data,function(da){
            console.log(da);
        },type);
    });
    $("#bt01").click(function(){
        var data={
            user_name:"yuyy_test",
            password:"1234567",
            sex:"nan",
            age:"12",
            email:"326@qq.com"
        };
        var type="post";
        var url="http://localhost:8080/VBlog_war/usr";
        console.log(data);
        $("#bt").myAjaxGet(url,data,function(da){
            console.log(da);
        },type);
    });
})

//ajaxGet提交
$.fn.myAjaxGet=function (u,d,fn,type) {
    $.ajax({
       url:u,
       data:d?d:{},
       dataType:"json",
       type:type,
       success:fn?fn:d
    });
};