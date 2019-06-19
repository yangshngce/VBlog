$(function () {
   $("#bt03").click(function () {
       var data={};
       var type="get";
       var url="http://localhost:8080/VBlog_war/sessionDelete";
       console.log("发起注销请求");
       $("#bt02").myAjaxGet(url,data,function(da){
           console.log(da);
           window.location.href =
               "http://localhost:8080/VBlog_war";//登录后的页面地址
       },type);
   }) ;
});

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