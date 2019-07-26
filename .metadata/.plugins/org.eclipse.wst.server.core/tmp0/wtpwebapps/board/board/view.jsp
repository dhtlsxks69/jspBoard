<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기 페이지</title>
</head>
<body>
<a href="/board/router?cmd=update&num=${board.num}">수정</a>
<a href="/board/router?cmd=delete&num=${board.num}">삭제</a>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
	</tr>
		<tr>
			<td>${board.num}</td>
			<td>${board.title}</td>
			<td>${board.username}</td>
			<td>${board.content}</td>
		</tr>
</table>
댓글 쓰기 : <input type="text" name="content" id="content"/>
<input type="button" onclick="send()" value="댓글전송" />
<div id="reply">
	<c:forEach var="reply" items="${replys}">
		<div>작성자 : ${reply.username} 내용 : ${reply.content}</div>
	</c:forEach>
</div>
<!-- 자바스크립트는 무조건 맨 밑에 있어야 함 -->
<script>
	function send(){
		var temp = document.querySelector("#content");
		var content = document.querySelector("#content").value;
		var reply = {
				username: "ssar",
				content: content,
				boardId: "${board.num}"
		}
		
		//전송
		fetch("http://localhost:8080/board/reply",{
			method: "POST",
			body: JSON.stringify(reply),
			headers: {
				"Content-type" : "application/json; charset=UTF-8"
			}
		})
		.then(function(data){
			return data.text();
		})
		.then(function(data){
			if(data === 'success'){
				temp.value = '';
				var reply_div = document.querySelector("#reply");
				var newDiv = document.createElement("div");
				newDiv.innerHTML = "작성자 : "+reply.username+" 내용 : "+reply.content;
				reply_div.prepend(newDiv);
			}else{
				alert("댓글쓰기에 실패하였습니다.");
			}
		})
	}
</script>
</body>
</html>