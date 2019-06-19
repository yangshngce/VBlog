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

    var b1;
    var b2;
    var b3;
    var b4;
    var b5;
    //验证输入事件处理
    $("#UserName")[0].oninput = function(){
        b1=validateFormInput($("#UserName"),/^[a-zA-Z][a-zA-Z0-9]{2,12}$/);
    }
    $("#PassWord")[0].oninput = function(){
        b2=validateFormInput($("#PassWord"),/^[a-zA-Z0-9]{4,10}$/);
    }
    $("#Sex")[0].oninput = function(){
        b3=validateFormInput($("#Sex"),/^\w{1,8}$/);
    }
    $("#Age")[0].oninput = function(){
        b4=validateFormInput($("#Age"),/^[0-9]{1,8}$/);
    }
    $("#Email")[0].oninput = function(){
        b5=validateFormInput($("#Email"),/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/);
    }

    $("#zhuce").click(function(){
        console.log("00")
        var username = $("#UserName").prop("value");
        var password = $("#PassWord").prop("value");
        var sex = $("#Sex").prop("value");
        var age = $("#Age").prop("value");
        var email = $("#Email").prop("value");

        var data={user_name: username, password: password, sex: sex,age: age,email: email};
        //console.log(data);
        var url="http://localhost:8080/VBlog_war/usr";



        if(b1 && b2 && b3 && b4 && b5){
            $("#zhuce").myAjaxGet(url,data,function(da){
                console.log(da);
                if (da.code == "2001") { //判断返回值，这里根据的业务内容可做调整
                    alert(da.message);
                    console.log(data);
                    window.location.href =  url;//登录后的页面地址
                } else if (da.code == "2002"){
                    alert(da.message);
                    return false;
                }else if (da.code == "2003"){
                    alert(da.message);
                    return false;
                }else if (da.code == "2000"){
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

        type:"post",

        success:fn?fn:d

    });

};










$(function(){

    //验证输入事件处理
    $("#UserName")[0].oninput = function(){
        validateFormInput($("#UserName"),/^[a-zA-Z]\w{5,11}$/);
    }
    $("#PassWord")[0].oninput = function(){
        validateFormInput($("#PassWord"),/^[a-zA-Z]\w{5,11}$/);
    }

    $("#zhuce").click(function(){
        var username = $("#UserName").prop("value");
        var password = $("#PassWord").prop("value");
        var data={username:username, password:password};
        var url="http://localhost:8080/usr";

        var b1 = validateFormInput($("#UserName"),/^[a-zA-Z]\w{5,11}$/);
        var b2 = validateFormInput($("#PassWord"),/^[a-zA-Z]\w{5,11}$/);

        if(b1 && b2){
            $("#bt").myAjaxGet(url,data,function(da){
                if (data.code == "2001") { //判断返回值，这里根据的业务内容可做调整
                    setTimeout(function () {//做延时以便显示登录状态值
                        showMsg("正在注册中...");
                        console.log(data);
                        window.location.href =  url;//注册后的页面地址
                    },100)
                } else if (data.code == "2002"){
                    showMsg(data.message);//显示登录失败的原因
                    return false;
                }
            });
        }
    });

})