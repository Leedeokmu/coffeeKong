<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<c:set var="basePath" value="${pageContext.request.contextPath }"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG.</title>
</head>
<body>
	<div class="container">
	<div class="alert alert-warning">
		<h2>YOU REALLY RESIGN FROM COFFEEKONG?</h2>
	</div><br />
	<div class="hor_center">
		<form action="/user/resign" name="uresign" method="POST">
			<input type="hidden" name="email" value="${login.email }"/>
			<div>
				<label for="password">ENTER YOUR PASSWORD</label>
				<input type="password" class="form-control" id="password" name="pwd" />
			</div>
			<br>
			<div class="errmsg" style="min-height:20px"></div>
			<div class="hor_center">
				<input type="submit" class="btn btn-warning btn-sm" value="submit"/>
			</div>
		</form>
	</div>
	</div>
	<script>
	$(document).ready(function(){
		$('form[name="uresign"]').submit(function(event){
			event.preventDefault();
	    	var data = form_to_json(this);
	    	
	    	$.ajax({
	    		type:'POST',
	    		url: '/user/resign',
	    		headers : {
	    			"Content-Type" : "application/json",
	    			"X-HTTP-Method-Override" : "POST"
	    		},
	    		dateType: 'json',
	    		data: JSON.stringify(data),
	    		success : function(result){
	    			if(result == "Success"){
	    			    location.href = '/user/urcompl';
	    				// window.location.replace('/user/urcompl');
	    			}else if(result == "Fail"){
	    				$('.errmsg').html('<span>PASSWORD IS INCORRECT.</span>').fadeIn('slow').fadeOut('slow');
	    			}
	    		}
	    		,
	    	 	error: function(request,status,error){
	    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	    }
	    	});
		});
	})
	</script>
</body>
</html>