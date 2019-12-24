<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>博客</title>
<script type="text/javascript" src="../me/js/commonJs.js"></script>
<script type="text/javascript" src="../me/js/commonCss.js"></script>
<style type="text/css">
	.remarkname{
		width:10%;
	}
	td{
		padding:0px;
		align:left; 
		valign:top;
	}
	.remark{
		width:60%;
	}
	.time{
		width:30%;
	}
	

</style>
<body>


	<div class="easyui-layout"
		style="height: 90%; width: 90%; border: 1px; margin: 10px 20px;">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			class="memb-table" id="datas" style="border-spacing:10px 10px;">
		</table>
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
		var blogid=getUrlParameter("blogid");
		getRemark(blogid);
	});
	
	
	
	
	
	function getRemark(blogid){
		var tb = document.getElementById('datas');
		    var rowNum=tb.rows.length;
		    for (i=0;i<rowNum;i++)
		    {
		        tb.deleteRow(i);
		        rowNum=rowNum-1;
		        i=i-1;
		    } 
			$.ajax({
	 			type: 'POST',
	 			url: '../admin/blog/getRemarkById',
	 			dataType: "json",
	 			cache:true,
	 			async:false,
	 			data: {blogid:blogid},
				success: function (data) {
					if(data.state == true){
					//listSource为后台传过来的数组
						var source=data.result;
						var tbBody = "<tr class=\"trs\"><td class=\"remarkname\">评论人</td><td class=\"remark\">评论信息</td><td class=\"time\">评论时间</td></tr>";
						
						for(i in source){
							tbBody += "<tr class=\"trs\"><td class=\"remarkname\" align=\"left\" valign=\"top\">"+source[i].remarkname+"</td><td class=\"remark\">"+source[i].remark+"</td><td class=\"time\"  align=\"left\" valign=\"top\">"+source[i].createtime+"</td></tr>";
						}
						$("#datas").append(tbBody);
					}else{
						var tbBody = "";
						tbBody += "<tr id=\"template\"><td id=\"name\">没有您想要的素材</td></tr>";
						$("#datas").append(tbBody);
					} 
				} 
			});  

	}
				
	</script>

</body>

</html>