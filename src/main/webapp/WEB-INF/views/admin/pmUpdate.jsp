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
				<h3>Edit Product</h3>
			<hr>
		</div>
		<form method="post" name="pmupdate" action="/manage/product/update/save" enctype="multipart/form-data">
		<input type='hidden' name='id' value="${pvo.id}">
		<input type='hidden' name='rdate' value="${pvo.rdate}">
		<input type='hidden' name='img' value="${pvo.img}">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
		<div class="row">
			<div class="col-md-6 all_center" id="imageDiv">
				<img src="${pvo.img }" id="imgsrc" style="width:20em;height:20em"/>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="pmiCategory">Category</label> 
					<select name="category" class="form-control" id="pmiCategory">
						<optgroup label="COFFEE">
					    	<option value="SingleOrigins" <c:out value="${pvo.category eq 'SingleOrigins'? 'selected': '' }"/>>Single Origins</option>
					    	<option value="Blends" <c:out value="${pvo.category eq 'Blends'? 'selected': '' }"/>>Blends</option>
					    	<option value="Decafs" <c:out value="${pvo.category eq 'Decafs'? 'selected': '' }"/>>Decafs</option>
						    <option value="Light" <c:out value="${pvo.category eq 'Light'? 'selected': '' }"/>>Light</option>
						    <option value="Medium" <c:out value="${pvo.category eq 'Medium'? 'selected': '' }"/>>Medium</option>
						    <option value="Dark" <c:out value="${pvo.category eq 'Dark'? 'selected': '' }"/>>Dark</option>
						    <option value="ColdBrew" <c:out value="${pvo.category eq 'ColdBrew'? 'selected': '' }"/>>Cold Brew</option>
					  	</optgroup>
					  	<optgroup label="TOOLS">
						    <option value="Grinder" <c:out value="${pvo.category eq 'Grinder'? 'selected': '' }"/>>Grinder</option>
						    <option value="HomeBrewing" <c:out value="${pvo.category eq 'HomeBrewing'? 'selected': '' }"/>>Home brewing</option>
						    <option value="Cups" <c:out value="${pvo.category eq 'Cups'? 'selected': '' }"/>>Cups</option>
						</optgroup>
					</select>
				</div>
				<div class="form-group">
					<label for="pmiName">Name</label>
					<input type="text" name="name" id="pmiName" class="form-control" value="${pvo.name }"
					placeholder="Enter Product Name" /> 
				</div>
				
				<div class="form-group">
					<label for="pmiPrice">Price</label>
					<input type="text" name="price" id="pmiPrice" class="form-control" value="${pvo.price }"
					placeholder="Enter Price" /> 
				</div>
				<div class="form-group">
					<label for="pmiMdate">Manufactured</label>
					<input type="date" name="mdate" id="pmiMdate" value="${pvo.mdate }" class="form-control"/>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="pmiContent">Content</label>
			<textarea name="content" id="pmiContent" class="form-control"
			cols="30" rows="3">${pvo.content }</textarea>
		</div>
		<hr />
		<div class="hor_center">
			<div class="btn-group">
				<input type="submit" class="btn btn-success" value="ACCEPT">
				<a href="javascript:history.go(-1);" class="btn btn-default">BACK</a>
			</div>
		</div>
		</form>
	</div>
	<form name="afterPmu" action="/manage/product/detail">
		<input type='hidden' name='id' value="${pvo.id}">
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
					return;
				}
				uploadfile = files[0];
	            var reader = new FileReader();
				
	            reader.onload = function (e) {
	                $('#imgsrc').attr('src', e.target.result);
	            };
				
	        	reader.readAsDataURL(files[0]);
	    	}
		});
		
	});
	</script>
</body>
</html>