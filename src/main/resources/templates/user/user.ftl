<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>博客</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/blogdemo/js/god/queryHbase.js"></script>
    <link rel="stylesheet" type="text/css" href="/blogdemo/easyui/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/blogdemo/easyui/themes/icon.css" />
    <script type="text/javascript" src="/blogdemo/js/layer/layer.js"></script>
    <link rel="shortcut icon" href="/blogdemo/img/favicon.ico" type="image/x-icon"/>
<style type="text/css">
</style>
<body>


	<div class="easyui-layout" style="height: 90%; width:90%; border: 1px; margin: 30px 20px;">

		
		<button type="button" id="submit" onclick="submit()">提交</button>
	</div>

	<script>
	function getUrlParameter(name){
		   var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		   var r = window.location.search.substr(1).match(reg);
		   if(r!=null)
		   return unescape(r[2]);
		   return null;
	}

	$().ready(function(){
		alert(${uid});
	})
	
	

	</script>

</body>

</html>