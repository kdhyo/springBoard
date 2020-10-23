<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="bootstrap.jsp"%>
<script>
$(document).ready(function() {
	$.ajax('/list?nowPage=1', {
		success : function(data) {
			$.each(data.list, function(i, item) {
				readTable(item);
			});
			addBtn(data);
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
			addBtn(data);
		}
	})
}
	
function readTable(item) {
	var str = "<tr class='boardList' id="+ item.id +">";
		str += "<td>" + item.id + "</td>";
		str += "<td>" + item.title + "</td>";
		str += "<td>" + item.writer + "</td>";
		str += "<td>" + item.created_at + "</td>";
	if(item.updated_at !== null) {
		str += "<td>" + item.updated_at + "</td>";
	} else {
		str += "<td></td>";
	}
	str += "<th><button class='btn btn-primary' onclick=\"location.href='/update/" + item.id + "'\">수정</button> ";
	str += "<button class='btn btn-danger' onclick=\"deleteBtn("+item.id+")\">삭제</button></th>";
	str += "</tr>";
		
	$("table").append(str);

	$('table').on("click", "tr>td", function() {
		location.href='/detail?id=' + $(this).closest('tr').attr('id');
	});
}
	
function addBtn(data) {
	if(data.nowPage !== 1) {
		$("#pagingBtn").append("<button id='previousBtn' onclick='fnList(1)' class=\"btn btn-primary\"><<</button> ");
		$("#pagingBtn").append("<button id='previousBtn' onclick='fnList("+ (data.nowPage - 1) +")' class=\"btn btn-primary\"><</button> ");
	}
	for(var i=data.startPage; i<=data.endPage; i++) {
		$("#pagingBtn").append("<button id='btn" + i + "' onclick='fnList(" + i + ")' class=\"btn btn-primary\">" + i + "</button>")	
	}
	if(data.nowPage < data.lastPage) {
		$("#pagingBtn").append(" <button id='nextBtn' onclick='fnList("+ (data.nowPage+1) +")' class=\"btn btn-primary\">></button>");
	}
	if(data.endPage < data.lastPage) {
		$("#pagingBtn").append(" <button id='nextBtn' onclick='fnList("+ (data.endPage+1) +")' class=\"btn btn-primary\">>></button>");
	}
}

function deleteBtn(id) {
	if(confirm("정말 삭제하시겠습니까?") === true) {
		$.ajax({
			url : '/delete/'+id,
			method : 'POST',
		}).done(function(data) {
			if (data !== null) {
				alert("삭제되었습니다.");
				location.href = "/";
			} else {
				alert("삭제되지 않았습니다.");
				location.href = "/";
			}
			return false;
		})
	}
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