$(function(){
    $().myAjaxGet(url,data,function(da){
        console.log("01");
        for (var i=0;i<da.length;i++){
            $("#list").append("<li>"+da[i].usrName+da[i].createTime+da[i].content+"</li>")
        }
    },type);
    $("#submit").click(function(){
        var yourcomment = $("#your-comment").prop("value");

        var data={ videoId: yourcomment };
        console.log(data);
        alert("000");
        var type="get";
        var url="http://localhost:8080/VBlog_war/commentTest";
        console.log(data);
        $("#submit").myAjaxGet(url,data,function(da){
            console.log(da);
            for (var i=0;i<da.length;i++){
                $("#list").append("<li>"+da[i].usrName+da[i].createTime+da[i].content+"</li>")
            }
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