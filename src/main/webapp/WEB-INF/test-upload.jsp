<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <div class="form-group">	
											 	<label for="exampleInputEmail1">Image for web 123 x 70</label>
												<div >
													<img id="thumnail" src="${pageContext.request.contextPath}/resources/assets/img/default-image/default-playlist.jpg " class="img-responsive"/>
												</div>
												<span class="btn btn-default btn-file">
													<span class="fileinput-new">Select image</span>
													<input type="file" name="fileThumbnail" id="fileThumbnail">
												</span>
											</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	 $('#fileThumbnail').change(
				function(event) {
					$("#thumnail").fadeIn("fast").attr('src',
							URL.createObjectURL(event.target.files[0]));
					uploadThumbnail();
	});
	 
	uploadThumbnail = function(){
		var formData = new FormData();
	 	formData.append('file',  $("#fileThumbnail")[0].files[0]);
	 	console.log( $("#fileThumbnail")[0].files[0]);
	     	$.ajax({
		            url: "http://localhost:8888/api/uploadfile",
		            type: "POST",
		         	enctype : 'multipart/form-data',
				data : formData ,
				processData : false, // tell jQuery not to process the data
				contentType : false, // tell jQuery not to set contentType
				  beforeSend: function(xhr) {
					 
		  	        },
		            success: function(data) {
		            	console.log(data); 
		            	bgImage = data.IMG;
		            },
		         	error: function(data){
		         		console.log(data);
					}
		        });
		
	};
});
</script>

</body>
</html>