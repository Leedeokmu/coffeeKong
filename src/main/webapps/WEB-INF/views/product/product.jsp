<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG.</title>
</head>
<c:set var="basePath" value="${pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${content ==null || param.content == ''}">
		<c:set var="content" value="/content.jsp" />
	</c:when>
	<c:when test="${content.equals('list') }">
		<c:set var="content" value="./pList.jsp" />
	</c:when>
	<c:when test="${content.equals('detail') }">
		<c:set var="content" value="./pDetail.jsp" />
	</c:when>	
	<c:when test="${content.equals('review') }">
		<c:set var="content" value="./review.jsp" />
	</c:when>
</c:choose>
<body>

<div id="container">
<!-- header start-->
	<div id="header"><jsp:include page="../header.jsp"/></div>
<!-- header end-->

<!-- content start -->
	<div id="content"><jsp:include page="${content }"/></div>
<!-- content start -->

<!-- footer start -->
	<div id="footer"><jsp:include page="../footer.jsp"/></div>
<!-- footer start -->
</div>
</body>
</html>