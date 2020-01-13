<#include "/include/header.ftl">
<html>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/god/queryHbase.js"></script>
<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />


<body class="easyui-layout">
	<!--  页面上方区域     -->
		<div region="north" split="true" style="height:60px;width:100%;font-size: 26px;padding: 8px;background-color: #D1EEEE">
			<div><span>
					<a style="margin-left: 30px;">私人博客</a>
					<button style="margin-left: 1200px;" id="exit">退出</button>
				</span>
			</div>
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
    	$("#exit").click(function(e){
    		e.stopPropagation();
    		window.location.href='/blogdemo/login';
    	})
			
    </script>
</body>
</html>