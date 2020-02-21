<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
	<c:forEach var="result1" items="${result.HeroList}">
	<div class = "herobox_heroname" data-hno="${result1.no}">
		<a href="#listbox_top" id="${result1.heroname_english}" class="herobox_hero">
			<img class="herobox_heropicture" src ="${result1.heroimg}">
		</a>
		<span class="herobox_heroname_name" data-hname="${result1.heroname}">${result1.heroname}</span>
	</div>
	</c:forEach>
</body>
</html>