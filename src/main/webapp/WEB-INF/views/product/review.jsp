<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<c:set var="vo" value="${aProduct}"/>
<body>
	<form method="POST" action="rSaveCtrl" name="rForm" enctype="multipart/form-data">
		<input type="hidden" name="pId" value="${vo.pId}">
		<input type="hidden" name="gId" value="${id}">
		<div class="container">
			<div>
				<hr><h3>Write Your Review</h3><hr>
			</div>
			<div>
				<div style="float:left;">ID:&nbsp;</div><div>${id}</div>
			</div>
			<div>
				<br><div style="float:left;">Product:&nbsp;</div><div>${vo.pName }</div>
			</div>
			<div>
			<br>
				Grademark:&nbsp;
				<span class="star-input">
				  <span class="input">
					<input type="radio" name="star-input" id="p1" value="one"><label for="p1">0.5</label>
					<input type="radio" name="star-input" id="p2" value="two"><label for="p2">1</label>
					<input type="radio" name="star-input" id="p3" value="three"><label for="p3">1.5</label>
					<input type="radio" name="star-input" id="p4" value="four"><label for="p4">2</label>
					<input type="radio" name="star-input" id="p5" value="five"><label for="p5">2.5</label>
					<input type="radio" name="star-input" id="p6" value="six"><label for="p6">3</label>
					<input type="radio" name="star-input" id="p7" value="seven"><label for="p7">3.5</label>
					<input type="radio" name="star-input" id="p8" value="eight"><label for="p8">4</label>
					<input type="radio" name="star-input" id="p9" value="nine"><label for="p9">4.5</label>
					<input type="radio" name="star-input" id="p10" value="ten"><label for="p10">5</label>
				  </span>
				  <output for="star-input" style="margin-top:-8px;"><b>0</b>점</output>
				</span>
			</div>
			<div>
				<br><textarea name="iContent" rows="15px" cols="100px"></textarea>
			</div>
			<div>
				<div>
					<div style="float:left;">Image 1:&nbsp; </div>
					<div><input type="file" name="iFile1"/></div>
				</div>
				<div>
					<div style="float:left;">Image 2:&nbsp; </div>
					<div><input type="file" name="iFile2"/></div>
				</div>
				<div>
					<div style="float:left;">Image 3:&nbsp; </div>
					<div><input type="file" name="iFile3"/></div>
				</div>
			</div>
			<div>
				<hr>
				<div style="margin-left:530px;">
				<input type="submit" value="Submit">&nbsp;&nbsp;
				<input type="reset" value="Reset">&nbsp;&nbsp;
				<a href="javascript:history.go(-1)">[back]</a>
			</div>
				<hr>
			</div>
		</div>
	</form>

	<script src="http://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
	<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
<script>
var starRating = function(){
	  var $star = $(".star-input"),
	      $result = $star.find("output>b");
	  $(document).on("focusin", ".star-input>.input", function(){
	    $(this).addClass("focus");
	  }).on("focusout", ".star-input>.input", function(){
	    var $this = $(this);
	    setTimeout(function(){
	      if($this.find(":focus").length === 0){
	        $this.removeClass("focus");
	      }
	    }, 100);
	  })
	    .on("change", ".star-input :radio", function(){
	    $result.text($(this).next().text());
	  })
	    .on("mouseover", ".star-input label", function(){
	    $result.text($(this).text());
	  })
	    .on("mouseleave", ".star-input>.input", function(){
	    var $checked = $star.find(":checked");
	    if($checked.length === 0){
	      $result.text("0");
	    } else {
	      $result.text($checked.next().text());
	    }
	  });
	};
	starRating();
</script>
</html>