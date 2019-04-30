<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/static/css/common.css"/>
	<script src="/static/js/jquery-3.4.0.min.js"></script>
</head>
<body>
	<div class="cssdv">
		<c:choose>
			<c:when test="${item ne null }">
				<p>제목 : ${item.subject }</p>
				<p>아이디 : ${item.id }</p>
				<p>등록일 : ${item.rDate }</p>
				<p>조회수 : ${item.vCnt }</p>
				<div id="contentdv">
						${item.content }
				</div>
			</c:when>
			<c:otherwise>
				<h1>선택한 게시물을 조회할 수 없습니다.</h1>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>