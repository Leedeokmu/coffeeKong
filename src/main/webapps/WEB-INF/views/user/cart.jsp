<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<body>
	<div class="a_title text-center"><h2>PRODUCTS IN YOUR CART</h2></div><br />
	<div class="container a_article">
	<c:choose>
		<c:when test="${fn:length(cart) > 0 }">
		<c:forEach var="cvo" items="${cart}" varStatus="index" begin="0" step="1">
			<form action="/user/cart/update" role="form" name="tocart<c:out value="${index.count }"/>" method="post">
				<input type="hidden" name="c_num" value="${cvo.c_num }"/>
				<input type="hidden" name="sub_price" />
				<input type="hidden" name="qty" />
				
				<div class="hor_center">
					<div class="row hor_center" style="width:40em">
						<div class="col-md-5" style="padding:0px">
							<img src="${cvo.p_img }" alt="img" style="width:150px;height:150px"/>
						</div>
						<div class="col-md-7" >
							<div class="row">
								<span class="col-md-6">NAME</span>
								<span class="col-md-6">${cvo.p_name }</span>
							</div>
							<c:choose>
								<c:when test="${cvo.p_category eq 'SingleOrigins' || cvo.p_category eq 'Blends' ||cvo.p_category eq 'Decafs' ||cvo.p_category eq 'Light' ||cvo.p_category eq 'Medium' ||cvo.p_category eq 'Dark' ||cvo.p_category eq 'ColdBrew'}">
								<div class="row">
									<span class="col-md-6">TYPE</span>
									<span class="col-md-6 form-group-sm ver_center">
										<select name="type" class="form-control" id="type<c:out value="${index.count }"/>">
											<option value="Whole bean" <c:out value="${cvo.type eq 'Whole bean'? 'selected' : ''}"/>>Whole bean</option>
											<option value="Drip" <c:out value="${cvo.type eq 'Drip'? 'selected' : ''}"/>>Drip</option>
											<option value="Espresso" <c:out value="${cvo.type eq 'Espresso'? 'selected' : ''}"/>>Espresso</option>
										</select>
									</span>
								</div>
								<div class="row">
									<span class="col-md-6">SIZE</span>
									<span class="col-md-6 form-group-sm ver_center">
										<select name="sz" class="form-control" onChange="defSz(this)" id="sz<c:out value="${index.count }"/>">
											<option value="0.5kg" <c:out value="${cvo.sz eq '0.5kg'? 'selected' : ''}"/>>0.5kg</option>
											<option value="1kg" <c:out value="${cvo.sz eq '1kg'? 'selected' : ''}"/>>1kg</option>
											<option value="1.5kg" <c:out value="${cvo.sz eq '1.5kg'? 'selected' : ''}"/>>1.5kg</option>
											<option value="2kg" <c:out value="${cvo.sz eq '2kg'? 'selected' : ''}"/>>2kg</option>
										</select>
									</span>
								</div>
								</c:when>
							</c:choose>
							<div class="row">
								<span class="col-sm-6">QUNETITY</span>
								<span class="col-sm-6"><button type="button" id="minus" class="btn btn-default btn-xs" onClick="decrease(this)">-</button>
									&nbsp;<span id="qty<c:out value="${index.count }"/>">${cvo.qty}</span>&nbsp;
								<button type="button" class="btn btn-default btn-xs" id="plus" onClick="increase(this)">+</button></span>
							</div>
							<div class="row">
								<span class="col-md-6">PRICE</span>
								<span class="col-md-6">$<strong id="price<c:out value="${index.count }"/>">${cvo.p_price }</strong></span>
							</div>
							<div class="row">
								<span class="col-md-6">SUB PRICE</span>
								<span class="col-md-6">$<strong class="subprice" id="subprice<c:out value="${index.count }"/>">${cvo.sub_price }</strong></span>
							</div>
							<div class="row hor_center" style="margin-top:2em">
								<input type="submit" value="UPDATE CART" class="btn btn-default btn-sm col-md-6 tocart" id="btn<c:out value="${index.count }"/>"/>
							</div>
						</div>
					</div>
				</div>
				
				
				<hr />
			</form>
		</c:forEach>
		<div >
			<div class="hor_right"><h2 id="totalPrice"></h2></div>
			<div class="hor_center"><a href="/order" class="btn btn-success btn-lg">CHECKOUT</a></div>
		</div>
		</c:when>
		<c:otherwise>
			<div class="text-center h_nav">
				<h2>YOUR CART IS EMPTY</h2><br />
				click <a href="/product/list/Blends">here</a> to navigate products.
			</div>
		</c:otherwise>
	</c:choose>
	</div>
	<script>
	$(document).ready(function(){
		getTotal();
	});
	function getTotal(){
		var totalPrice = 0;
		$('.subprice').each(function(){
			totalPrice += parseFloat($(this).text());
		})
			
		$('#totalPrice').text('Total Price : $'+totalPrice.toFixed(2));	
	}
	function calPrice(id){
		var delim = id.substr(id.length-1);
		var formName = 'tocart'+delim;
		var form = $('form[name="'+formName+'"]');
		
		var price = parseFloat(form.find('#price'+delim).text());
		var qty = parseInt(form.find('#qty'+delim).text());
		var sz = getSz(form.find('#sz'+delim));
		
		var total = price*qty*sz;
		$('#subprice'+delim).text(total.toFixed(2));
		getTotal();
	}
	function increase(obj){
		var qty = $(obj).siblings('span').text();
		if(qty>100){
			qty=100;
			alert("the maximum of qty is 100");
		}
		qty++;
		$(obj).siblings('span').text(qty);
		calPrice($ (obj).siblings('span').attr("id"));
	}
	function decrease(obj){
		var qty = $(obj).siblings('span').text();
		qty--;
		if(qty<1) qty=1;
		$(obj).siblings('span').text(qty);
		calPrice($(obj).siblings('span').attr("id"));
	}
	function getSz(Obj) {
	    if($(Obj).val() == "0.5kg"){
	    	var	sz=1;
	    }else if($(Obj).val() == "1kg"){
	    	var sz=2;
	    }else if($(Obj).val() == "1.5kg"){
	    	var sz=3;
	    }else if($(Obj).val() == "2kg"){
	    	var sz=4;	
	    }else{
	    	var sz=1;
	    }
	    return sz;
	}
	
	function defSz(selectObj) {
	    calPrice($(selectObj).attr("id"));
	}
	
	$('input.tocart').on("click", function(event){
		event.preventDefault();
		
		var num = $(this).attr("id").substr($(this).attr("id").length-1);
		var form = $('form[name="tocart'+num+'"]');
		
		var qty = form.find('#qty'+num).text();
		var subprice = form.find('#subprice'+num).text();
		
		form.find('input[name="qty"]').attr("value",qty);
		form.find('input[name="sub_price"]').attr("value",subprice);
		
    	var data = form_to_json(form);
		
		$.ajax({
    		type:'POST',
    		url: '/user/cart/update',
    		headers : {
    			"Content-Type" : "application/json",
    			"X-HTTP-Method-Override" : "POST"
    		},
    		dateType: 'json',
    		data: JSON.stringify(data),
    		success : function(result){
    			if(result == "Success"){
    				window.location.reload()
    			}else if(result == "Fail"){
    				alert("same product exists");
    			}
    		}
    		,
    	 	error: function(request,status,error){
    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    	    }
    	});
	});	
	</script>
</body>
</html>