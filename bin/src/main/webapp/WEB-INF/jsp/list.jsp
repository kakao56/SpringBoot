<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/static/css/common.css"/>
	<script src="/static/js/jquery-3.4.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
			var p_searchType = $("#p_searchType").val();
			
			$("select[name=searchType] option").each(function(idx, i_item) {
				
				if(p_searchType ==  $(this).val()){
					$(this).prop("selected",true);
				}
			});
			
			$("#searchbtn").click(function() {
				console.log($("select[name=searchType]").val());
				if($("select[name=searchType]").val() == "전체"){
					$("input[name=searchValue]").val("");
				}
				
				$("#searchfrm").attr("action","list").attr("method","get").submit();
			});
		});
		
		function goPage(pg){
			$("input[name=nowPage]").val(pg);
			$("#searchbtn").click();
		}
	</script>
</head>
<body>
	<div id="cssdv" class="cssdv">
		<div id="searchdv">
			<form id="searchfrm">
				<select name="searchType">
					<option value="전체">전체</option>
					<option value="제목">제목</option>
					<option value="아이디">아이디</option>
					<option value="내용">내용</option>
				</select>
				<input type="text" name="searchValue" value="${searchValue }">
				<input type="button" id="searchbtn"  value="검색">
				<input type="hidden" name="nowPage">
			</form>
				<input type="hidden" id="p_searchType" value="${searchType }">
		</div>
		</p>
		<div id="listdv">
			<table border="1">
				<colgroup>
					<col width="50px;">
					<col width="100px;">
					<col width="250px;">
					<col width="100px;">
					<col width="100px;">
					<col width="100px;">
					<col>
				</colgroup>
				<thead align="center" valign="middle">
					<tr>
						<th>삭제</th>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody align="center" valign="middle">
					<c:choose>
						<c:when test="${list ne null }">
							<c:forEach items="${list }" var="item">
								<tr>
									<td><input type="checkbox" name="delchk" value="${item.seq }"> </td>
									<td><label>${item.seq }</label> </td>
									<td><a href="detail/?seq=${item.seq }">${item.subject } </a> </td>
									<td>${item.id } </td>
									<td>${item.rDate } </td>
									<td>${item.vCnt }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
						<tr>
							<td colspan="6">
								검색된 게시물이 없습니다.
							</td>
						</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			${pageCode }
		</div>
	</div>
</body>
</html>