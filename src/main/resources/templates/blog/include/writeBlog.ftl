<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>博客</title>
<script type="text/javascript" src="../me/js/commonJs.js"></script>
<script type="text/javascript" src="../me/js/commonCss.js"></script>
<body>


	<div class="easyui-layout" style="height: 90%; border: 1px;">
		<div>
			<div><a>博客名:</a><input id="blogname" name="blogname" style="width: 80px;"></div>
			<div>
				<a>是否公开</a> <select id="blogsign">
					
				</select>
			</div>
			<div><a>类型</a>
			<a class="inputTd"><select class="input" id="blogtheme" style="width: 240px;height:32px;"></select></a></div>
		</div>

		<div>
			<a>博客内容:</a><input id="blogcontent" name="blogcontent"
				style="width: 80px;">
		</div>
		<button type="button" id="" onclick="submit()">提交</button>
	</div>

	<script>
		var $blogtheme = $("#blogtheme");
		var $blogsign = $("#blogsign");
		$().ready(function(){
			getCode("blogtheme",function(data){
				var html="请选择";
				setOptions($blogtheme,data,html);
			});
			getCode("blogsign",function(data){
				var html="请选择";
				setOptions($blogsign,data,html);
			});
			
		})
	
		var getCode = function(type,callback){
			$.ajax({
				url: '../admin/dictionary/getDictionaryByType?',
				type: "POST",
				async:true,
				dataType: "json",
				data: {type:type},
				success: function(data) {
					callback(data.result);
				}
			})
		};
		var setOptions = function($obj,jsonData,html){
			if(typeof(jsonData)!="undefined" && jsonData!=null){
				//var html = "";
				for(var key in jsonData){
					html += '<option value="'+jsonData[key].key+'">'+jsonData[key].value+'</option>'
				}
				$obj.html(html);
				/* if(flag==1){
					edit();
				} */
			}
		};
	
	
	
		function submit() {
			var queryParams = {};
			queryParams["blogname"] = $("#blogname").val();
			queryParams["blogtheme"] = $("#blogtheme").val();
			queryParams["blogsign"] = $("#blogsign").val();
			queryParams["blogcontent"] = $("#blogcontent").val();
			$.ajax({
				url : '../admin/blog/writeBlog',
				type : "POST",
				dataType : "json",
				data : queryParams,
				cache : false,
				success : function(data) {
					if (data.state) {
						layer.alert(data.msg,function(){
							window.perent.init_datagrid();
							window.location.href='person';
						});
					} else {
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