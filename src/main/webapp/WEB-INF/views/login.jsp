<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WELCOME, COFFEE KONG</title>
</head>
<body>
	<div class="container">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title">LOGIN</h3>
				</div>
				<div class="modal-body">
					<form action="/login" method="post">
						<div class="form-group">
							<label for="loginId">EMAIL</label> 
							<input type="email" class="form-control" name="email" id="loginId">
						</div>
						<div class="form-group">
							<label for="loginPw">PASSWORD</label>
							<input type="password" class="form-control" name="pw" id="loginPw">
						</div>
						<div class="checkbox icheck">
				        	<label>
				          		<input type="checkbox" name="useCookie"> Remember
				        	</label>
						</div>     						
						<div class="errmsg"></div>
						<div>
							<input type="button" value="LOGIN" class="btn btn-default"
								onclick="loginCheck()">&nbsp; <input type="reset"
								class="btn btn-default" value="RESET">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%'
        });
      });x
    </script>
</body>
</html>