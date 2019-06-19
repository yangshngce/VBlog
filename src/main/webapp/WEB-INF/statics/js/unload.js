var box=document.getElementById("box");

box.ondragover=function(e)

{

    e.preventDefault();

    this.style.background="#eee"

}

box.ondragleave=function(e)

{

    e.preventDefault();

    this.style.background="#fff"

}

box.ondrop=function(e)

{

    e.preventDefault();

    //拖拽一个文件上传

    var file= e.dataTransfer.files[0];           //在拖拽时，通过event对象的dataTransfer对象下的files属性来获取当前对象

    var newform=new FormData();           //定义一个FormData对象

    newform.append("aa",file);
