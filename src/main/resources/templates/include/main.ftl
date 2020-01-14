<#include "/include/header.ftl">
<html>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/blogdemo/js/god/queryHbase.js"></script>
<link rel="stylesheet" type="text/css" href="/blogdemo/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/blogdemo/easyui/themes/icon.css" />
<script type="text/javascript" src="/blogdemo/js/layer/layer.js"></script>


<body class="easyui-layout">
	<!--  页面上方区域     -->
		<div region="north" split="true" style="height:60px;width:100%;font-size: 26px;padding: 8px;background-color: #D1EEEE">
			<div style="width:100%">
				<div style="Float:left">
                    <a style="margin-left: 30px;">博客</a>
				</div>
				<div style="Float:right">
                    <button style="margin-right: 50px;" id="exit">退出</button>
				</div>
                <div style="Float:right">
                    <button style="margin-right: 10px;" id="user">个人中心</button>
                </div>
			</div>
		</div>
    <#--<div style="display:none">-->
    <div style="display:block">
		<a id="userId">${Session.id}</a>
    </div>
	
    
    <!--  页面左边区域    -->
    <div region="west" style="width:180px" title="BLOG" split="true">
    	<!-- 树形结构的功能列表 -->
    	<ul id="tree"></ul>
    </div>
    
    <!--  页面中间内容（主面板）区域     -->
    <div region="center">
    	<div class="easyui-tabs" fit="true" border="false" id="tabs">
    	   <div title="首页">欢迎来到 ${Session.user.username}博客主页</div>
    	</div>
    </div>
    <script type="text/javascript">
        var uid=${Session.id};
    	$("#exit").click(function(e){
    		e.stopPropagation();
    		window.location.href='/blogdemo/login';
    	})


        $("#user").click(function(e) {
            e.stopPropagation();
            layer.open({
                type : 2,
                title : '用户信息',
                fix : false,
                maxmin : true,
                shadeClose : true,
                content : 'user/user/' + uid,
                area : [ '60%', '80%' ],

            });
        });
    </script>
</body>
</html>