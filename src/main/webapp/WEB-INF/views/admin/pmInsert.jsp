<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<hr>
				<h3>Add New Product</h3>
			<hr>
		</div>
		<form method="post" name="pminsert" action="/manage/product/insert" enctype="multipart/form-data">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
		<div class="row">
			<div class="col-md-6 all_center" id="imageDiv">
				<img src="/dist/product/sample.jpg" id="imgsrc" style="width:20em;height:20em"/>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="pmiCategory">Category</label> 
					<select name="p_category" class="form-control" id="pmiCategory">
						<optgroup label="COFFEE">
					    	<option value="SingleOrigins">Single Origins</option>
					    	<option value="Blends">Blends</option>
					    	<option value="Decafs">Decafs</option>
						    <option value="Light">Light</option>
						    <option value="Medium">Medium</option>
						    <option value="Dark">Dark</option>
						    <option value="ColdBrew">Cold Brew</option>
					  	</optgroup>
					  	<optgroup label="TOOLS">
						    <option value="Grinder">Grinder</option>
						    <option value="HomeBrewing">Home brewing</option>
						    <option value="Cups">Cups</option>
						</optgroup>
					</select>
				</div>
				<div class="form-group">
					<label for="pmiName">Name</label>
					<input type="text" name="p_name" id="pmiName" class="form-control" 
					placeholder="Enter Product Name" /> 
				</div>
				
				<div class="form-group">
					<label for="pmiPrice">Price</label>
					<input type="text" name="p_price" id="pmiPrice" class="form-control" 
					placeholder="Enter Price" /> 
				</div>
				<div class="form-group">
					<label for="pmiMdate">Manufactured</label>
					<input type="date" name="p_mdate" id="pmiMdate" class="form-control"/> 
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="pmiContent">Content</label>
			<textarea name="p_content" id="pmiContent" class="form-control"  
			cols="30" rows="3"></textarea> 
		</div>
		<hr />
		<div class="hor_center">
			<div class="btn-group">
				<input type="submit" class="btn btn-success" value="ACCEPT">
				<input type="reset" class="btn btn-default" value="RESET">
				<a href="javascript:history.go(-1);" class="btn btn-default">BACK</a>
			</div>
		</div>
		</form>
	</div>
	<form name="afterPmi" action="/manage/product/list">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<script>
	$(document).ready(function(){
		uploadfile = null;
		
		function checkImageType(fileName){
			var pattern = /jpg|gif|png|jpeg|bmp/i;
			return fileName.match(pattern);
		}
	
		$('#imageDiv').on("dragenter dragover", function(event){
			event.preventDefault();
		})
		$('#imageDiv').on("drop",function(event){
			event.preventDefault();
			var files = event.originalEvent.dataTransfer.files;
			
			if (files && files[0]) {
				if(!checkImageType(files[0].name)){
					alert("Provide Only Image Files!(eg. .jpg/jpeg, .gif, .png, .bmp)");
					return;
				}else if(files[0].fileSize > 1024 * 500){
					alert("FileSize Over 500KB!");
					return;
				}
				uploadfile = files[0];
	            var reader = new FileReader();
				
	            reader.onload = function (e) {
	                $('#imgsrc').attr('src', e.target.result);
	            };
				
	        	reader.readAsDataURL(files[0]);
	    	}
		})
	});
	</script>
</body>
</html>