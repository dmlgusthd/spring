<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 등록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h2>도서등록</h2>
	<p>등록할 도서의 내용을 입력하세요.</p>
	<form action="InsertBook" method="post">
		<div class="form-group">
			<label>제목:</label>
			<input type="text" name="bmName" class="form-control" style=width:200px>
		</div>
		<div class="form-group">
			<label>종류:</label>
			<select class="form-control" name="bmType" style=width:120px>
		    	<option>:::선택:::</option>
		        <option>교재</option>
		        <option>예술</option>
		        <option>소설</option>
		        <option>추리</option>
		        <option>스릴러</option>
		        <option>경제/경영</option>
		        <option>잡지</option>
		        <option>자연/과학</option>
		        <option>인물</option>
		        <option>만화</option>
		        <option>사전</option>
		        <option>문학</option>
		        <option>종교</option>
		        <option>가정/생활/요리</option>
		        <option>컴퓨터</option>
		        <option>역사</option>
		        <option>사회과학</option>  
		        <option>기타</option>  
		    </select>
		</div>
		<div class="form-group">
			<label>저자:</label>
			<input type="text" name="bmWriter" class="form-control" style=width:120px>
		</div>
		<div class="form-group">
			<label>출판사:</label>
			<input type="text" name="bmPublisher" class="form-control" style=width:120px>
		</div>
		<input type="submit" value="등록">
		<input type="button" value="목록" onclick="location='BookList'">
	</form>
</div>

</body>
</html>
