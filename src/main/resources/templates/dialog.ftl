<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>登入超时</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/blogdemo/js/god/queryHbase.js"></script>
    <link rel="stylesheet" type="text/css" href="/blogdemo/easyui/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/blogdemo/easyui/themes/icon.css" />
    <link rel="shortcut icon" href="/blogdemo/img/favicon.ico" type="image/x-icon"/>
    <style type="text/css">
    </style>

</head>

<body>


<div class="easyui-layout" style="height: 90%;width: 90%; border: 1px;">
    <div style="margin-top: 10px;">
        <button id="login">重新登入</button>
    </div>
</div>

<script>
    $("#login").click(function(e){
        e.stopPropagation();
        window.top.location='/blogdemo/login';
    })


</script>

</body>

</html>