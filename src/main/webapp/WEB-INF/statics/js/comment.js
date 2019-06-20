$(function(){
    console.log("打开播放页")
    var type="get";
    var url="http://localhost:8080/VBlog_war/play";
    $().myAjaxGet(url,null,function(da){
        console.log(da);
        $("#VideoName h3").text(da.uploadUsr);
        $(".header h2").text(da.videoName);

        var type="get";
        var url="http://localhost:8080/VBlog_war/commentTest";
        var data={videoName:da.videoName}
        console.log(data);
        $().myAjaxGet(url,data,function(da){
            console.log(da);
            for (var i=0;i<da.length;i++){
                $("#list").append("<li>"+da[i].usrName+da[i].createTime+da[i].content+"</li>")
            }
        },type);

    },type);


    $("#submit").click(function(){

        var url="http://localhost:8080/VBlog_war/session";
        var data=null;
        $.ajax({
            url:url,
            data:data?data:{},
            datatype:"json",
            type:"get",
            success:function(da){
                console.log(da);
                if (da.code == "3001") { //判断返回值，这里根据的业务内容可做调整
                    $("#personalA").text("PersonalZone");
                    $("#personalA").attr('href',"statics/yuyy_html_test/personalZone.html");
                } else if (da.code == "3000"){
                    alert("请先登陆");
                    window.location.href =
                        "http://localhost:8080/VBlog_war";//登录后的页面地址
                }
            }
        });
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
