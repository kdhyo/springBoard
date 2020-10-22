<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="bootstrap.jsp"%>
<script>
	$(document).ready(function() {
		//정규식을 이용한 url 매개변수 명을 parameter 변수 명으로 받아서 저장.
		$.urlParam = function(name){
		    var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
		    return results[1] || 0;
		}
		$.ajax('/detail/'+$.urlParam('id'), {
			success : function(data) {
				console.log(data);
				$("#title").append(data.title);
				$("#writer").append(data.writer);
				$("#contents").append(data.contents);
				$("#created_at").append(data.created_at);
			}
		})
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail</title>
</head>
<body>


	<h2>게시글 상세</h2>

	<div class="container">
		<div class="form-group">
			<label>제목</label>
			<p id="title"></p>
		</div>
		<div class="form-group">
			<label>작성자</label>
			<p id="writer"></p>
		</div>
		<div class="form-group">
			<label>내용</label>
			<p id="contents"></p>
		</div>
		<div class="form-group">
			<label>작성날짜</label>
			<p id="created_at"></p>
		</div>
		<button class="btn btn-primary" onclick="location.href='/'">뒤로가기</button>
	</div>
</body>
</html>