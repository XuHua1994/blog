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
    <script type="text/javascript" src="../js/god/queryHbase.js"></script>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
    <script type="text/javascript" src="../js/layer/layer.js"></script>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
<style type="text/css">
</style>
<body>


	<div class="easyui-layout" style="height: 90%; width:90%; border: 1px; margin: 30px 20px;">
		<div style="margin-bottom: 30px;">
			<span>
				<span><a>博客名: <input id="blogname" name="blogname" style="width: 200px;"></a></span>
				<span id="personStr" style="margin-left: 20px;"><a>作者: </a><input id="username" name="username" style="width: 80px;"></input></span>
				<span id="blogsignStr" style="margin-left: 20px;">
					<a>是否公开:</a> 
					<a class="inputTd"><select class="input" id="blogsign" style="width: 120px;height:32px;"></select></a>
				</span>
				<span style="margin-left: 20px;">
					<a>博客主题:</a>
					<a class="inputTd"><select class="input" id="blogtheme" style="width: 120px;height:32px;"></select></a>
				</span>
			</span>
			
		</div>
		

		<div>
			<div><a>博客内容:</a></div>
			<div>
				<textarea  id="blogcontent" name="blogcontent"
				 style="width: 860px;height:320px;" value=""></textarea>
			</div>
			
		</div>
		<div id="remarkStr" style="display:none;">
			<a>评论:</a>
			<input id="remark" name="remark"
				style="width: 180px;height:30px;">
		</div>
		
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
    var uid=${Session.id};
	var bid=getUrlParameter("id");
	
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
		if(bid!=null){
			edit(bid);
		}else{
			$("#personStr").css("display","none");
		}
	})
	
	
	function edit(bid){
		$("#person").css("display","block");
		$("#remarkStr").css("display","block");
		$("#blogsignStr").css("display","none");
		
		$.ajax({
			url: '../admin/blog/'+bid,
			type: "GET",
			dataType: "json",
			async:false,//同步请求
			success: function(data) {
				var r=data.result[0];
				$("#blogname").val(r.blogname);
				$("#username").val(r.username);
				$("#blogtheme").find("option[value='"+r.blogtheme+"']").attr("selected",true);
				$("#blogcontent").val(r.blogcontent);
				
			}
		})
	}
		var getCode = function(type,callback){
			$.ajax({
				url: '../admin/dictionary/'+type,
				type: "GET",
				async: false,//同步请求   
				dataType: "json",
				success: function(data) {
					callback(data.result);
				}
			})
		};
		var setOptions = function($obj,jsonData,html){
			if(typeof(jsonData)!="undefined" && jsonData!=null){
				//var html = "";
				for(var key in jsonData){
					html += '<option value="'+jsonData[key].dickey+'">'+jsonData[key].dicvalue+'</option>'
				}
				$obj.html(html);
			}
		};
	
	
	
		function submit() {
			var queryParams = {};
			var url='';
			if(bid!=null){
				queryParams["remark"] = $("#remark").val();
				queryParams["blogid"] = bid;
                queryParams["remarkid"] = uid;
				url='../admin/blog/remark';
			}else{
				queryParams["blogname"] = $("#blogname").val();
				queryParams["blogtheme"] = $("#blogtheme").val();
				queryParams["blogsign"] = $("#blogsign").val();
				queryParams["blogcontent"] = $("#blogcontent").val();
				url='../admin/blog/'+uid;
			}
			
			
			$.ajax({
				url : url,
				type : "POST",
				dataType : "json",
				data : queryParams,
				cache : false,
				success : function(data) {
					if (data.state) {
						layer.alert(data.msg, function() {
							window.parent.init_datagrid();
							window.parent.layerClose();
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