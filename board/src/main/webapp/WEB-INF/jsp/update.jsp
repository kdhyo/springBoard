<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 게시글 작성 </h2>
 
<div class="container">
    <form action="/updateProc" method="post">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" class="form-control" id="title" name="title" value="${detail.title}">
      </div>
      <div class="form-group">
        <label for="writer">작성자</label>
        <input type="text" class="form-control" id="writer" name="writer" value="${detail.writer}">
      </div>
      <div class="form-group">
        <label for=contents">내용</label>
        <textarea class="form-control" id="contents" name="contents" rows="3">${detail.contents}</textarea>
      </div>
      <input type="hidden" name="id" value="${id}"/>
      <button type="submit" class="btn btn-primary">수정</button>
      <button type="button" class="btn btn-danger"
			onclick="javascript:history.back();">뒤로가기</button>
    </form>
</div>

<%@ include file="bootstrap.jsp" %>
</body>
</html>