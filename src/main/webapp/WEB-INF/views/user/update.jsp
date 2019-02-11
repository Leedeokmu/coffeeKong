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
	<div class="a_title text-center"><h2><span>MODIFY USER INFORMATION</span></h2></div><br />
	<div class="container">
		<form id="updateUserForm" class="form-horizontal">
			<div>
				<div class="form-group ver_center">
					<label  class="control-label col-md-3">ID</label>
					<div class="col-md-9"><span><input type="text" name="id" class="form-control" value="${user.id}" readonly="readonly"/></span></div>
				</div>
				<div class="form-group ver_center">
					<label  class="control-label col-md-3">EMAIL</label>
					<div class="col-md-9"><span><input type="text" name="email" class="form-control" value="${user.email}" readonly="readonly"/></span></div>
				</div>
				<div class="form-group ver_center">
					<label class="control-label col-md-3">FIRST NAME</label>&nbsp;
					<div class="col-md-9"><input type="text" name="fname" class="form-control" value="${user.fname }" /></div>
				</div>
				<div class="form-group ver_center">
					<label class="control-label col-md-3">LAST NAME</label>&nbsp;
					<div class="col-md-9"><input type="text" name="lname" class="form-control" value="${user.lname }" /></div>
				</div>
				<div class="form-group ver_center">
					<label class="control-label col-md-3">PASSWORD</label>&nbsp;
					<div class="col-md-9"><input type="password" class="form-control" name="pwd" /></div>
				</div>
				<div class="hor_center">	
					<div class="btn-group">
						<button class="btn btn-default" onclick="updateUser()">ACCEPT</button>&nbsp;
						<a href="/users" class="btn btn-default ulBtn" >TO LIST</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script>
		const updateUser = () => {
			if(confirm('are you sure to update ${user.email}?')){
				let uri = '/users/${user.id}';
				let response = httpCall('PUT', uri, $('#updateUserForm').serialize());
				response.done((res) => {
					alert('update ${user.email} success!');
					move('/users');
				}).fail((e) => {
					console.log(e);
					alert('failed to update ${user.email}');
				})
			}
		}
	</script>
</body>
</html>
