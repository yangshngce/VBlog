//加后缀提示信息
function addMsg(td,contend,color){
    var $span = td.find("span");
    if($span.length <= 0){
        $span = $("<span style='padding-right:1px'></span>");
        td.append($span);
    }
    $span.html(contend);
    $span.css("color",color);
}

//验证表单格式
function validateFormInput(input,r){
    var v = input.val();
    var b = r.test(v);
    if(b){
        addMsg(input.parent(),"√","green");
    }else{
        addMsg(input.parent(),"×","red");
    }
    return b;
}

$(function(){

    //验证输入事件处理
    $("#UserName")[0].oninput = function(){
        validateFormInput($("#UserName"),/^\w{2,30}$/);
    }
    $("#PassWord")[0].oninput = function(){
        validateFormInput($("#PassWord"),/^\w{2,30}$/);
    }

    $("#denglu").click(function(){
        console.log("00")
        var username = $("#UserName").prop("value");
        var password = $("#PassWord").prop("value");

        var data={username:username, password:password};
        var url="http://localhost:8080/VBlog_war/usr";

        var b1 = validateFormInput($("#UserName"),/^\w{2,30}$/);
        var b2 = validateFormInput($("#PassWord"),/^\w{2,30}$/);

        if(b1 && b2){
            $("#denglu").myAjaxGet(url,data,function(da){
                console.log(da);
                if (da.code == "1001") { //判断返回值，这里根据的业务内容可做调整
                    alert(da.message);
                    console.log(da);

                    window.location.href =
                        "http://localhost:8080/VBlog_war";//登录后的页面地址

                } else if (da.code == "1002"){
                    alert(da.message);
                    return false;
                }else if (da.code == "1003"){
                    alert(da.message);
                    return false;
                }else if (da.code == "1004"){
                    alert(da.message);
                    return false;
                }

            });
        }
    });

})



//ajaxGet提交

$.fn.myAjaxGet=function (u,d,fn) {

    $.ajax({

        url:u,

        data:d?d:{},

        datatype:"json",

        type:"get",

        success:fn?fn:d

    });

};
