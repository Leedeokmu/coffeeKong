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
<title></title>
</head>
<body>
	<div class="a_title text-center"><h2>ORDER INFORMATION</h2></div><br />
	<div class="container a_article">
		<c:forEach var="opvo" items="${ovo.opvo }">
			<div class="row all_center">
				<div style="margin-right:2em">
					<img src="${opvo.p_img }" alt="img" class="" style="width:10em"/>
				</div>
				<div style="width:25em">
					<div class="row">
						<span class="col-md-4">NAME</span>
						<span class="col-md-8">${opvo.p_name }</span>
					</div>
					<div class="row">
						<span class="col-md-4">QUENTITY</span>	
						<span class="col-md-8">${opvo.op_qty}</span>
					</div>
					<c:if test="${opvo.p_category eq 'SingleOrigins' || opvo.p_category eq 'Blends' ||
					opvo.p_category eq 'Decafs' ||opvo.p_category eq 'Light' ||opvo.p_category eq 'Medium' ||
					opvo.p_category eq 'Dark' ||opvo.p_category eq 'ColdBrew'}">
						<div class="row">
							<span class="col-md-4">TYPE</span>	
							<span class="col-md-8">${opvo.op_type}</span>
						</div>
						<div class="row">
							<span class="col-md-4">SIZE</span>	
							<span class="col-md-8">${opvo.op_sz}</span>
						</div>
					</c:if>
					<div class="row">
						<span class="col-md-4">PRICE</span>
						<span class="col-md-8">$${opvo.op_price }</span>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="row text-right">
			<span class=""><h4>TOTAL PRICE   <strong>$${ovo.o_price }</strong></h4></span>
		</div>
		<hr />
		<div class="hor_center">
		<div class="row">
			<div>
				<h3>DELIVERY INFORMATION</h3>
			</div>
			<div class="row">
				<span class="col-md-3">RECEIVER</span>				
				<span class="col-md-9">${ovo.o_rfname }&nbsp;${oVo.o_rlname }</span>
			</div>
			<div class="row">
				<span class="col-md-3">PHONE</span>
				<span class="col-md-9">${ovo.o_phone }</span>
			</div>
			<div class="row">
				<span class="col-md-3">POST CODE</span>
				<span class="col-md-9">${ovo.o_postcode }&nbsp;&nbsp;&nbsp;</span>
			</div>
			<div class="row">
				<span class="col-md-3">ADDRESS</span>
				<span class="col-md-9">${ovo.o_addr }</span>
			</div>
			<div class="row">
				<span class="col-md-3">STATE</span>	
				<span class="col-md-9">${ovo.o_state }</span>
			</div>
		</div>
		</div>
		<hr />
		<div class="hor_right">
			<a href="/user/order/list" class="btn btn-default uolBtn">BACK</a>
		</div>
	</div>
	<form role="form">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<script>
		$(".uolBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[role="form"]');
			form.attr("method", "get");
			form.attr("action", "/user/order/list");
			form.submit();
		});
	</script>
</body>
</html>