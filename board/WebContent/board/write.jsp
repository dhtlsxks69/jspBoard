<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
</head>
<body>
<form action="/board/router?cmd=writeProc" method="POST">
	글쓴이 : <input type="text" name="username" /> <br />
	제목 : <input type="text" name="title" /> <br />
	내용 : <textarea rows="5" cols="30" name="content"></textarea> <br />
	<input type="submit" value="글쓰기 완료" />
</form>
</body>
</html>