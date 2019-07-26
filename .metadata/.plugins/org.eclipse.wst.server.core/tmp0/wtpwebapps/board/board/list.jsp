<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 페이지</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
	</tr>
<!-- 	var="변수" items="컬럼명" -->
	<c:forEach var="board" items="${boards}">
		<tr>
			<td>${board.num}</td>
			<td><a href="/board/router?cmd=view&num=${board.num}">${board.title}</a></td>
			<td>${board.username}</td>
		</tr>
	</c:forEach>
</table>
<a href="/board/router?cmd=write">글쓰기</a>
</body>
</html>