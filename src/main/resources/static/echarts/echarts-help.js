$().ready(function() {
	$(".echart-lbtn").find("button").click(function(){
		if ($(this).html() == "图表"){
			var topParent = $(this).parent().parent();
			topParent.find(".echart-chart").show();
			topParent.find(".echart-list").hide();
		} else {
			var topParent = $(this).parent().parent();
			topParent.find(".echart-chart").hide();
			topParent.find(".echart-list").show();
		}
	});
});

(function($) {
	$.loadEchartListData = function(table, datas) {
		var html = "";
		for (i in datas){
			var row = datas[i];
			html = html + "<tr>";
			for (j in row){
				html = html + "<td>" + row[j] + "</td>";
			}
			html = html + "</tr>";
		}
		table.find("tr").remove();
		table.append(html);
	}
})(jQuery);