<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
<c:forEach var="results" items="${result1.HeroList}">
<ul class="vote_result_list_row">
	<li class="vote_result_list_col_1"></li>
<!-- 	<li class="vote_result_list_col_1">1</li> -->
	<li class="vote_result_list_col_2">
<!-- 		<img id="vote_result_list_col_2_picture" class="col_2_here_picture"> -->
<!-- 		<img id="vote_result_list_col_2_picture" class="col_2_here_picture" src="http://192.168.3.231/img/char/Ana.png"> -->
		<img id="vote_result_list_col_2_picture" class="col_2_here_picture" src="">
	</li>
	<li class="vote_result_list_col_3">${results.cnhero}</li>
	<c:set var="voteno1" value="${results.voteno1}"/>
	<c:set var="voteno2" value="${results.voteno2}"/>
	<c:set var="voteno3" value="${results.voteno3}"/>
	<c:set var="sumVoteno" value="${voteno1 + voteno2 + voteno3}"/>
	<li id="vote_result_list_col_4" class="vote_result_list_col_4" value="${sumVoteno}">${sumVoteno}</li>
	<li class="vote_result_list_col_5">
		<div class="graph">
			<div class="graph_strong">
				<ul>
					<li class="graph_strong_persent">우세</li>
					<li id="graph_strong_persent" class="graph_strong_persent">${results.voteno1}</li>
<!-- 					<li class="graph_strong_persent">(41%)</li> -->
				</ul>
			</div>
			<div class="graph_same">
				<ul>
					<li class="graph_same_persent">동등</li>
					<li id="graph_same_persent" class="graph_same_persent">${results.voteno2}</li>
<!-- 					<li class="graph_same_persent">(23%)</li> -->
				</ul>
			</div>
			<div class="graph_weak">
				<ul>
					<li class="graph_weak_persent">약세</li>
					<li id="graph_weak_persent" class="graph_weak_persent">${results.voteno3}</li>
<!-- 					<li class="graph_weak_persent">(36%)</li> -->
				</ul>
			</div>
		</div>
	</li>
	<li class="vote_result_list_col_6"></li>
<!-- 	<li class="vote_result_list_col_6">복합적!</li> -->
</ul>
</c:forEach>
</body>
</html>