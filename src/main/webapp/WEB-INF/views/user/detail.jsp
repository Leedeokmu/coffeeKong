<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
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
				<span class="col-md-3">ID</span>
				<span class="col-md-9">${user.id }</span>
			</div><hr />
			<div class="row">
				<span class="col-md-3">EMAIL</span>
				<span class="col-md-9">${user.email }</span>
			</div><hr />
			<div class="row">
				<span class="col-md-3">FIRST NAME</span>
				<span class="col-md-9">${user.fname }</span>
			</div><hr />
			<div class="row">
				<span class="col-md-3">LAST NAME</span>
				<span class="col-md-9">${user.lname }</span>
			</div><hr />
		</div><br />
		<div>
			<div class="hor_center">
				<div class="btn-group">
					<button class="btn btn-default" onclick="move('/users/${user.id}/edit')">EDIT</button>
					<a href="#umdModal" data-toggle="modal" class="btn btn-default">DELETE</a>
				</div>
			</div>
		</div>
	</div>

</body>

<div id="umdModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title text-center">DELETE</h3>
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

<script>

</script>

</html>
