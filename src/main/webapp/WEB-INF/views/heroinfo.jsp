<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html oncontextmenu="return false">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>heroinfo</title>
	<link rel="shortcut icon" type="image/x-icon" href="/res/img/favicon.ico?v=151218a">
	<link rel="stylesheet" href="/res/css/heroinfo.css">
	<script src="/lib/jquery/3.4.1/dist/jquery.min.js"></script>
	<script src="/res/js/heroinfo.js"></script>
	<script src="/res/js/index.js"></script>
</head>
<body>
	<c:import url="/login" />
	<div id="body">
		<c:import url="/head" />
		<section>
			<c:import url="/stL" />
			<c:import url="/heroinfo2" />
			<c:import url="/stR" />
		</section>
		<c:import url="/footer" />
	</div>
</body>
</html>