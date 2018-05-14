<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG</title>
</head>

<body>
	<div class="container">
		<div class="row text-center">
			<hr>
				<h3>Product Information</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-md-6 all_center" id="imageDiv">
				<img src="${pvo.p_img }" id="imgsrc" style="width:20em;height:20em"/>
			</div>
			
			<div class="col-md-6">
				<div class="form-group">
					<label for="pmiCategory">Category</label> 
					<div>${pvo.p_category }</div>
				</div>
				<div class="form-group">
					<label for="pmiName">Name</label>
					<div>${pvo.p_name }</div>
				</div>
				
				<div class="form-group">
					<label for="pmiPrice">Price</label>
					<div>$${pvo.p_price}</div>
				</div>
				<div class="form-group">
					<label for="pmiMdate">Manufactured</label>
					<div>${pvo.p_mdate}</div> 
				</div>
				<div class="form-group">
					<label for="pmirdate">Registered</label>
					<div>${pvo.p_rdate}</div> 
				</div>
			</div>
		</div>
		<div class="form-group text-center">
			<label for="pmiContent">Content</label>
			<div>${pvo.p_content }</div>
		</div>
		<div>
			<div class="hor_center">
				<div class="btn-group">
					<a href="/manage/product/update" class="btn btn-default pmuBtn">EDIT</a>
					<a href="#pmdModal" data-toggle="modal" class="btn btn-default">DELETE</a>
					<a href="javascript:history.go(-1)" class="btn btn-default">BACK</a>
				</div>
				<div id="pmdModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h3 class="modal-title text-center">COMFIRM DELETING</h3>
							</div>
							<div class="modal-body text-center">
								<h3>DELETE THIS USER? CHECK ONCE MORE.</h3>
								<br />
							</div>
							<div class="modal-footer">
								<div>
									<a href="/manage/product/delete" class="btn btn-default pmdBtn">DELETE</a>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form role="form">
		<input type='hidden' name='pid' value="${pvo.p_id}"> 
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}"> 
		<input type='hidden' name='searchType' value="${cri.searchType}"> 
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<script>
		$(".pmuBtn, .pmdBtn").on("click", function(e) {
			e.preventDefault();
			var form = $('form[role="form"]');
			form.attr("action", $(this).attr("href"));
			if ($(this).attr("class").indexOf("pmuBtn") > 0) {
				form.attr("method", "get");
			} else if ($(this).attr("class").indexOf("pmdBtn") > 0) {
				form.append('<input type="hidden" name="p_img" value="${pvo.p_img}"/>');
				form.attr("method", "post");
			}

			form.submit();
		})
	</script>
</body>
</html>