//加后缀提示信息
function addMsg(td,contend,color){
    var $span = td.find("span");
    if($span.length <= 0){
        $span = $("<span style='padding-left:1px'></span>");
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
        validateFormInput($("#UserName"),/^[a-zA-Z]\w{5,11}$/);
    }
    $("#PassWord")[0].oninput = function(){
        validateFormInput($("#PassWord"),/^[a-zA-Z]\w{5,11}$/);
    }

    $("#bt").click(function(){
        var username = $("#UserName").prop("value");
        var password = $("#PassWord").prop("value");
        var data={username:username, password:password};
        var url="http://localhost:8080/login";

        var b1 = validateFormInput($("#UserName"),/^[a-zA-Z]\w{5,11}$/);
        var b2 = validateFormInput($("#PassWord"),/^[a-zA-Z]\w{5,11}$/);

        if(b1 && b2){
            $("#bt").myAjaxGet(url,data,function(da){
                if (data.code == "1001") { //判断返回值，这里根据的业务内容可做调整
                    setTimeout(function () {//做延时以便显示登录状态值
                        showMsg("正在登录中...");
                        console.log(data);
                        window.location.href =  url;//登录后的页面地址
                    },100)
                } else if (data.code == "1002"){
                    showMsg(data.message);//显示登录失败的原因
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
