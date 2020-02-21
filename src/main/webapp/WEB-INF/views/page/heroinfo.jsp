<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<body>
<div id="stM">
	<div id="main">
		<h3 id = "title">
			<span id = "title-span"> 오버워치 영웅정보 > </span>
			<a href ="herolist" style="margin:5px 5px;">
				<img src = "/res/img/list_btn_99x24.png">
			</a>
		</h3>
		<div id = "box">
		
				<h5 id = "boxtitle">
				요약정보
				</h5>
				<div id = "box1">
					
					<div id ="box1-top">
						<img src="${InformBean.herorole}" class = "icon1">
						<span class ="job">${InformBean.heroname}</span>
						<img src="/res/img/charIcon_62x62_0.png" class = "icon2">
					</div>
					
					<div id ="box1-mid">
						<div id ="box1-left">
							<img src="${InformBean.img}">
						</div>
						<div id = info1>
							<table id = "table1">
								<colgroup>
									<col style="width:100px;">
									<col>
								</colgroup>
								<tbody>
									<tr class="tr1">
										<td class="td1"colspan="2">${InformBean.inform}</td>
									</tr>
									<tr class="tr1">
										<th class="th1">주요특징</th>
										<td class="td1">${InformBean.feature}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div id = info2>
							<table id = "table2">
								<colgroup>
									<col>
									<col>
									<col>
									<col>
								</colgroup>
								<tbody>
									<tr class="tr1">
										<th class="th1">실명</th>
										<td class="td1">${InformBean.name}</td>
										<th class="th1">나이</th>
										<td class="td1">${InformBean.age}</td>
									</tr>
									<tr class="tr1">
										<th class="th1">직업</th>
										<td class="td1">${InformBean.job}</td>
										<th class="th1">근거지</th>
										<td class="td1">${InformBean.addr}</td>
									</tr>
									<tr class="tr1">
										<th class="th1">소속</th>
										<td class="td1" colspan="3">${InformBean.company}</td>
									
									<tr class="tr1">
										<th class="th1">역할</th>
										<td class="td1">${InformBean.position}</td>
										<th class="th1">생명력</th>
										<td class="td1">${InformBean.hp}</td>
									</tr>
									<tr class="tr1">
										<th class="th1">보호막</th>
										<td class="td1">${InformBean.shield}</td>
										<th class="th1">방어력</th>
										<td class="td1">${InformBean.def}</td>
									</tr>
									<tr class="tr1">
										<th class="th1">기술</th>
										<td class="td1" colspan="3">${InformBean.skillname}</td>
									
								</tbody>
							</table>
						</div>
					</div>
					
				</div>
				
				<h5 id = "boxtitle2">
				기술
				</h5>
				<div id = "box2">
				
					<c:forEach var="row" items="${SkillBeans}">
						<div id = "skill1">
							<img src ="${row.img}" class = "skill1-icon">
							<div id = "box2-top">
							${row.sname}
								<span class = "span">${row.key} 기본공격</span>
							</div>
							<div id = "skill1-text">
								${row.content}
							</div>
							<div id = "skill1-view">
	                        		<a id="a1" href="${row.movie}" target="_black">
	                        			<img src="${row.movieimg}">
	                        		</a>
	                        	</div>
						</div>
					</c:forEach>

				</div>
				<h5 id = "boxtitle3">
				스토리
				</h5>
				<div id = "box3">
					<div id = "box3-stroy">
						<div id = box3-text>
							 ${InformBean.story}
						</div>
					</div>
				</div>					
		</div>
		<div id ="cmtwrap">
		<div id = "cmtHedaer">
		</div>
			<div id ="cmtBody">
			
				<h4 id ="cmtTitle">나도 한마디</h4>
				<p class ="cmtNum" id ="cmtNums">
				코멘트("
				<em>${fn:length(CommentBeans)}</em>
				")
				</p>
				<table class = "cmtList" border="0" cellpadding="0" cellspacing="0">
					<thead>
					</thead>
					<tbody id ="cmtItemList">
						
					<c:forEach var="row" items="${CommentBeans}">
						<tr id ="cmtitem1">
							<td class="column1">
								<span class="colWrap">
									<span class="author">
										<span style>${row.id}</span>
									</span>
								</span>
							</td>
							<td class="column2">
								<span class="colwrap">
									<span class="comment">${row.content}</span>
								</span>
							</td>
							<td class="column3">
								<span class="colwrap">
									<span id="date">${row.date}</span>
								</span>
							</td>
						</tr>
					</c:forEach>
					
<!-- 						<tr id ="cmtitem1"> -->
<!-- 							<td class="column1"> -->
<!-- 								<span class="colwrap"> -->
<!-- 									<span class="author"> -->
<!-- 										<span style>려화민</span> -->
<!-- 									</span> -->
<!-- 								</span> -->
<!-- 							</td> -->
<!-- 							<td class="column2"> -->
<!-- 								<span class="colWrap"> -->
<!-- 									<span class="comment">이번년도 크리스마스 7일남음</span> -->
<!-- 								</span> -->
<!-- 							</td> -->
<!-- 						</tr> -->
						<c:if test="${sessionScope.UserInfo ne null}">
						<tr id="cmtform" class="form">
							<td id="cmtformTD" colspan="2" class>
								<div id ="cmtReplayForm">
									<form id="fmCmtForm" name="fmCmtForm" onsubmit="return false;" class="norecom">
										<textarea id="textbox"  placeholder="
<!-- 	명예훼손, 개인정보 유출, 분쟁 유발, 허위사실 유포 등의 글은 이용약관에 의해 제재는 -->
<!-- 	물론 법률에 의해 처벌받을 수 있습니다. 건전한 커뮤니티를 위해 자제를 당부 드립니다."></textarea>
										<button id="btn" href="">등록</button>
	 								</form>
								</div>
							</td>
						</tr>
						</c:if>
						<c:if test="${sessionScope.UserInfo eq null}">
						<tr id="cmtform" class="form">
							<td id="cmtformTD" colspan="2" class>
								<div id ="cmtReplayForm">
									<form id="fmCmtForm" name="fmCmtForm" onsubmit="return false;" class="norecom">
										<textarea onclick="location.href='/logindiv'" id="textbox"  placeholder="로그인 필요" readonly="readonly"></textarea>
										<button id="btn" disabled="disabled">등록</button>
	 								</form>
								</div>
							</td>
						</tr>
						</c:if>
						
					</tbody>
				</table>  
			</div>
<!-- 			<div id="cmtpg"> -->
<!-- 				<span class="basetext"> -->
<!-- 					<span class="ar1">이전</span> -->
<!-- 					<span class="ar2">1</span>  -->
<!-- 					<span class="ar3">다음</span> -->
<!-- 				</span> -->
<!-- 			</div> -->
<!-- 			<div id="cmtnotes"></div> -->
<!-- 			<div id="cmtfooter"></div> -->
<!-- 			<div id="cmtbtn" style="display: none;"> -->
			</div>
	</div>
</div>
</body>
</html>