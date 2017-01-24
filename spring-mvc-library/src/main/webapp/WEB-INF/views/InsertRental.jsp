<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bootstrap Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h2>도서등록</h2>
	<p>등록할 도서의 내용을 입력하세요.</p>
	<form action="InsertRental" method="post">
		<div class="form-group">
			<label>제목:</label>
			<input type="text" class="form-control" style=width:200px>
		</div>
		<div class="form-group">
			<label>종류:</label>
			<select class="form-control" style=width:120px>
		    	<option>:::선택:::</option>
		        <option>종류뿌리기</option>
		    </select>
		</div>
		<div class="form-group">
			<label>장르:</label>
			<input type="text" class="form-control" style=width:120px>
		</div>
		<div class="form-group">
			<label>저자:</label>
			<input type="text" class="form-control" style=width:120px>
		</div>
		<div class="form-group">
			<label>출판사:</label>
			<input type="text" class="form-control" style=width:120px>
		</div>
		<input type="submit" value="등록">
		<button onclick="location=''">취소</button>
	</form>
</div>

</body>
</html>
