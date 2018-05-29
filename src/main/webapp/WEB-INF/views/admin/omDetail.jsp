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

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG</title>
</head>
<body>
	<div class="a_title text-center"><h2>ORDER INFORMATION</h2></div><br />
	<div class="container a_article">
		<c:forEach var="opvo" items="${ovo.opvo }">
			<div class="row all_center">
				<div style="margin-right:2em">
					<img src="${opvo.img }" alt="img" class="" style="width:10em"/>
				</div>
				<div style="width:25em">
					<div class="row">
						<span class="col-md-4">NAME</span>
						<span class="col-md-8">${opvo.name }</span>
					</div>
					<div class="row">
						<span class="col-md-4">QUENTITY</span>	
						<span class="col-md-8">${opvo.qty}</span>
					</div>
					<c:if test="${opvo.category eq 'SingleOrigins' || opvo.category eq 'Blends' ||
					opvo.category eq 'Decafs' ||opvo.category eq 'Light' ||opvo.category eq 'Medium' ||
					opvo.category eq 'Dark' ||opvo.category eq 'ColdBrew'}">
						<div class="row">
							<span class="col-md-4">TYPE</span>	
							<span class="col-md-8">${opvo.type}</span>
						</div>
						<div class="row">
							<span class="col-md-4">SIZE</span>	
							<span class="col-md-8">${opvo.sz}</span>
						</div>
					</c:if>
					<div class="row">
						<span class="col-md-4">PRICE</span>
						<span class="col-md-8">$${opvo.price}</span>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="row text-right">
			<span class=""><h4>TOTAL PRICE   <strong>$${ovo.price}</strong></h4></span>
		</div>
		<hr />
		<div class="hor_center">
		<div class="row">
			<div>
				<h3>DELIVERY INFORMATION</h3>
			</div>
			<div class="row">
				<span class="col-md-3">RECEIVER</span>				
				<span class="col-md-9">${ovo.fname }&nbsp;${ovo.lname }</span>
			</div>
			<div class="row">
				<span class="col-md-3">PHONE</span>
				<span class="col-md-9">${ovo.phone }</span>
			</div>
			<div class="row">
				<span class="col-md-3">POST CODE</span>
				<span class="col-md-9">${ovo.postcode }&nbsp;&nbsp;&nbsp;</span>
			</div>
			<div class="row">
				<span class="col-md-3">ADDRESS</span>
				<span class="col-md-9">${ovo.addr }</span>
			</div>
			<div class="row">
				<span class="col-md-3">STATE</span>	
				<span class="col-md-9">${ovo.state }</span>
			</div>
		</div>
		</div>
		<hr />
	</div>
	<div>
		<div class="hor_center">
			<div class="btn-group">
				<input type="button" class="btn btn-default omuBtn" value="EDIT" />
				<a href="#omdModal" data-toggle="modal" class="btn btn-default">DELETE</a>
				<a href="/user/order/list" class="btn btn-default omlBtn">BACK</a>
			</div>
			<div id="omdModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3 class="modal-title text-center">DELTE</h3>
						</div>
						<div class="modal-body text-center">
							<h3>DELETE THIS ORDER? CHECK ONCE MORE.</h3>
							<br />
						</div>
						<div class="modal-footer">
							<div>
								<input type="button" class="btn btn-default omdBtn"
									value="ACCEPT" />
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form role="form">
		<input type='hidden' name='oid' value="${ovo.id}">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<script>
		$(".omlBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[role="form"]');
			form.attr("method", "get");
			form.attr("action", "/manage/order/list");
			form.submit();
		});
		$(".omuBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[role="form"]');
			form.attr("method", "get");
			form.attr("action", "/manage/order/update");
			form.submit();
		});
		
		$(".omdBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[role="form"]');
			form.attr("method", "post");
			form.attr("action", "/manage/order/delete");
			form.submit();
		});
	</script>
</body>
</html>