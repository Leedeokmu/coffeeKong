<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="basePath" value="${pageContext.request.contextPath }"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WELCOME TO COFFEE KONG.</title>
</head>
<c:choose>
	<c:when test="${content == null || content == '' }">
		<c:set var="content" value="./index_init.jsp"/>
	</c:when>
	<c:when test="${content.equals('intro')}">
		<c:set var="content" value="./information/intro.jsp"/>
	</c:when>
	<c:when test="${content.equals('location')}">
		<c:set var="content" value="./information/location.jsp"/>
	</c:when>
	<c:when test="${content.equals('contact')}">
		<c:set var="content" value="./information/contact.jsp"/>
	</c:when>

	<c:when test="${content.equals('user-list')}">
		<c:set var="content" value="./user/list.jsp"/>
	</c:when>
	<c:when test="${content.equals('user-detail')}">
		<c:set var="content" value="./user/detail.jsp"/>
	</c:when>
	<c:when test="${content.equals('user-update')}">
		<c:set var="content" value="./user/update.jsp"/>
	</c:when>
	<c:when test="${content.equals('user-addc')}">
		<c:set var="content" value="./user/add.jsp"/>
	</c:when>
	<c:otherwise>
		<c:set var="content" value="./index_init.jsp"/>
	</c:otherwise>
</c:choose>
<body>
	<div>
	<!-- header start-->
		<div id="header">
			<jsp:include page="./header.jsp"/>
		</div>
	<!-- header end-->
	<!-- content start -->
		<div id="content">
			<jsp:include page="${content}"/>
		</div>
	<!-- content end -->
	<!-- footer start -->
		<div id="footer">
			<jsp:include page="./footer.jsp"/>
		</div>
	<!-- footer start -->
	</div>
</body>
</html>