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
	<h2>도서정보</h2>
	<div class="form-group">
		<label>제목:</label>
		<input type="text" class="form-control" style=width:200px value='${book.bmName}' readonly>
	</div>
	<div class="form-group">
		<label>종류:</label>
		<input type="text" class="form-control" style=width:120px value='${book.bmType}' readonly>
	</div>
	<div class="form-group">
		<label>저자:</label>
		<input type="text" class="form-control" style=width:120px value='${book.bmWriter}' readonly>
	</div>
	<div class="form-group">
		<label>출판사:</label>
		<input type="text" class="form-control" style=width:120px value='${book.bmPublisher}' readonly>
	</div>
	<div class="form-group">
		<label>최초대여일:</label>
		<input type="text" class="form-control" style=width:120px value='${info.biFirstrent}' readonly>
	</div>
	<div class="form-group">
		<label>대여횟수:</label>
		<input type="text" class="form-control" style=width:120px value='${info.biCount}' readonly>
	</div>
	<div class="form-group">
		<label>대여일수:</label>
		<input type="text" class="form-control" style=width:120px value='${info.biDay}' readonly>
	</div>
	<input type="button" value="목록" onclick="location='BookList'">
</div>

</body>
</html>
