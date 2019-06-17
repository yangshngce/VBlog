//验证id重复
function validateUserName(fn){
    $.ajax({
        //"url":"/training/findCarPortById.json",
        "type":"get",
        "dataType":"json",
        "data":{"id":$("#UserName").val()},
        "success":function(data){
            fn(data);
        }
    });
}