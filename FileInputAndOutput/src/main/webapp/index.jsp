<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
</style>
<body>
       <!-- 需要form表单包起来 -->
		<form id="file">
<input type="file" accept="image/png,image/jpeg, image/gif,image/jpg"
 name="inputfil" id="inputfil"/>
  <input type="button" value="上传" id="span"/>
		</form>
<script type="text/javascript"  src="jquery-3.3.1.js">
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#span").click(function(){
		var formData = new FormData($("#file")[0]);  //上传的文件file
		 //console.log(formData);
		$.ajax({
            url: "fileController/inputImg",
            type: "POST",
            data: formData,
            cache: false,
            contentType: false,
           processData: false,
        	async: false, 
            success: function(data) {
            	alert("ok");
            	window.location.reload();
            }
       })
		
		
	});
	
	
	
	
});




</script>



</body>
</html>
