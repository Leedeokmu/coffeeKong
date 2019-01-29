<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG.</title>
</head>

<body>
	<div class="container">
		<div class="a_title text-center"><h2><span>USER INFORMATION</span></h2></div><br />
		<div>
			<div class="row">
				<span class="col-md-3">EMAIL</span>
				<span class="col-md-9">${uvo.email }</span>
			</div><hr />
			<div class="row">
				<span class="col-md-3">FIRST NAME</span>
				<span class="col-md-9">${uvo.fname }</span>
			</div><hr />
			<div class="row">
				<span class="col-md-3">LAST NAME</span>
				<span class="col-md-9">${uvo.lname }</span>
			</div><hr />
			<div class="row">
				<span class="col-md-3">POINT</span>
				<span class="col-md-9">${uvo.point }</span>
			</div>
		</div><br />
		<div>
			<div class="hor_center">
				<div class="btn-group">
					<input type="button" class="btn btn-default uuBtn" value="EDIT"/>
					<a href="#umdModal" data-toggle="modal" class="btn btn-default">DELETE</a>
				</div>
				<div id="umdModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3 class="modal-title text-center">DELTE</h3>
						</div>
						<div class="modal-body text-center">
							<h3>DELETE THIS USER? CHECK ONCE MORE.</h3><br />
						</div>
						<div class="modal-footer">
							<div >
								<input type="button" class="btn btn-default udBtn" value="ACCEPT"/>
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
      					</div>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
	<form role="form">
		<input type='hidden' name='email' value="${uvo.email}">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<script>
		$(".uuBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[role="form"]');
			form.find('input[name="email"]').attr("value", encodeURI(form.find('input[name="email"]').attr("value")));
			form.attr("method", "get");
			form.attr("action", "/manage/user/update");
			form.submit();
		});
		
		$(".udBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[role="form"]');
			form.find('input[name="email"]').attr("value", encodeURI(form.find('input[name="email"]').attr("value")));
			form.attr("method", "post");
			form.attr("action", "/manage/user/delete");
			form.submit();
		});
	</script>
</body>
</html>