$(function () {
    var URL;
    var IMGURL;
    $("#upload").ajaxForm(function(data){
        URL=data.videoPath;
        IMGURL=data.imgPath;
        alert(data.imgPath);
        });
    $("#sure").click(function () {
        var VIDEO_NAME = $("#video_name").prop("value");
        var TYPE = $("#type").prop("value");
        var UPLOAD_USR = 10001;
        var RANK=0;
        var LABLE="0";
        var date={VIDEO_NAME: VIDEO_NAME, TYPE: TYPE,UPLOAD_USR: UPLOAD_USR,RANK:RANK,LABLE:LABLE,URL:URL,IMGURL:IMGURL};

        var url="http://localhost:8080/VBlog_war/addmsg";

        $().myAjaxGet(url,data,function (dd) {
            alert(dd);
            if (dd=1){
                alert("提交成功!");
            }
            else
                alert("失败！")
        })

    })
})

$.fn.myAjaxGet=function (u,d,fn) {

    $.ajax({

        url:u,

        data:d?d:{},

        datatype:"json",

        type:"post",

        success:fn?fn:d

    });

};