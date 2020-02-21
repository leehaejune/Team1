<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<dt>최근
		<span style="color:#9ce5ff;">작성</span>
		 된 공략
	</dt>
	<dd>
		<div class = "row" id = "boardList">
			<c:forEach var="row" items="${result.result}">
				<ul>
					<li><span>[${row.heroname}]</span><a href="/board/${row.no}">${row.title}</a></li>
				</ul>
			</c:forEach>
		</div>
	</dd>
</body>
</html>

