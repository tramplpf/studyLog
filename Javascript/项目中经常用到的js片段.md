#项目中经常用到的js片段

通过ajax的方式向后台发送url请求：
$.ajax({
	url:contextPath + "/**/**",
	type:'POST',
	contentType:'application/json;charset=utf-8',
	async:false,
	dataType:'json',
	data:JSON.stringify("Arrayl类型的数据");
	success:function(data){
		console.info(data);
}
});


格式化json格式数据：
result = JSON.parse(data);


