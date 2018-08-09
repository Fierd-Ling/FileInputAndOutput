<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
</style>
<body>
	<!-- 需要form表单包起来 -->
	<form id="file">
		<input type="file" name="inputfil" id="inputfil" />
	</form>
	<span id="span" style="background: blue">上传</span>
	 
	<a href="fileController/download">下载</a>
	<script type="text/javascript" src="jquery-3.3.1.js">
</script>
	<script type="text/javascript">
$(document).ready(function(){
	$("#span").click(function(){
		var formData = new FormData($("#file")[0]);  //上传的文件file
		 //console.log(formData);
		$.ajax({
            url: "fileController/inputImg",
            type: "post",
            data: formData,
            cache: false,
            contentType: false,
           processData: false,
        	async: false, 
            success: function(data) {
            	if(data=="success"){
            		alert("上传成功");
                	window.location.reload();
            	}
            	else{
            		alert("上传失败");
                	window.location.reload();
            	}
            }
       })
	});
});




</script>
</body>
</html>
