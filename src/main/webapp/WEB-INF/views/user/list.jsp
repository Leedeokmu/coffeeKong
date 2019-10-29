<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
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
        <div class="row">
            <table class="table table-responsive table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">id</th>
                        <th class="text-center">email</th>
                        <th class="text-center">first name</th>
                        <th class="text-center">last name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users.content}">
                    <tr>
                        <td class="text-center h_nav"><a href="/users/${user.id}" class="udBtn">${user.id }</a></td>
                        <td class="text-center h_nav"><a href="/users/${user.id}" class="udBtn">${user.email }</a></td>
                        <td class="text-center">${user.fname}</td>
                        <td class="text-center">${user.lname}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
		<div class="row">
            <div class="col-md-2">
                <a href="/users/add" class="btn btn-primary">ADD USER</a>
            </div>
			<c:import url="/WEB-INF/views/common/paging.jsp">
				<c:param name="functionName" value="movePage"/>
				<c:param name="page" value="users.pageable.page"/>
			</c:import>
		</div>
	</div>
</body>
<script>
    const movePage = (pageNo) => {
        let url = '/users?';
        if (pageNo > 0) {
            url += '&page=' + pageNo;
        }
        console.log(url);
        location.href = url;
    }

</script>
</html>
