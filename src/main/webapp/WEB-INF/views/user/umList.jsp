<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG</title>
</head>
<body>
	<div class="container a_article">
		<div class="a_title text-center"><h2><span>USER LIST</span></h2></div><br /><br />
		<div class="row text-center">
			<div class="col-md-3"><span>EMAIL</span></div>
			<div class="col-md-3"><span>FIRST NAME</span></div>
			<div class="col-md-3"><span>LAST NAME</span></div>
			<div class="col-md-3"><span>POINT</span></div>
		</div>
		<hr>
		<c:forEach var="uvo" items="${list}">
			<div class="row text-center">
				<div class="col-md-3 h_nav"><a href="/manage/user/detail${pmk.makeSearch(pmk.cri.page) }" class="udBtn">${uvo.email }</a></div>
				<div class="col-md-3">${uvo.fname }</div>
				<div class="col-md-3">${uvo.lname }</div>
				<div class="col-md-3">${uvo.point }</div>
			</div>
			<hr />
		</c:forEach>
		<div class="row text-center">
			<ul class="pagination">
				<c:if test ="${pmk.prev }">
					<li><a href="/manage/user/list${pmk.makeSearch(pmk.startPage - 1) }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pmk.startPage }" end="${pmk.endPage }" var="idx">
					<li <c:out value="${pmk.cri.page == idx? 'class=active' : '' }"/>>
						<a href="/manage/user/list${pmk.makeSearch(idx)}">${idx }</a>
					</li>
				</c:forEach>
				<c:if test ="${pmk.next && pmk.endPage > 0}">
					<li><a href="/manage/user/list${pmk.makeSearch(pmk.endPage + 1) }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
		<div class="row hor_center form-inline">
			<select name="searchType" class="form-control">
				<option value="" <c:out value="${cri.searchType == null ? 'selected' : '' }"/>>--------------</option>
				<option value="email" <c:out value="${cri.searchType  eq 'email' ? 'selected' : '' }"/>>Email</option>
			</select>
			<input type="search" class="form-control" name="keyword" value="${cri.keyword }">
			<button id="searchBtn" class="btn btn-default">Search</button>
		</div>
		<form name="umdetail"></form>
	</div>
	<script>
		$(document).ready(function(){
			$('#searchBtn').on("click", function(event){
				search();
			});
			$('input[name="keyword"]').on("keyup", function(event) {
    			if (event.keyCode == 13) {
    				search();
    			}
			});
			$('.udBtn').on("click",function(e){
				e.preventDefault();
				var url = $(this).attr('href');
				url += "&email=" + encodeURI($(this).text());
				location.href = url;
			})
		});

		function search(){
			self.location = "/manage/user/list" +'${pmk.makeQuery(1)}'
					+"&searchType=" +$("select option:selected").val()
					+"&keyword="+$('input[name="keyword"]').val().toLowerCase();
		}
	</script>
</body>
</html>