<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval var="application" expression="@application"/>
<html>
<head>
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
</head>
<body class="external-page external-alt sb-l-c sb-r-c">

<!-- Start: Main -->
<div id="main" class="animated fadeIn">
	<!-- Start: Content-Wrapper -->
	<section id="content_wrapper">

		<!-- Begin: Content -->
		<section id="content">
			<div class="admin-form theme-info mw500" id="login">
				<!-- Login Logo -->
				<div class="row table-layout" style="text-align: center;">
					<a href="/" title="Return to Dashboard">
						<%--<img src="/img/logo.png" title="Bluebird" style="max-width: 275px;">--%>
					</a>
				</div>

				<div class="panel mt30 mb25">
					<form method="post" action="/" id="contact">
						<div class="panel-body bg-light p25 pb15">
							<!-- Social Login Buttons -->
							<div class="section row">
								<div class="col-md-12" style="text-align: center;">
									<h1>잘못된 경로로 접근하셨습니다.</h1>
									<h2 class="text-danger">Access denied!!</h2>
									<hr/>
									<div class="well mbn">Page Not Found</div>
								</div>
							</div>
						</div>

						<div class="panel-footer clearfix">
							<a href="/" class="button btn-primary btn-block">홈으로 이동</a>
							<!-- 								<label class="switch ib switch-primary mt10"> <input type="checkbox" name="remember" id="remember" checked> <label for="remember" data-on="YES" data-off="NO"></label> <span>Remember me</span> -->
							<!-- 								</label> -->
						</div>
					</form>
				</div>
			</div>

		</section>
		<!-- End: Content -->

	</section>
	<!-- End: Content-Wrapper -->

</div>
<!-- End: Main -->

<!-- Page Javascript -->
<script type="text/javascript">
    jQuery(document).ready(function() {
        "use strict";
        // Init Theme Core
        Core.init();

    });
</script>
<!-- END: PAGE SCRIPTS -->
</body>
</html>