<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="bootstrap.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	function readTable(item) {
		var str = "<tr class='boardList'>";
		str += "<td>" + item.id + "</td>";
		str += "<td onclick=\"location.href='/detail?id=" + item.id + "'\">" + item.title + "</td>";
		str += "<td onclick=\"location.href='/detail?id=" + item.id + "'\">" + item.writer + "</td>";
		str += "<td onclick=\"location.href='/detail?id=" + item.id + "'\">" + item.created_at + "</td>";
		if(item.updated_at !== null) {
			str += "<td onclick=\"location.href='/detail?id=" + item.id + "'\">" + item.updated_at + "</td>";
		} else {
			str += "<td onclick=\"location.href='/detail?id=" + item.id + "'\"></td>";
		}
		str += "<td><button class='btn btn-primary' onclick=\"location.href='/update/" + item.id + "'\">수정</button> ";
		str += "<button class='btn btn-danger' onclick=\"location.href='/delete/" + item.id + "'\">삭제</button></td>";
		str += "</tr>";
		
		$("table").append(str);
	}
	$(document).ready(function() {
		$.ajax('/list?nowPage=1', {
			success : function(data) {
				$.each(data.list, function(i, item) {
					readTable(item);
				});
				for(var i=data.startPage; i<=data.endPage; i++) {
					$("#pagingBtn").append("<button id='btn" + i + "' onclick='fnList(" + i + ")' class=\"btn btn-primary\">" + i + "</button>")	
				}
				if(data.endPage < data.lastPage) {
					$("#pagingBtn").append(" <button id='nextBtn' onclick='fnList("+ (data.endPage+1) +")' class=\"btn btn-primary\">Next</button>");
				}
			}
		})
	})
	
	function fnList(pageNum) {
		$.ajax('/list?nowPage=' + pageNum, {
			success: function(data) {
				$("#pagingBtn").empty();
				$(".boardList").remove();
				$.each(data.list, function(i, item) {
					readTable(item);
				});
				if(data.startPage !== 1) {
					$("#pagingBtn").append("<button id='previousBtn' onclick='fnList("+ (data.startPage-1) +")' class=\"btn btn-primary\">Previous</button> ");
				}
				for(var i=data.startPage; i<=data.endPage; i++) {
					$("#pagingBtn").append("<button id='btn" + i + "' onclick='fnList(" + i + ")' class=\"btn btn-primary\">" + i + "</button>")	
				}
				if(data.endPage < data.lastPage) {
					$("#pagingBtn").append(" <button id='nextBtn' onclick='fnList("+ (data.endPage+1) +")' class=\"btn btn-primary\">Next</button>");
				}
			}
		})
	}
</script>
<meta charset="UTF-8">
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
		</table>
		<div id="pagingBtn"></div>
	</div>
</body>
</html>