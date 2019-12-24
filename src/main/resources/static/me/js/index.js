 // 去掉所有input的autocomplete, 显示指定的除外 
$(function(){ 
                              
 $('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off'); 
 
});
