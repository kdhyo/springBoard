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
    <form action="/insertProc" method="post">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
      </div>
      <div class="form-group">
        <label for="writer">작성자</label>
        <input type="text" class="form-control" id="writer" name="writer" placeholder="이름을 입력하세요.">
      </div>
      <div class="form-group">
        <label for=contents">내용</label>
        <textarea class="form-control" id="contents" name="contents" rows="3" placeholder="내용을 입력하세요."></textarea>
      </div>
      <button type="submit" class="btn btn-primary">작성</button>
    </form>
</div>

<%@ include file="bootstrap.jsp" %>
</body>
</html>