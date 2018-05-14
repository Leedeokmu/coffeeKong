<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<c:set var="basePath" value="${pageContext.request.contextPath }"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BREW LIST</title>
</head>

<body>
	<div class="text-center a_title"><span><h2>COFFEE BREW GUIDES</h2></span></div><br />
	<div class="container a_article">
		<div>
			<div class="text-center"><h3>FRENCH BREW GUIDE</h3></div>
			<div class="hor_center"><img src="/resources/dist/img/french_brew.jpg" alt="brew_french" style="width:70%;height:70%"/></div>
			<div class="hor_center"><p style="width:70%">The French Press is the most recognizable way to brew coffee at home. Fans of the French Press love it for its classic design, fail-proof brewing, and consistently delicious results. Brewing amazing coffee at home doesn’t get any easier than this.</p></div>
			<div class="h_nav hor_center"><a href="/learn/french">SEE FULL ARTICLE</a></div><br />
		</div>
		<div>
			<div class="text-center"><h3>CLEVER DRIPPER BREW GUIDE</h3></div>
			<div class="hor_center"><img src="/resources/dist/img/clever_brew.jpg" alt="brew_clever" style="width:70%;height:70%"/></div>
			<div class="hor_center"><p style="width:70%">The Clever Coffee Dripper is one of our favorite brewers because it is one of the most accessible ways to make great coffee at home. This brewer requires very little technique, brews quickly, is easy to clean and produces an incredibly consistent cup. The Clever is designed to highlight the best aspects of both full immersion brewing and paper filtered pourovers. It produces the full, round body of full immersion brewing, similar to French Press, but has more flavor clarity and is much easier to clean. Hands down, the easiest way to brew better coffee at home.</p></div>
			<div class="h_nav hor_center"><a href="/learn/clever">SEE FULL ARTICLE</a></div><br />
		</div>
		<div>
			<div class="text-center"><h3>CHEMEX BREW GUIDE</h3></div>
			<div class="hor_center" ><img src="/resources/dist/img/chemex_brew.jpg" alt="brew_chemex" style="width:70%;height:70%"/></div>
			<div class="hor_center"><p style="width:70%">Designed by a German chemist in 1941, the Chemex is one of our favorite ways to make coffee. It's beautiful and distinct hourglass shape make it one of most beautiful brewers out there, but that’s not the only reason to love it. Our favorite feature is the thick, triple-layered paper filter that accentuates the clarity of the cup, enhancing brightness and nuance, while eliminating any body that could get in its way. Perhaps the cleanest cup coffee, it’s hard to beat this classic brewer.</p></div>
			<div class="h_nav hor_center"><a href="/learn/chemex">SEE FULL ARTICLE</a></div><br />
		</div>
	</div>
</body>
</html>