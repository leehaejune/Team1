<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<dt>최근
		<span style="color:#9ce5ff;">댓글이 달린</span>
		공략
	</dt>
	<dd>
		<div class="row2" id ="boardList2">
			<c:forEach var="row2" items="${result.result2}">
				<ul>
					<li><span>[${row2.heroname}]</span><a href="/board/${row2.no}">${row2.title}</a></li>
				</ul>
			</c:forEach>
		</div>
	</dd>
</body>
</html>