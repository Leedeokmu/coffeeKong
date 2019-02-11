<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>COFFEEKONG INC.</title>
</head>
<c:choose>
	<c:when test="${content eq null || param.brew eq ''}">
		<c:set var="brew_content" value="./brew_list.jsp" />
	</c:when>
	<c:when test="${content.equals('french') }">
		<c:set var="brew_content" value="./brew_french.jsp" />
	</c:when>
	<c:when test="${content.equals('clever') }">
		<c:set var="brew_content" value="./brew_clever.jsp" />
	</c:when>
	<c:when test="${content.equals('chemex') }">
		<c:set var="brew_content" value="./brew_chemex.jsp" />
	</c:when>
	<c:otherwise>
		<c:set var="brew_content" value="./brew_list.jsp" />
	</c:otherwise>
</c:choose>
<body>
	<div>
		<div id="header">
			<jsp:include page="../header.jsp"></jsp:include>
		</div>

		<div id="content">
			<jsp:include page="${brew_content }"></jsp:include>
		</div>

		<div id="footer">
			<jsp:include page="../footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>