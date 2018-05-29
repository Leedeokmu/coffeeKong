<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG</title>
</head>
<body>
	<div class="container-fluid">
		<div class="a_title hor_center"><h2>ORDER LIST</h2></div><br />
		<div class="row hor_center">
			<div class="col-md-2 text-center"><span>ORDER NO</span></div>
			<div class="col-md-2 text-center"><span>USER</span></div>
			<div class="col-md-6 text-center"><span>PRODUCT INFORMATION</span></div>
			<div class="col-md-2 text-center"><span>STATE</span></div>
		</div>
		<hr >
		<c:choose>
			<c:when test="${search eq 'off' }">
			<c:forEach var="ovo" items="${list }" varStatus="index">
				<c:if test="${fn:length(ovo.opvo) > 0 }">
					<div class="row all_center">
						<div class="col-md-2 h_nav text-center">${ovo.id }<br /><a href="/manage/order/detail${pmk.makeSearch(pmk.cri.page) }&oid=${ovo.id}" class="h_nav"><span>[ORDER DETAIL]</span></a></div>
						<div class="col-md-2 h_nav text-center">${ovo.email }</div>
						<div class="col-md-5">
						<c:forEach var="opvo" items="${ovo.opvo }" >	
							<div class="row">
								<div class="col-md-2"><a href="/product/detail${pmk.makeSearch(pmk.cri.page) }&pid=${opvo.productId }"><img src="${opvo.img }" style="width:5em" alt="img" /></a></div>
								<div class="col-md-4 h_nav"><a href="/product/detail${pmk.makeSearch(pmk.cri.page) }&pid=${opvo.productId }"><span>${opvo.name }</span></a></div>
								<div class="col-md-3"><span>${opvo.type }</span></div>
								<div class="col-md-1"><span>${opvo.qty }</span></div>
								<div class="col-md-2"><span>${opvo.sz}</span></div>
							</div>
						</c:forEach>
						</div>
						<div class="col-md-1"><span><b>$${ovo.price }</b></span></div>
						<div class="col-md-2">
							<span class="form-group-sm ver_center">
								<select name="state" class="form-control" id="state<c:out value="${index.count }"/>">
									<option value="waiting payment" <c:out value="${ovo.state eq 'waiting payment'? 'selected' : ''}"/>>waiting payment</option>
									<option value="prepare delivery" <c:out value="${ovo.state eq 'prepare delivery'? 'selected' : ''}"/>>prepare delivery</option>
									<option value="on delivery" <c:out value="${ovo.state eq 'on delivery'? 'selected' : ''}"/>>on delivery</option>
									<option value="delivered" <c:out value="${ovo.state eq 'delivered'? 'selected' : ''}"/>>delivered</option>
								</select>
							</span>
							<div class="hor_center" style="margin-top:1em">
								<input type="button" class="row btn btn-default btn-sm omsBtn" id="stateBtn<c:out value="${index.count }"/>" value="Change"/>
							</div>
							<form action="/manage/order/update/state" method="post" name="stateForm<c:out value="${index.count }"/>">
								<input type="hidden" name="state" value=""/>
								<input type="hidden" name="oid" value="${ovo.id }"/>
							</form>
						</div>
					</div>
					<hr>
				</c:if>
			</c:forEach>
			</c:when>
			<c:when test="${search eq 'on' }">
			<c:forEach var="ovo" items="${list }" varStatus="index">
				<c:if test="${fn:length(ovo.opvo) > 0 }">
				<div class="row ver_center">
					<div class="col-md-2 h_nav text-center">${ovo.id }<br /><a href="/manage/order/detail${pmk.makeSearch(pmk.cri.page) }&oid=${ovo.id}" class="h_nav"><span>[ORDER DETAIL]</span></a></div>
					<div class="col-md-2 h_nav text-center">${ovo.email }</div>
					<div class="col-md-6">
					<c:forEach var="opvo" items="${ovo.opvo }">	
						<div class="row">
							<div class="col-md-2"><a href="/product/detail${pmk.makeSearch(pmk.cri.page) }&pid=${opvo.productId }"><img src="${opvo.img }" style="width:5em" alt="img" /></a></div>
							<div class="col-md-4 h_nav"><a href="/product/detail${pmk.makeSearch(pmk.cri.page) }&pid=${opvo.productId }"><span>${opvo.name }</span></a></div>
							<div class="col-md-2"><span>${opvo.type }</span></div>
							<div class="col-md-1"><span>${opvo.qty }</span></div>
							<div class="col-md-1"><span>${opvo.sz}</span></div>
							<div class="col-md-2"><span><b>$${opvo.op_price }</b></span></div>
						</div>
					</c:forEach>
					</div>
					<div class="col-md-2">
						<div class="form-group-sm">
							<select name="state" class="form-control" id="state<c:out value="${index.count }"/>">
								<option value="waiting payment" <c:out value="${ovo.state eq 'waiting payment'? 'selected' : ''}"/>>waiting payment</option>
								<option value="prepare delivery" <c:out value="${ovo.state eq 'prepare delivery'? 'selected' : ''}"/>>prepare delivery</option>
								<option value="on delivery" <c:out value="${ovo.state eq 'on delivery'? 'selected' : ''}"/>>on delivery</option>
								<option value="delivered" <c:out value="${ovo.state eq 'delivered'? 'selected' : ''}"/>>delivered</option>
							</select>
						</div>
						<div class="hor_center" style="margin-top:1em">
							<input type="button" class="row btn btn-default btn-sm omsBtn" id="stateBtn<c:out value="${index.count }"/>" value="Change"/>
						</div>
						<form action="/manage/order/update/state" method="post" name="stateForm<c:out value="${index.count }"/>">
							<input type="hidden" name="state" value=""/>
							<input type="hidden" name="oid" value="${ovo.id }"/>
							<input type='hidden' name='page' value="${cri.page}"> 
							<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
							<input type='hidden' name='searchType' value="${cri.searchType}">
							<input type='hidden' name='keyword' value="${cri.keyword}">
						</form>
					</div>
				</div>
				<hr>
				</c:if>
			</c:forEach>
			</c:when>
		</c:choose>
		<div class="row text-center">
			<ul class="pagination">
				<c:if test ="${pmk.prev }">
					<li><a href="/manage/order/list${pmk.makeSearch(pmk.startPage - 1) }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pmk.startPage }" end="${pmk.endPage }" var="idx">
					<li <c:out value="${pmk.cri.page == idx? 'class=active' : '' }"/>>
						<a href="/manage/order/list${pmk.makeSearch(idx)}">${idx }</a>
					</li>
				</c:forEach>
				<c:if test ="${pmk.next && pmk.endPage > 0}">
					<li><a href="/manage/order/list${pmk.makeSearch(pmk.endPage + 1) }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
		<div class="row hor_center form-inline">
			<select name="searchType" class="form-control">
				<option value="nothing" <c:out value="${cri.searchType == null ? 'selnected' : '' }"/>>--------------</option>
				<option value="prodNm" <c:out value="${cri.searchType  eq 'prodNm' ? 'selected' : '' }"/>>Product Name</option>
				<option value="email" <c:out value="${cri.searchType  eq 'email' ? 'selected' : '' }"/>>Email</option>
			</select>
			<input type="search" class="form-control" name="keyword" value="${cri.keyword }">
			<button id="searchBtn" class="btn btn-default">Search</button>
		</div>
	</div>
	
	<script>
		$(document).ready(function(){
			function search(){
				self.location = "/manage/order/list" +'${pmk.makeQuery(1)}'
				+"&searchType=" +$('select[name="searchType"]').val()
				+"&keyword="+$('input[type="search"]').val().toLowerCase();
			}
			
			$('#searchBtn').on("click", function(){
				search();
			});
			$('input[name="keyword"]').on("keyup", function(event) {
    			if (event.keyCode == 13) {
    				search();
    			}
			});
			$('.omsBtn').on("click",function(e){
				var delim = $(this).attr('id').substr($(this).attr('id').length-1);
				var state = $('#state'+delim).val();
				var form = $('form[name="stateForm'+delim+'"]');
				
				form.find('input[name="state"]').attr("value", state);
				form.submit();
			});
		});
	</script>
</body>
</html>