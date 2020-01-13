<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎你，请先登陆！</title>
    <script type="text/javascript" src="../static/jsp/lx.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../static/css/lx.css">

    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            font-family: 微软雅黑;
            font-size: 12px;
        }
        .box{
            width: 390px;
            height: 320px;
            border: solid 1px #ddd;
            background: #FFF;
            position: absolute;
            left: 50%;
            top:42%;
            margin-left: -195px;
            margin-top: -160px;
            text-align: center;
        }
        .box h2{
            font-weight: normal;
            color:#666;
            font-size: 16px;
            line-height: 40px;
            overflow: hidden;
            text-align: center;
            border-bottom: solid 1px #ddd;
            background: #f7f7f7;
        }
        .input_box{
            width:350px;
            padding-bottom: 15px;
            margin: 0 auto;
            overflow: hidden;
        }
    </style>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script  src="../js/layer/layer.js"></script>
    <script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
</head>

<body>
<div class="box">
    <h2>登陆</h2>

    <div class="input_box">
        <input id="username" type="text" name="user" placeholder="请输入用户名">
    </div>
    <div class="input_box">
        <input id="password" type="password" name="psw" placeholder="请输入密码">
    </div>
    <div id="error_box"><br></div>
    <div class="input_box">
        <button type="button" class="btn btn-primary" onclick="submitAll()">登陆</button>
        <#--<a href="regist.html"><input type="button" class="btn btn-info" name="regist" value="注册"></a>-->
        <button type="button" id="regist"  class="btn btn-info" onclick="insertUser()">注册</button>
    </div>



</div>

<script type="text/javascript">

    function submitAll() {
        var queryParams = {};
        queryParams["username"]=$("#username").val();
        queryParams["password"]=$("#password").val();

        var oUname = document.getElementById("username")
        var oUpass = document.getElementById("password")
        var oError = document.getElementById("error_box")
        var isError = true;
        if (oUname.value.length > 20 || oUname.value.length < 3) {
            oError.innerHTML = "用户名请输入3-20位字符";
            isError = false;
            return;
        }else if((oUname.value.charCodeAt(0)>=48) && (oUname.value.charCodeAt(0)<=57)){
            oError.innerHTML = "首字符必须为字母";
            return;
        }else for(var i=0;i<oUname.value.charCodeAt(i);i++){
            if((oUname.value.charCodeAt(i)<48)||(oUname.value.charCodeAt(i)>57) && (oUname.value.charCodeAt(i)<97)||(oUname.value.charCodeAt(i)>122)){
                oError.innerHTML = "必须为字母跟数字组成";
                return;
            }
        }

        if (oUpass.value.length > 20 || oUpass.value.length < 6) {
            oError.innerHTML = "密码请输入6-20位字符"
            isError = false;
            return;
        }

        $.ajax({
            url : './login/getLogin',
            type : "POST",
            dataType : "json",
            data:queryParams,
            cache : false,
            success : function(data) {
                if(data.state){
                    window.location.href='/blogdemo/adminview/main';
                }else{
                    layer.alert(data.msg);
                }

            },
            error : function() {
                layer.alert("系统错误")
            }
        })
    }

    function getIndex() {
        window.location.href='/blogdemo/adminview/index';
    }

    function insertUser() {
        layer.open({
            type: 2,
            title: '用户注册',
            fix: false,
            maxmin: true,
            shadeClose: true,
            content: 'register',
            // btn: ['确定','取消'], //按钮
            area : ['40%' , '90%'],
            // yes:function(index){
            //
            // },
            end: function(){
            }
        });

    }


    function fnLogin() {
        var oUname = document.getElementById("uname")
        var oUpass = document.getElementById("upass")
        var oError = document.getElementById("error_box")
        var isError = true;
        if (oUname.value.length > 20 || oUname.value.length < 6) {
            oError.innerHTML = "用户名请输入6-20位字符";
            isError = false;
            return;
        }else if((oUname.value.charCodeAt(0)>=48) && (oUname.value.charCodeAt(0)<=57)){
            oError.innerHTML = "首字符必须为字母";
            return;
        }else for(var i=0;i<oUname.value.charCodeAt(i);i++){
            if((oUname.value.charCodeAt(i)<48)||(oUname.value.charCodeAt(i)>57) && (oUname.value.charCodeAt(i)<97)||(oUname.value.charCodeAt(i)>122)){
                oError.innerHTML = "必须为字母跟数字组成";
                return;
            }
        }

        if (oUpass.value.length > 20 || oUpass.value.length < 6) {
            oError.innerHTML = "密码请输入6-20位字符"
            isError = false;
            return;
        }
        window.alert("登录成功")
    }
</script>
</body>
</html>