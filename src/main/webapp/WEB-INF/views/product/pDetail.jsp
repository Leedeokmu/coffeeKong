1<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<title>COFFEE KONG.</title>
</head>
<style>
	.jumbotron{
		background-color: white;
	}
</style>
<body>
	<div class="container">
		<form method="POST" action="/user/tocart" name="tocart">
			<input type="hidden" name="productId" value="${pvo.id}">
			<input type="hidden" name="name" value="${pvo.name}">
			<input type="hidden" name="category" value="${pvo.category}">
			<input type="hidden" name="img" value="${pvo.img}">
			<input type="hidden" name="price" value="${pvo.price}">
			<input type="hidden" name="qty" id="pQty">
			<input type="hidden" name="subPrice">
			<div class="row  u_article">
				<div class="col-md-6 all_center">
					<img src="${pvo.img}"style="width:25em;height:25em"/>
				</div>

				<div class="col-md-6">
					<div class="row">
						<span class="col-md-6 h3">NAME</span>
						<span class="col-md-6 h3">${pvo.name}</span>
					</div>
					<div class="row">
						<span class="col-md-6 h3">PRICE</span>
						<span class="col-md-6 h3">$${pvo.price}</span>
					</div>
					<div class="row">
						<span class="col-md-6 h3">QUANTITY</span>
						<span class="col-md-6 h3">
							<button type="button" id="minus" class="btn btn-default btn-sm" onClick="decrease()">-</button>
								<b class="qty">1</b>
							<button type="button" id="plus" class="btn btn-default btn-sm" onClick="increase()">+</button>
						</span>
					</div>
					<div class="row">
						<span class="col-md-6 h3">TOTAL PRICE</span>
						<span class="col-md-6 h3">$<b id="total"></b></span>
					</div>
					<c:choose>
						<c:when test="${pvo.category eq 'SingleOrigins' || pvo.category eq 'Blends' ||pvo.category eq 'Decafs' ||pvo.category eq 'Light' ||pvo.category eq 'Medium' ||pvo.category eq 'Dark' ||pvo.category eq 'ColdBrew'}">
							<div class="row">
								<span class="col-md-6 h3">SIZE</span>
								<div class="col-md-6">
									<select name="sz" class="form-control" onChange="selectEvent(this)">
									  <option value="0.5kg" selected>0.5kg</option>
									  <option value="1kg">1kg</option>
									  <option value="1.5kg">1.5kg</option>
									  <option value="2kg">2kg</option>
									</select>
								</div>
							</div>
							<div class="row">
								<span class="col-md-6 h3">TYPE</span>
								<div class="col-md-6">
									<select name="type" class="form-control">
									  <option value="Whole bean">Whole bean</option>
									  <option value="Drip">Drip</option>
									  <option value="Espresso">Espresso</option>
									</select>
								</div>
							</div>
						</c:when>
					</c:choose>
					<br/>
					<div class="row hor_center h_nav">
						<a href="#" id="buy"><i class="h3">TO CART</i></a>
					</div>
				</div>
			</div>
		</form>			
		<div class="row">
			<hr>
				<p style="padding:2em">${pvo.content}</p>
			<hr>
		</div>
<!-- 			review section			 -->
		<div class="row u_title" style="margin-left:2em"><h3>Customer Review</h3></div>
		<div class="u_article">
		<c:choose>
		<c:when test="${login == null }">
			<div class="row h_nav" style="margin-left:2em">
				<span>Please <a href="#loginModal" data-toggle="modal">login</a> to review this product.</span>
			</div>
		</c:when>
		<c:otherwise>
			<div class="row jumbotron">
				<c:set var="name" value="${login.lname} ${login.fname}"/>
				<form action="/product/review/post" method="post" name="reviewPost">
					<input type="hidden" name="productId" value="${pvo.id}"/>
					<input type="hidden" name="email" value="${login.email}"/>
					<input type="hidden" name="name" value="${name}"/>
					
					<div>
						<h4><span><b>POST REVIEW</b></span></h4>
					</div>
					<div class="form-group">
						<label for="reviewContent" class="control-label">CONTENT</label>
						<textarea name="content" id="reviewContent" class="form-control" cols="30" rows="3"></textarea>
					</div>
					<div class="star-input">
						<span class="input">
					    	<input type="radio" name="grade" id="p1" value="one"><label for="p1">0.5</label>
						    <input type="radio" name="grade" id="p2" value="two"><label for="p2">1</label>
						    <input type="radio" name="grade" id="p3" value="three"><label for="p3">1.5</label>
						    <input type="radio" name="grade" id="p4" value="four"><label for="p4">2</label>
						    <input type="radio" name="grade" id="p5" value="five"><label for="p5">2.5</label>
						    <input type="radio" name="grade" id="p6" value="six"><label for="p6">3</label>
						    <input type="radio" name="grade" id="p7" value="seven"><label for="p7">3.5</label>
						    <input type="radio" name="grade" id="p8" value="eight"><label for="p8">4</label>
						    <input type="radio" name="grade" id="p9" value="nine"><label for="p9">4.5</label>
						    <input type="radio" name="grade" id="p10" value="ten"><label for="p10">5</label>
						</span>
						<output for="star-input" style="margin-top:-8px;"></output>
					</div>
					<div class="hor_center">
						<input type="submit" class="btn btn-default" value="POST"/>
					</div>
<!-- 					 -->
				</form>
			</div>
		</c:otherwise>
		</c:choose>
		<hr>
		<div id="reviewDiv" style="margin:5em">
		
		</div>
		<div class='text-center'>
			<ul id="pagination" class="pagination pagination-sm no-margin "></ul>
		</div>
	</div>
	<div id="isCartModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title text-center">CART</h3>
				</div>
				<div class="modal-body">
					<div class="hor_center" style="margin:5em">
						<div><h4>WANT TO SEE PRODUCTS IN CART?</h4></div>
					</div>
				</div>
				<div class="modal-footer">
					<div><a href="/user/cart" class="btn btn-default btn-lg">GO</a></div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div><span class="cart"></span></div>
</body>

<script id="reviewTemplate" type="text/x-handlebars-template">
		{{#each .}}
	         <div class="row reviewLi">
    			<div>
    	    		<span>{{name}}</span>&nbsp;&nbsp;&nbsp;<div class='star-rating'><span id={{grade}}></span></div>
					<span>{{grade}}</span>
    			</div>
    			<div class="hor_right removeBtn" data-rid={{id}}>
        			{{#eqReviewer email}}
        			<a href="#" class="delReviewBtn"><span class="glyphicon glyphicon-remove"></span></a>
        			{{/eqReviewer}}
    			</div>
    			<div>{{content}}</div>
    			<div class="hor_right">
        			<span>{{prettifyDate date}}</span>
    			</div>
				<hr />
			</div>
        {{/each}}
</script>  

<script type="text/javascript">
	var p_price = $('input[name="price"]').val();
	var qty=1;
	var total=0;
	var type=1;
	
	function calPrice(){
		total = p_price*qty*type;
		$('#total').text(total.toFixed(2));
	}
	function increase(){
		if(qty>100){
			qty=100;
			alert("the maximum of qty is 100");
		}
		qty++;
		$('b.qty').text(qty);
		calPrice();
	}
	function decrease(){
		qty--;
		if(qty<1) qty=1;
		$('b.qty').text(qty);
		calPrice();
	}
	function selectEvent(selectObj) {
	    if(selectObj.value == "0.5kg"){
	    	type=1;
	    }else if(selectObj.value == "1kg"){
	    	type=2;
	    }else if(selectObj.value == "1.5kg"){
	    	type=3;
	    }else{
	    	type=4;
	    }
	    calPrice();
	}
	
	$('#buy').on("click", function(event){
		event.preventDefault();
		$('input[name="qty"]').val(qty);
		$('input[name="subPrice"]').val(total);
		
		var form = $('form[name="tocart"]');
		var data = form_to_json(form);
		
		$.ajax({
			type:'POST',
			url: '/user/tocart',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dateType: 'json',
			data: JSON.stringify(data),
			success : function(result){
				if(result == "Success"){
					$('#isCartModal').modal();
				}else if(result == "Fail"){
					
				}
			}
			,
		 	error: function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});
	});

	$(document).ready(function(){
		calPrice();
		
		var pid = ${pvo.id};
		var reviewPage = 1;
		
		Handlebars.registerHelper("eqReviewer", function(reviewer, block) {
			var accum = '';
			if (reviewer == '${login.email}') {
				accum += block.fn();
			}
			return accum;
		});

		Handlebars.registerHelper("prettifyDate", function(timeValue) {
			var dateObj = new Date(timeValue);
			var year = dateObj.getFullYear();
			var month = dateObj.getMonth() + 1;
			var date = dateObj.getDate();
			return year + "/" + month + "/" + date;
		});
		
		var printData = function(reviewList, target, templateObject) {

			var template = Handlebars.compile(templateObject.html());
			var html = template(reviewList);
			// $(".reviewLi").remove();
			target.append(html);
		}

		function printPaging(pageMaker, target) {

			var str = "";
			if (pageMaker.prev) {
				str += "<li><a href='" + (pageMaker.startPage - 1)
						+ "'> < </a></li>";
			}

			for (var i = pageMaker.startPage ; i <= pageMaker.endPage; i++) {
				var strClass = pageMaker.cri.page == i ? 'class=active' : '';
				str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
			}

			if (pageMaker.next) {
				str += "<li><a href='" + (pageMaker.endPage + 1)
						+ "'> > </a></li>";
			}
			target.html(str);
		};

		function getPage(url) {
			$.getJSON(url, function(data) {
				printData(data.list, $("#reviewDiv"), $('#reviewTemplate'));
				printPaging(data.pmk, $(".pagination"));
			});
		}
		
		getPage("/product/review/list/" + pid + "/1");
		
		$(".pagination").on("click", "li a", function(event) {
			event.preventDefault();
			reviewPage = $(this).attr("href");
			getPage("/product/review/list/" + pid + "/" + reviewPage);
		});
		
		$('#reviewDiv').on('click', '.delReviewBtn',function(event) {
			event.preventDefault();
			
			var rid = $(this).closest(".removeBtn").attr("data-rid");
			
			$.ajax({
				type : 'delete',
				url : '/product/review/delete/' + rid,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(result) {
					console.log("result: " + result);
					if (result == 'Success') {
						alert("삭제 되었습니다.");
						getPage("/product/review/list/" + pid + "/" + reviewPage);
					}
				},
				error: function(request,status,error){
	    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	    }
			});
		});
		
		$('form[name="reviewPost"]').validate({
		    rules: {
		    	email: { required: true },
		    	grade: { required: true },
		    	content: { required: true}
		    },
		    messages: {
		    	email:{ required:"note that you're not logged in." },
		    	grade: { required: "validate this product" },
		    	content: { required: "REQUIRED"}
		    },
		    submitHandler: function (form, event) {
		    	event.preventDefault();
		    	
		    	var data = form_to_json(form);
		    	
				$.ajax({
					type : 'post',
					url : '/product/review/post',
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					dataType : 'text',
					data : JSON.stringify(data),
					success : function(result) {
						console.log("result: " + result);
						if (result == 'Success') {
							
							getPage("/product/review/list/" + pid + "/" + reviewPage);
						}
					},
					error: function(request,status,error){
		    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    	    }
				});
		    }
		});
	})
	</script>
</html>