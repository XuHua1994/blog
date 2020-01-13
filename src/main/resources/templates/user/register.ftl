<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎你，请先登陆！</title>
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
    <script type="text/javascript" src="../static/jsp/lx.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="../js/layer/layer.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
    <script type="text/javascript" src="../js/olloading/jquery.bgiframe.min.js"></script>
    <script type="text/javascript" src="../js/olloading/loading-min.js"></script>
    <script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/pagetoitportal.js"></script>
</head>
<body>
<div id="container" style="width: 400px" align="center">
    <div id="header" style="background-color: aquamarine">
        <h2 align="center">注册</h2>
    </div>
    <div id="content">
        <p align="center">账号:
            <input id="username" type="text" name="user" placeholder="账号首字符为字母" autocomplete="off">
        </p>
        <p align="center">密码:
            <input id="password" type="password" name="psw" placeholder="请输入密码" autocomplete="off">
        </p>
        <div id="error_box"><br></div>
        <br>

        <button onclick="submit()" class="btn btn-info">注册</button>
    </div>
    <div style="background-color: aquamarine">
        <i>版权信息@</i>
    </div>
</div>

<script>

    function submit() {
        var queryParams = {};
        queryParams["username"]=$("#username").val();
        queryParams["password"]=$("#password").val();
        $.ajax({
            url : './login/getRegister',
            type : "POST",
            dataType : "json",
            data:queryParams,
            cache : false,
            success : function(data) {
                if(data.state){
                    layer.alert(data.msg,function () {
                        window.parent.getIndex();
                    });
                }else{
                    layer.alert(data.msg);
                }

            },
            error : function() {
                layer.alert("系统错误")
            }
        })
    }

</script>

</body>
</html>