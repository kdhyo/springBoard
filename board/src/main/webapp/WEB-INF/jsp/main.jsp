<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>게시판 목록페이지</title>
</head>
<body>
	<h2>게시글 목록</h2>

	<button class="btn btn-primary" onclick="location.href='/insert'">글쓰기</button>

	<div class="container">
		<table class="table table-hover">
			<tr>

				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>생성날짜</th>
				<th>수정날짜</th>
				<th></th>
			</tr>
			<c:forEach var="l" items="${list}">
				<tr>
					<td>${l.id}</td>
					<td onclick="location.href='/detail/${l.id}'">${l.title}</td>
					<td onclick="location.href='/detail/${l.id}'">${l.writer}</td>
					<td onclick="location.href='/detail/${l.id}'"><fmt:formatDate
							pattern="yyyy년 MM월 dd일 HH:mm:ss" value="${l.created_at}" /></td>
							<td onclick="location.href='/detail/${l.id}'"><fmt:formatDate
							pattern="yyyy년 MM월 dd일 HH:mm:ss" value="${l.updated_at}" /></td>
					<td><button class="btn btn-primary"
							onclick="location.href='/update/${l.id}'">수정</button>

						<button class="btn btn-danger"
							onclick="location.href='/delete/${l.id}'">삭제</button></td>

				</tr>
			</c:forEach>

		</table>
	</div>

	<%@ include file="bootstrap.jsp"%>
</body>
</html>