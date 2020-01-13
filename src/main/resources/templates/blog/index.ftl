
<head>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/god/queryHbase.js"></script>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
	<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <script type="text/javascript" src="../js/layer/layer.js"></script>
<style type="text/css">
</style>
</head>

<body>

	<div class="easyui-layout" style="height: 90%; border: 1px;">
		<div
			style="height: 35px; font-size: 18px; color: #000; margin-top: 8px; margin-bottom: 8px; margin-left: 10px; font-weight: 400;">
			<form id="searchForm" onsubmit="return false;">
				<a>博客名称:</a> 
				<input id="blogname" placeholder="请输入博客名称" type="text"
					style="height: 35px; width: 218px; border: 1px rgb(219, 219, 219) solid; font-size: 13px;"
					autocomplete="off">
				<a style="margin-left: 10px;">博客主题:</a> <a class="inputTd">
				<select class="input" id="blogtheme" style="width: 120px; height: 32px;"></select></a>
				<a href="###" id="submitButton" style="line-height: 32px; padding: 8px 34px; background-color: rgb(86, 119, 252); color: #fff; font-size: 14px; display: inline;">搜索</a>
				<a href="###" id="cleanButton" style="line-height: 32px; padding: 8px 34px; background-color: rgb(86, 119, 252); color: #fff; font-size: 14px; display: inline;">清空</a>
			</form>
			
		</div>

		<div>
			<table id="table_list" class="easyui-datagrid"
				style="position: absolute; top: 144px; left: 0; background-color: #fff; width: 100%; height: 580px; border: 1px rgb(238, 238, 238) solid; border-top: 0px; padding: 0px 20px;">
			</table>
		</div>

	</div>
	<script>
		var $tableList = $("#table_list");
		var $blogtheme = $("#blogtheme");
		$().ready(function() {
			init_datagrid();
			getCode("blogtheme", function(data) {
				var html = "";
				setOptions($blogtheme, data, html);
			});

		})
		
		$("#submitButton").click(function(){
			init_datagrid();
		});
		
		function init_datagrid() {
			var queryParams = {};
			queryParams["blogname"]=$("#blogname").val();
			queryParams["blogtheme"]=$("#blogtheme").val();
			//默认第一页，
			var pageNumber = 1;
			//每页显示10行
			var pageSize = 15;
			$("#table_list")
					.datagrid(
							{
								title : "博客中心",
								url : '../admin/blog/getBlogs?sign=0',
								method : 'get',
								singleSelect : true,
								remoteSort : true, //定义从服务器对数据进行排序。
								pagination : true, //在DataGrid控件底部显示分页工具栏。
								pageNumber : pageNumber,
								pageSize : pageSize,
								pageList : [ 15, 30, 45, 60 ],
								fitColumns : true,
								columns : [ [
										{
											field : 'blogname',
											title : '博客名称',
											width : $(this).width() * 0.5,
											align : 'center'
										},
										{
											field : 'username',
											title : '作者',
											width : $(this).width() * 0.5,
											align : 'center'
										},
										{
											field : 'blogthemevo',
											title : '博客类型',
											width : $(this).width() * 0.5,
											align : 'center'
										},
										{
											field : 'updatetime',
											title : '更新时间',
											width : $(this).width() * 0.5,
											align : 'center'
										},
										{
											field : 'id',
											title : '操作',
											width : $(this).width() * 0.5,
											align : 'center',
											formatter : function(value, row,
													index) {
												var html = "";
												html += '<a href="#"  attrid="' + value + '" class="btn detailbtn">博客详情 </a>';
												html += '<a href="#"  attrid="' + value + '" class="btn remarkbtn" style="margin-left: 10px">评论详情   </a>';
												return html;
											}
										} ] ],
								queryParams:queryParams,
								rownumbers : true,
								loadMsg : '正在加载数据',
								checkbox : true,
								emptyMsg : '列表为空',
								selectOnCheck : false,
								checkOnSelect : false,
								fitColumns : true,
								singleSelect : true,
								onLoadSuccess : function(data) {
									$(".detailbtn").click(function(e) {
										e.stopPropagation();
										var id = $(this).attr("attrid");
										layer.open({
											type : 2,
											title : '博客详情',
											fix : false,
											maxmin : true,
											shadeClose : true,
											content : 'detail?id=' + id,
											area : [ '60%', '80%' ],
										
										});
									});
									
									$(".remarkbtn").click(function(e) {
										e.stopPropagation();
										var blogid = $(this).attr("attrid");
										layer.open({
											type : 2,
											title : '评论详情',
											fix : false,
											maxmin : true,
											shadeClose : true,
											content : 'remark?blogid=' + blogid,
											area : [ '60%', '80%' ],
										
										});
									});
								},
                                onLoadError: function(){
                                    // ...
                                    var d="1";

                                },
							});
		}
		
		var getCode = function(type,callback){
			$.ajax({
				url: '../admin/dictionary/getDictionaryByType?',
				type: "POST",
				async: false,//同步请求   
				dataType: "json",
				data: {type:type},
				success: function(data) {
					callback(data.result);
				}
			})
		};
		var setOptions = function($obj,jsonData,html){
			if(typeof(jsonData)!="undefined" && jsonData!=null){
				var html = '<option value="">请选择</option>';
				for(var key in jsonData){
					html += '<option value="'+jsonData[key].dickey+'">'+jsonData[key].dicvalue+'</option>'
				}
				$obj.html(html);
			}
		};

		function layerClose() {
			layer.closeAll();
		}
		
		//清楚条件
		$("#cleanButton").click(function(){
			var inp = $("#searchForm input");
			var sele = $("#searchForm select");
			for(var i = 0; i < inp.length;i++){
				$(inp[i]).val("");
			}
		 	for(var i = 0; i < sele.length;i++){
				$(sele[i]).val("");
			} 
		});
	</script>

</body>

</html>